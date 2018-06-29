package com.irvinmarin.apps.miperfilacademico.main.data_source.local;


import com.irvinmarin.apps.miperfilacademico.entities.SessionUser;
import com.irvinmarin.apps.miperfilacademico.entities.Usuario;
import com.irvinmarin.apps.miperfilacademico.main.data_source.MainDataSource;
import com.irvinmarin.apps.miperfilacademico.main.data_source.callbacks.GetUsuarioSesionCallback;
import com.irvinmarin.apps.miperfilacademico.main.domain_usecases.GetUsuarioUISesion;
import com.raizlabs.android.dbflow.sql.language.SQLite;


public class MainLocalDataSource implements MainDataSource {

    private final String TAG = this.getClass().getSimpleName();


    public MainLocalDataSource() {
    }


    @Override
    public void getUsuarioSesionUIData(GetUsuarioUISesion.RequestValues requestValues, GetUsuarioSesionCallback callback) {

        SessionUser sessionUser = SQLite.select()
                .from(SessionUser.class)
//                .where(Usuario_Table.)
                .querySingle();
        Usuario usuario = SQLite.select()
                .from(Usuario.class)
//                .where(Usuario_Table.)
//                .and(Usuario_Table.)
                .querySingle();

        if (usuario != null) {

//            callback.onUsuarioSesionLoaded(true);
        } else {
            callback.onError("Error");
        }

    }
}


