package com.irvinmarin.apps.miperfilacademico;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.irvinmarin.apps.miperfilacademico.database.AppDatabase;
import com.irvinmarin.apps.miperfilacademico.entities.SessionUser;
import com.irvinmarin.apps.miperfilacademico.entities.Usuario;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class MiPerfilAapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this)
                .openDatabasesOnInit(true).build());
        DatabaseDefinition db = FlowManager.getDatabase(AppDatabase.class);
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        SessionUser sessionUser = new SessionUser();
        sessionUser.setNombresApellidos("Irvin Esteban Marin Cisneros");
        sessionUser.setUsuario("irvinmarin");
        sessionUser.setCarrera("Ing. Sistemas");
        sessionUser.setFacutad("FIA");
        sessionUser.save();

        Usuario newUser = new Usuario();
        newUser.setIdUsuario(sessionUser.getIdUsuario());
        newUser.setUsername("irvinmarin");
        newUser.setPassword("marin123");
        newUser.setActivo(true);
        newUser.save();

        Usuario newUser2 = new Usuario();
        newUser2.setIdUsuario(sessionUser.getIdUsuario());
        newUser2.setUsername("josemamani");
        newUser2.setPassword("jose222");
        newUser2.setActivo(true);
        newUser2.save();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(MiPerfilAapp.this);
    }

}

