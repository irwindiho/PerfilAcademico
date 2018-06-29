package com.irvinmarin.apps.miperfilacademico.asyntasks.login;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irvinmarin.apps.miperfilacademico.UtilsApp;
import com.irvinmarin.apps.miperfilacademico.api.RestAPI;
import com.irvinmarin.apps.miperfilacademico.entities.Usuario;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;

import org.json.JSONObject;

import java.util.List;


/**
 * Created by irvinmarin on 28/04/2017.
 */

public class LoginAsyntask extends AsyncTask<String, String, String> {


    private static final String TAG = "LoginAsyntask";


    private LoginListenerService loginInterface;
    private Context context;
    private ObjectMapper mapper;
    int estado = 0;
    private DatabaseDefinition database;


    public LoginAsyntask(LoginListenerService loginInterface, Context context) {
        this.loginInterface = loginInterface;
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {
        Log.d(TAG, "doInBackground");
        int estado;
        Usuario usuario;

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            String username = params[0];
            String password = params[1];
            RestAPI restAPI = RestAPI.getInstance();
            JSONObject jsonObject = restAPI.fobj_ObtenerUsuario(username, password);
            Log.d(TAG, jsonObject.toString());
            if (UtilsApp.isSuccess(jsonObject)) {
                usuario = mapper.readValue(UtilsApp.getJsonObResult(jsonObject), Usuario.class);

                manipulateInTransaction(usuario);
                estado = 1;

            } else {
                estado = -1;
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            estado = -2;
        }
        return null;
    }

    private <T extends BaseModel> void fastStoreList(Class<T> clazz, List<T> list) {
        if (list != null && !list.isEmpty()) {
            FastStoreModelTransaction fastStoreModelTransaction = FastStoreModelTransaction
                    .insertBuilder(FlowManager.getModelAdapter(clazz))
                    .addAll(list)
                    .build();
            database.beginTransactionAsync(fastStoreModelTransaction).build().execute();
        }
    }


    private void manipulateInTransaction(Usuario usuario) {
//        fastStoreList(Entidad.class, usuario.getEntidades());
//        fastStoreList(Georeferencia.class, usuario.getGeoreferencias());
//        fastStoreList(Rol.class, usuario.getRoles());
//        fastStoreList(UsuarioRolGeoreferencia.class, usuario.getUsuarioRolGeoreferencias());
//        fastStoreList(PersonaGeoreferencia.class, usuario.getPersonaGeoreferencias());
//        fastStoreList(UsuarioAcceso.class, usuario.getAccesos());
    }

    @Override
    protected void onPostExecute(String s) {
        switch (estado) {
            case 1:
                loginInterface.loginCorrecto("SuccessFull");
                break;
            case -1:
                loginInterface.loginError("Error: No se exportaron los datos al Servidor");
                break;
            case -2:
                loginInterface.loginErrorProcedimiento("Error -2 ");
        }
        Log.d(TAG, "estado: " + estado);
        super.onPostExecute(s);
    }
}
