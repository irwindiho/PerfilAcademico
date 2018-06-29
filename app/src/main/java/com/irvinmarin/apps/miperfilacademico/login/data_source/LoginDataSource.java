package com.irvinmarin.apps.miperfilacademico.login.data_source;


import com.irvinmarin.apps.miperfilacademico.login.data_source.callbacks.GetUsuarioInitCallback;
import com.irvinmarin.apps.miperfilacademico.login.domain_usecases.GetUsuarioInitUI;

public interface LoginDataSource {
    void getUsuarioUIData(GetUsuarioInitUI.RequestValues requestValues, GetUsuarioInitCallback callback);
}
