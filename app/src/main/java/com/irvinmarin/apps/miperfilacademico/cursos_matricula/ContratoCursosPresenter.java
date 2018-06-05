package com.irvinmarin.apps.miperfilacademico.cursos_matricula;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public interface ContratoCursosPresenter {
    void onCreate();

    void onStar();

    void onResume();

    void onDestroy();

    void setView(ContratosCursosView view);


    void getContratoCursosUIList(int idAlumno);
}
