package com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.callbacks;


import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;

import java.util.List;


public interface GetNotasCursoListCallback {
    void onNotasCursosListLoaded(List<CiclosUI> ciclosUIList);

    void onError(String error);


}
