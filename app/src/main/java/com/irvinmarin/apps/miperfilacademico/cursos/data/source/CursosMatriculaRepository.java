package com.irvinmarin.apps.miperfilacademico.cursos.data.source;


import com.irvinmarin.apps.miperfilacademico.cursos.data.source.callbacks.GetNotasMatriuclaCursoListCallback;
import com.irvinmarin.apps.miperfilacademico.cursos.data.source.local.CursosMatriculaLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.cursos.data.source.remote.CursosMatriculaRemoteDataSource;

public class CursosMatriculaRepository implements CursosMatriculaDataSource {
    private CursosMatriculaLocalDataSource localDataSource;
    private CursosMatriculaRemoteDataSource remoteDataSource;

    public CursosMatriculaRepository(CursosMatriculaLocalDataSource localDataSource, CursosMatriculaRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static CursosMatriculaRepository getInstace(CursosMatriculaLocalDataSource localDataSource, CursosMatriculaRemoteDataSource remoteDataSource) {

        if (INSTANCE == null) {
            INSTANCE = new CursosMatriculaRepository(localDataSource, remoteDataSource);
        }
        return INSTANCE;
    }

    private static CursosMatriculaRepository INSTANCE = null;


    @Override
    public void getNotasCicloUIList(int idAlumno, GetNotasMatriuclaCursoListCallback callback) {
        localDataSource.getNotasCicloUIList(idAlumno, callback);
    }
}
