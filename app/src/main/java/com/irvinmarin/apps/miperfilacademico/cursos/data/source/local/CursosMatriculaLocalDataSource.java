package com.irvinmarin.apps.miperfilacademico.cursos.data.source.local;


import com.irvinmarin.apps.miperfilacademico.UtilsApp;
import com.irvinmarin.apps.miperfilacademico.cursos.data.source.CursosMatriculaDataSource;
import com.irvinmarin.apps.miperfilacademico.cursos.data.source.callbacks.GetNotasMatriuclaCursoListCallback;


public class CursosMatriculaLocalDataSource implements CursosMatriculaDataSource {

    private final String TAG = this.getClass().getSimpleName();


    public CursosMatriculaLocalDataSource() {
    }


    @Override
    public void getNotasCicloUIList(int idAlumno, GetNotasMatriuclaCursoListCallback callback) {
        callback.onNotasCursosListLoaded(UtilsApp.populateCiclosUI());
    }
}


