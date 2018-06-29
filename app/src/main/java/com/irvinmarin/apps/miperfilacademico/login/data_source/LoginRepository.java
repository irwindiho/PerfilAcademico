package com.irvinmarin.apps.miperfilacademico.login.data_source;


import com.irvinmarin.apps.miperfilacademico.login.data_source.callbacks.GetUsuarioInitCallback;
import com.irvinmarin.apps.miperfilacademico.login.data_source.local.LoginLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.login.data_source.remote.LoginRemoteDataSource;
import com.irvinmarin.apps.miperfilacademico.login.domain_usecases.GetUsuarioInitUI;

public class LoginRepository implements LoginDataSource {
    private LoginLocalDataSource localDataSource;
    private LoginRemoteDataSource remoteDataSource;

    public LoginRepository(LoginLocalDataSource localDataSource, LoginRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static LoginRepository getInstace(LoginLocalDataSource localDataSource, LoginRemoteDataSource remoteDataSource) {

        if (INSTANCE == null) {
            INSTANCE = new LoginRepository(localDataSource, remoteDataSource);
        }
        return INSTANCE;
    }

    private static LoginRepository INSTANCE = null;


    @Override
    public void getUsuarioUIData(GetUsuarioInitUI.RequestValues requestValues, GetUsuarioInitCallback callback) {
//        if (UtilsApp.isOnlineNet()) {
//            remoteDataSource.getUsuarioUIData(requestValues, callback);
//        } else {
            localDataSource.getUsuarioUIData(requestValues, callback);
//        }
    }
}
