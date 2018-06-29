package com.irvinmarin.apps.miperfilacademico.cursos.data.source;


import com.irvinmarin.apps.miperfilacademico.cursos.data.source.callbacks.GetNotasMatriuclaCursoListCallback;

public interface CursosMatriculaDataSource {
    void getNotasCicloUIList(int idAlumno, GetNotasMatriuclaCursoListCallback callback);
}
