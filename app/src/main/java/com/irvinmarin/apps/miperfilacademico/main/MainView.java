package com.irvinmarin.apps.miperfilacademico.main;

import android.support.v4.app.Fragment;

import com.irvinmarin.apps.miperfilacademico.main.ui.entities.UsuarioUI;


/**
 * Created by irvinmarin on 10/05/2018.
 */

public interface MainView {

    void showPlanAcademico();

    void showEstadoFinanciero();

    void showInitMessage();

    void hideInitMessage();

    void showMatriculaCursos();

    void hidePorgress(String msj);

    void showPorgress(String msj);

    void showMsj(String msj);

    void setDataForUser(UsuarioUI usuarioUI);

    void showLogin();
}
