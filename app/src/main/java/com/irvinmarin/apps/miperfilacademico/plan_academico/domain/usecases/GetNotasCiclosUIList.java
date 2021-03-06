package com.irvinmarin.apps.miperfilacademico.plan_academico.domain.usecases;


import com.irvinmarin.apps.miperfilacademico.base.UseCase;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.PlanAcademicoRepository;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.callbacks.GetNotasCursoListCallback;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;

import java.util.List;

/**
 * Created by irvinmarin on 03/10/2017.
 */

public class GetNotasCiclosUIList extends UseCase<GetNotasCiclosUIList.RequestValues, GetNotasCiclosUIList.ResponseValue> {

    private PlanAcademicoRepository repository;

    public GetNotasCiclosUIList(PlanAcademicoRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        repository.getNotasCicloUIList(requestValues.getIdAlumno(),
                new GetNotasCursoListCallback() {

                    @Override
                    public void onNotasCursosListLoaded(List<CiclosUI> ciclosUIList) {
                        getUseCaseCallback().onSuccess(new ResponseValue(ciclosUIList));
                    }

                    @Override
                    public void onError(String error) {
                        getUseCaseCallback().onError();
                    }
                });

    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final int idAlumno;

        public RequestValues(int idAlumno) {
            this.idAlumno = idAlumno;
        }

        public int getIdAlumno() {
            return idAlumno;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final List<CiclosUI> ciclosUIList;

        public ResponseValue(List<CiclosUI> ciclosUIList) {
            this.ciclosUIList = ciclosUIList;
        }

        public List<CiclosUI> getCiclosUIList() {
            return ciclosUIList;
        }
    }
}
