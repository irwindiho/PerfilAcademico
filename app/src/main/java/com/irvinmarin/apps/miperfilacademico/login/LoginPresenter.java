package com.irvinmarin.apps.miperfilacademico.login;

import android.support.design.widget.TextInputEditText;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public interface LoginPresenter {
    void onCreate();

    void onStar();

    void onResume();

    void onDestroy();

    void setView(LoginView view);


    void validateUser(TextInputEditText txtNombreUsuario, TextInputEditText txtPassUsuario);
}
