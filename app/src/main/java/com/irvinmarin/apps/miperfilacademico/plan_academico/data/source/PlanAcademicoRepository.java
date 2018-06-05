package com.irvinmarin.apps.miperfilacademico.plan_academico.data.source;


import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.callbacks.GetNotasCursoListCallback;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.local.PlanAcdemicoLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.remote.PlanAcademicoRemoteDataSource;


public class PlanAcademicoRepository implements PlanAcademicoDataSource {
    private PlanAcdemicoLocalDataSource localDataSource;
    private PlanAcademicoRemoteDataSource remoteDataSource;

    public PlanAcademicoRepository(PlanAcdemicoLocalDataSource localDataSource, PlanAcademicoRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static PlanAcademicoRepository getInstace(PlanAcdemicoLocalDataSource localDataSource, PlanAcademicoRemoteDataSource remoteDataSource) {

        if (INSTANCE == null) {
            INSTANCE = new PlanAcademicoRepository(localDataSource, remoteDataSource);
        }
        return INSTANCE;
    }

    private static PlanAcademicoRepository INSTANCE = null;


    @Override
    public void getNotasCicloUIList(int idAlumno, GetNotasCursoListCallback callback) {
        localDataSource.getNotasCicloUIList(idAlumno, callback);
    }
}
