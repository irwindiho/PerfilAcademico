package com.irvinmarin.apps.miperfilacademico.cursos.data.source.callbacks;


import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;

import java.util.List;


public interface GetNotasMatriuclaCursoListCallback {
    void onNotasCursosListLoaded(List<CiclosUI> ciclosUIList);

    void onError(String error);


}
