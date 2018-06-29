package com.irvinmarin.apps.miperfilacademico.login.data_source.remote;

import android.content.Context;

import com.irvinmarin.apps.miperfilacademico.asyntasks.login.LoginAsyntask;
import com.irvinmarin.apps.miperfilacademico.asyntasks.login.LoginListenerService;
import com.irvinmarin.apps.miperfilacademico.login.data_source.LoginDataSource;
import com.irvinmarin.apps.miperfilacademico.login.data_source.callbacks.GetUsuarioInitCallback;
import com.irvinmarin.apps.miperfilacademico.login.domain_usecases.GetUsuarioInitUI;

public class LoginRemoteDataSource implements LoginDataSource {
    private static final String TAG = LoginRemoteDataSource.class.getSimpleName();

    private LoginListenerService loginInterface;
    private Context context;

    public LoginRemoteDataSource(LoginListenerService loginInterface, Context context) {
        this.loginInterface = loginInterface;
        this.context = context;
    }


    @Override
    public void getUsuarioUIData(GetUsuarioInitUI.RequestValues requestValues, GetUsuarioInitCallback callback) {
        new LoginAsyntask(loginInterface, context).execute(requestValues.getUserName(), requestValues.getPassword());

    }
}
