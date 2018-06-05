package com.irvinmarin.apps.miperfilacademico.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.main.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 28/05/2018.
 */

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.txtNombreUsuario)
    TextInputEditText txtNombreUsuario;
    @BindView(R.id.txtPassUsuario)
    TextInputEditText txtPassUsuario;
    @BindView(R.id.fabSalir)
    FloatingActionButton fabSalir;
    @BindView(R.id.fabIngresar)
    FloatingActionButton fabIngresar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.fabSalir, R.id.fabIngresar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fabSalir:
                finish();

                break;
            case R.id.fabIngresar:
                MainActivity.launchNewInstace(this);
                break;
        }
    }
}
