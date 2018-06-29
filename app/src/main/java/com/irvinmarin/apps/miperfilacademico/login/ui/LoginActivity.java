package com.irvinmarin.apps.miperfilacademico.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.asyntasks.login.LoginListenerService;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseHandler;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseThreadPoolScheduler;
import com.irvinmarin.apps.miperfilacademico.login.LoginPresenter;
import com.irvinmarin.apps.miperfilacademico.login.LoginPresenterImpl;
import com.irvinmarin.apps.miperfilacademico.login.LoginView;
import com.irvinmarin.apps.miperfilacademico.login.data_source.LoginRepository;
import com.irvinmarin.apps.miperfilacademico.login.data_source.local.LoginLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.login.data_source.remote.LoginRemoteDataSource;
import com.irvinmarin.apps.miperfilacademico.login.domain_usecases.GetUsuarioInitUI;
import com.irvinmarin.apps.miperfilacademico.main.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 28/05/2018.
 */

public class LoginActivity extends AppCompatActivity implements LoginView, LoginListenerService {


    @BindView(R.id.txtNombreUsuario)
    TextInputEditText txtNombreUsuario;
    @BindView(R.id.txtPassUsuario)
    TextInputEditText txtPassUsuario;
    @BindView(R.id.fabSalir)
    FloatingActionButton fabSalir;
    @BindView(R.id.fabIngresar)
    FloatingActionButton fabIngresar;
    LoginPresenter presenter;
    @BindView(R.id.progress)
    ProgressBar progress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupPresenter();

    }

    private void setupPresenter() {
        presenter = new LoginPresenterImpl(
                new UseCaseHandler(
                        new UseCaseThreadPoolScheduler()),
                new GetUsuarioInitUI(LoginRepository.getInstace(
                        new LoginLocalDataSource(),
                        new LoginRemoteDataSource(this, this))));
        setPresenter();
    }

    private void setPresenter() {
        presenter.setView(this);
    }

    @OnClick({R.id.fabSalir, R.id.fabIngresar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fabSalir:
                finish();

                break;
            case R.id.fabIngresar:
                presenter.validateUser(txtNombreUsuario, txtPassUsuario);
                break;
        }
    }


    @Override
    public void enableImputs(boolean enable) {
        txtNombreUsuario.setEnabled(enable);
        txtPassUsuario.setEnabled(enable);
        fabIngresar.setEnabled(enable);
    }

    @Override
    public void showMsj(String mensaje) {
        Snackbar.make(txtNombreUsuario.getRootView(), mensaje, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showProgress(String mensaje) {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePorgress(String mensaje) {
        progress.setVisibility(View.GONE);

    }

    @Override
    public void showMainActivity() {
        MainActivity.launchNewInstace(this);
        finish();
    }

    @Override
    public void clearImputs() {
        txtNombreUsuario.setText("");
        txtPassUsuario.setText("");
    }

    @Override
    public void loginCorrecto(String mensaje) {

    }

    @Override
    public void loginError(String mensaje) {

    }

    @Override
    public void loginErrorProcedimiento(String mensaje) {

    }


    public static void launch(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
