package com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.local;


import com.irvinmarin.apps.miperfilacademico.UtilsApp;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.PlanAcademicoDataSource;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.callbacks.GetNotasCursoListCallback;


public class PlanAcdemicoLocalDataSource implements PlanAcademicoDataSource {

    private final String TAG = this.getClass().getSimpleName();


    public PlanAcdemicoLocalDataSource() {
    }


    @Override
    public void getNotasCicloUIList(int idAlumno, GetNotasCursoListCallback callback) {
        callback.onNotasCursosListLoaded(UtilsApp.populateCiclosUI());
    }
}


