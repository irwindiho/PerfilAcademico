package com.irvinmarin.apps.miperfilacademico.login;


import android.support.design.widget.TextInputEditText;
import android.util.Log;

import com.irvinmarin.apps.miperfilacademico.base.UseCase;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseHandler;
import com.irvinmarin.apps.miperfilacademico.login.domain_usecases.GetUsuarioInitUI;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private LoginView view;
    private UseCaseHandler handler;
    private GetUsuarioInitUI getUsuarioUIList;

    public LoginPresenterImpl(UseCaseHandler handler, GetUsuarioInitUI getUsuarioUIList) {
        this.handler = handler;
        this.getUsuarioUIList = getUsuarioUIList;
    }

    @Override
    public void onCreate() {

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStar() {
        Log.d(TAG, "onStar: ");
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void setView(LoginView view) {
        this.view = view;
    }

    private int nroErrors = 0;

    @Override
    public void validateUser(TextInputEditText txtNombreUsuario, TextInputEditText txtPassUsuario) {
        nroErrors = 0;
        if (view != null) view.showProgress("");
        validateField(txtNombreUsuario);
        validateField(txtPassUsuario);
        if (nroErrors == 0) {
            obtenerUsuario(txtNombreUsuario.getText().toString(), txtPassUsuario.getText().toString());

        }
        view.hidePorgress("");
    }


    private void showActivityMain() {
        if (view != null) {
            view.showMainActivity();
        }
    }

    private void validateField(TextInputEditText txt) {
        if (txt.getText().toString().equals("")) {
            nroErrors++;
            txt.setError("Ingrese este campo");
        }
    }


    public void obtenerUsuario(String userName, String password) {
        handler.execute(getUsuarioUIList, new GetUsuarioInitUI.RequestValues(userName, password), new UseCase.UseCaseCallback<GetUsuarioInitUI.ResponseValue>() {
            @Override
            public void onSuccess(GetUsuarioInitUI.ResponseValue response) {
                if (view != null) {
                    view.hidePorgress("");
                    view.enableImputs(response.isSuccess());
                    showActivityMain();
                }
            }

            @Override
            public void onError() {
                if (view != null) {
                    view.hidePorgress("");
                    view.showMsj("No se Encontro el Usuario");
                    view.clearImputs();
                }
            }
        });


    }


}
