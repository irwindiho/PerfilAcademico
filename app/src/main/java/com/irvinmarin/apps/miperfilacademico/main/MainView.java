package com.irvinmarin.apps.miperfilacademico.main;

import android.support.v4.app.Fragment;


/**
 * Created by irvinmarin on 10/05/2018.
 */

public interface MainView {

    void showPlanAcademico();

    void showEstadoFinanciero();

    void showInitMessage();

    void hideInitMessage();

    void showMatriculaCursos();
}
