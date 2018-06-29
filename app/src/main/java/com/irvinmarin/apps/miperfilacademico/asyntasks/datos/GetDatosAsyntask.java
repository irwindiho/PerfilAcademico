package com.irvinmarin.apps.miperfilacademico.asyntasks.datos;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irvinmarin.apps.miperfilacademico.UtilsApp;
import com.irvinmarin.apps.miperfilacademico.api.RestAPI;
import com.irvinmarin.apps.miperfilacademico.asyntasks.datos.entities.BEDatos;
import com.irvinmarin.apps.miperfilacademico.database.AppDatabase;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;

import org.json.JSONObject;

import java.util.Date;
import java.util.List;


/**
 * Created by irvinmarin on 28/04/2017.
 */

public class GetDatosAsyntask extends AsyncTask<Integer, Integer, String> {
    private static final String TAG = "GetDatosAsyntask";


    private JSONObject jsonObject = null;
    private GetDatosInterface listener;
    private RestAPI restAPI;
    private Context context;
    private ObjectMapper mapper;
    private BEDatos beDatosEnvio;
    private int estado = -1;
    DatabaseDefinition database;

    public GetDatosAsyntask(GetDatosInterface getDatosInterface, Context context) {
        Log.d(TAG, "GetDatosAsyntask");
        this.listener = getDatosInterface;
        database = FlowManager.getDatabase(AppDatabase.class);
        restAPI = RestAPI.getInstance();
        this.context = context;
    }

    int count = 1;

    @Override
    protected String doInBackground(Integer... params) {
        Log.d(TAG, "doInBackground time: " + new Date().getTime());
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {

            jsonObject = restAPI.flst_ObtenerDatos(params[0]);
            Log.d(TAG, "json returned time: " + new Date().getTime());

            if (UtilsApp.isSuccess(jsonObject)) {
                Log.d(TAG, "mapper readValue time: " + new Date().getTime());
                beDatosEnvio = mapper.readValue(UtilsApp.getJsonObResult(jsonObject), BEDatos.class);
                Log.d(TAG, "mapper readValue end time: " + new Date().getTime());
                if (beDatosEnvio != null) {
                    manipulateInTransaction(params[0]);
                } else {
                    estado = -1;
                }
            } else {
                estado = -2;
            }
        } catch (Exception e) {
            estado = -2;
        }
        //  }
        return null;
    }


    private <T extends BaseModel> void fastStoreList(final Class<T> clazz, List<T> list) {
        if (list != null && !list.isEmpty()) {
            FastStoreModelTransaction fastStoreModelTransaction = FastStoreModelTransaction
                    .insertBuilder(FlowManager.getModelAdapter(clazz))
                    .addAll(list)
                    .build();
            database
                    .beginTransactionAsync(fastStoreModelTransaction)
                    .error(new Transaction.Error() {
                        @Override
                        public void onError(@NonNull Transaction transaction, @NonNull Throwable error) {
                            Log.d(TAG, "fastStoreList onError: " + error.getMessage());
                            estado = -1;
                            listener.GetDatosError("Error");
                        }
                    })
                    .build()
                    .execute();
        }
    }


    private void fireListenerInf(int informationLoadingType) {
        if (listener != null) {
            listener.onProgressInformationChanged(informationLoadingType);
        }
    }

    private void manipulateInTransaction(int idUs) {
        Log.d(TAG, "manipulateInTransaction init time: " + new Date().getTime());

        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
//                fastStoreList(T_GC_REL_UNIDAD_EVENTO_COMPETENCIA_DESEMPENIO_ICD.class, beDatosEnvio.getRel_unidad_evento_competencia_desempenio_icd());


                Log.d(TAG, "manipulate end....");
            }
        })
                .success(new Transaction.Success() {
                    @Override
                    public void onSuccess(@NonNull Transaction transaction) {
                        Log.d(TAG, "manipulate onSuccess");
                        estado = 1;
                        listener.GetDatosCorrecto("Success");
                    }
                })
                .error(new Transaction.Error() {
                    @Override
                    public void onError(@NonNull Transaction transaction, @NonNull Throwable error) {
                        Log.d(TAG, "manipulate onError");
                        estado = -1;
                        listener.GetDatosError("Error");
                    }
                })
                .build();
        transaction.execute(); // execute
        //Log.d(TAG, "Objeto: " + beDatosEnvio.toString());
        Log.d(TAG, "manipulateInTransaction end time: " + new Date().getTime());
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onPostExecute(String s) {
        switch (estado) {
            case 1:
                listener.GetDatosCorrecto("SuccessFull");
                break;
            case -1:
                listener.GetDatosError("Error: No se exportaron los datos al Servidor");
                break;
            case -2:
                listener.GetDatosErrorProcedimiento("Error -2 ");
        }
        Log.d(TAG, "estado: " + estado);
        super.onPostExecute(s);
    }


}