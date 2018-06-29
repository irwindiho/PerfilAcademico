package com.irvinmarin.apps.miperfilacademico.main.data_source.callbacks;


import com.irvinmarin.apps.miperfilacademico.main.ui.entities.UsuarioUI;

public interface GetUsuarioSesionCallback {
    void onUsuarioSesionLoaded(UsuarioUI usuarioUI);

    void onError(String error);


}
