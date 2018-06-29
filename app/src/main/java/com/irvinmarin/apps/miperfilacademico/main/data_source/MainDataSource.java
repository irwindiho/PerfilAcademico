package com.irvinmarin.apps.miperfilacademico.main.data_source;



import com.irvinmarin.apps.miperfilacademico.main.data_source.callbacks.GetUsuarioSesionCallback;
import com.irvinmarin.apps.miperfilacademico.main.domain_usecases.GetUsuarioUISesion;

public interface MainDataSource {
    void getUsuarioSesionUIData(GetUsuarioUISesion.RequestValues requestValues, GetUsuarioSesionCallback callback);
}
