package com.irvinmarin.apps.miperfilacademico.plan_academico.data.source;


import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.callbacks.GetNotasCursoListCallback;


public interface PlanAcademicoDataSource {
    void getNotasCicloUIList(int idAlumno, GetNotasCursoListCallback callback);
}
