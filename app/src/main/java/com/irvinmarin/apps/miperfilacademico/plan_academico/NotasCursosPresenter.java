package com.irvinmarin.apps.miperfilacademico.plan_academico;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public interface NotasCursosPresenter {
    void onCreate();

    void onStar();

    void onResume();

    void onDestroy();

    void setView(NotasCursosView view);


    void getCiclosNotasUIList(int idAlumno);
}
