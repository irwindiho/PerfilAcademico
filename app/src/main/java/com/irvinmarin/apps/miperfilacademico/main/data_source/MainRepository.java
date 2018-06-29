package com.irvinmarin.apps.miperfilacademico.main.data_source;


import com.irvinmarin.apps.miperfilacademico.main.data_source.callbacks.GetUsuarioSesionCallback;
import com.irvinmarin.apps.miperfilacademico.main.data_source.local.MainLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.main.data_source.remote.MainRemoteDataSource;
import com.irvinmarin.apps.miperfilacademico.main.domain_usecases.GetUsuarioUISesion;

public class MainRepository implements MainDataSource {
    private MainLocalDataSource localDataSource;
    private MainRemoteDataSource remoteDataSource;

    public MainRepository(MainLocalDataSource localDataSource, MainRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static MainRepository getInstace(MainLocalDataSource localDataSource, MainRemoteDataSource remoteDataSource) {

        if (INSTANCE == null) {
            INSTANCE = new MainRepository(localDataSource, remoteDataSource);
        }
        return INSTANCE;
    }

    private static MainRepository INSTANCE = null;


    @Override
    public void getUsuarioSesionUIData(GetUsuarioUISesion.RequestValues requestValues, GetUsuarioSesionCallback callback) {
//        if (UtilsApp.isOnlineNet()) {
//            remoteDataSource.getUsuarioSesionUIData(requestValues, callback);
//        } else {
            localDataSource.getUsuarioSesionUIData(requestValues, callback);
//        }
    }
}
