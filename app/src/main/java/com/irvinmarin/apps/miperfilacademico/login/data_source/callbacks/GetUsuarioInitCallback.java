package com.irvinmarin.apps.miperfilacademico.login.data_source.callbacks;





public interface GetUsuarioInitCallback {
    void onUsuarioCorrect(boolean isSuccess);

    void onError(String error);


}
