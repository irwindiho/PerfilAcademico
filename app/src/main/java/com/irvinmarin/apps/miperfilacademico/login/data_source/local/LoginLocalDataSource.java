package com.irvinmarin.apps.miperfilacademico.login.data_source.local;


import com.irvinmarin.apps.miperfilacademico.entities.SessionUser;
import com.irvinmarin.apps.miperfilacademico.entities.Usuario;
import com.irvinmarin.apps.miperfilacademico.entities.Usuario_Table;
import com.irvinmarin.apps.miperfilacademico.login.data_source.LoginDataSource;
import com.irvinmarin.apps.miperfilacademico.login.data_source.callbacks.GetUsuarioInitCallback;
import com.irvinmarin.apps.miperfilacademico.login.domain_usecases.GetUsuarioInitUI;
import com.raizlabs.android.dbflow.sql.language.SQLite;


public class LoginLocalDataSource implements LoginDataSource {

    private final String TAG = this.getClass().getSimpleName();


    public LoginLocalDataSource() {
    }


    @Override
    public void getUsuarioUIData(GetUsuarioInitUI.RequestValues requestValues, GetUsuarioInitCallback callback) {


        Usuario usuario = SQLite.select()
                .from(Usuario.class)
                .where(Usuario_Table.username.is(requestValues.getUserName()))
                .and(Usuario_Table.password.is(requestValues.getPassword()))
                .querySingle();
        if (usuario != null) {

            SessionUser sessionUser = new SessionUser();
            sessionUser.setNombresApellidos(requestValues.getUserName());
            sessionUser.setUsuario(requestValues.getUserName());
            sessionUser.setCarrera("Ing. Sistemas");
            sessionUser.setFacutad("FIA");
            sessionUser.save();


            callback.onUsuarioCorrect(true);
        } else {
            callback.onError("");
        }
    }
}


