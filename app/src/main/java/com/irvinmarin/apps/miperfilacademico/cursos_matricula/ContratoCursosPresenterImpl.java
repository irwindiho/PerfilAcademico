package com.irvinmarin.apps.miperfilacademico.cursos_matricula;


import android.util.Log;

import com.irvinmarin.apps.miperfilacademico.base.UseCase;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseHandler;
import com.irvinmarin.apps.miperfilacademico.plan_academico.domain.usecases.GetNotasCiclosUIList;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class ContratoCursosPresenterImpl implements ContratoCursosPresenter {

    private final String TAG = this.getClass().getSimpleName();
    private ContratosCursosView view;
    UseCaseHandler handler;
    GetNotasCiclosUIList getNotasCiclosUIList;

    public ContratoCursosPresenterImpl(UseCaseHandler handler, GetNotasCiclosUIList getNotasCiclosUIList) {
        this.handler = handler;
        this.getNotasCiclosUIList = getNotasCiclosUIList;
    }

    @Override
    public void onCreate() {

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStar() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void setView(ContratosCursosView view) {
        this.view = view;
    }

    @Override
    public void getContratoCursosUIList(int idAlumno) {
//        handler.execute(getNotasCiclosUIList, new GetNotasCiclosUIList.RequestValues(idAlumno), new UseCase.UseCaseCallback<GetNotasCiclosUIList.ResponseValue>() {
//            @Override
//            public void onSuccess(GetNotasCiclosUIList.ResponseValue response) {
//                if (view != null) view.showListCiclos(response.getCiclosUIList());
//            }
//
//            @Override
//            public void onError() {
//                if (view != null) view.shoMsj("No se Encontraron Notas de Cursos");
//            }
//        });


    }


}
