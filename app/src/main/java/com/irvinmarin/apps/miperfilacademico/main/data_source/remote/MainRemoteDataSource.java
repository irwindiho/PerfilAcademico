package com.irvinmarin.apps.miperfilacademico.main.data_source.remote;

import android.content.Context;

import com.irvinmarin.apps.miperfilacademico.asyntasks.login.LoginListenerService;
import com.irvinmarin.apps.miperfilacademico.main.data_source.MainDataSource;
import com.irvinmarin.apps.miperfilacademico.main.data_source.callbacks.GetUsuarioSesionCallback;
import com.irvinmarin.apps.miperfilacademico.main.domain_usecases.GetUsuarioUISesion;

public class MainRemoteDataSource implements MainDataSource {
    private static final String TAG = MainRemoteDataSource.class.getSimpleName();

    private LoginListenerService loginInterface;
    private Context context;

    public MainRemoteDataSource() {

    }


    @Override
    public void getUsuarioSesionUIData(GetUsuarioUISesion.RequestValues requestValues, GetUsuarioSesionCallback callback) {
//        new LoginAsyntask(loginInterface, context).execute(, requestValues.getPassword());

    }
}
