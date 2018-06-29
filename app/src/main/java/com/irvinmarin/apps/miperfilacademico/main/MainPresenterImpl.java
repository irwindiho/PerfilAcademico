package com.irvinmarin.apps.miperfilacademico.main;


import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.base.UseCase;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseHandler;
import com.irvinmarin.apps.miperfilacademico.entities.SessionUser;
import com.irvinmarin.apps.miperfilacademico.main.domain_usecases.GetUsuarioUISesion;
import com.raizlabs.android.dbflow.sql.language.SQLite;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private UseCaseHandler handler;
    private GetUsuarioUISesion getUsuarioUISesion;

    public MainPresenterImpl(UseCaseHandler handler, GetUsuarioUISesion getUsuarioUISesion) {
        this.handler = handler;
        this.getUsuarioUISesion = getUsuarioUISesion;
    }

    @Override
    public void onCreate() {
        if (view != null)
            view.showPorgress("");
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
    public void setView(MainView view) {
        this.view = view;
    }

    @Override
    public void navigationItemSelected(int itemId) {
        view.hideInitMessage();
        switch (itemId) {
            case R.id.nav_plan_academico:
                if (view != null) view.showPlanAcademico();
                break;
            case R.id.nav_estado_financiero:
                if (view != null) view.showEstadoFinanciero();
                break;
            case R.id.nav_cursos_matriculados:
                if (view != null) view.showMatriculaCursos();
                break;
            case R.id.nav_salir:
                if (view != null)

                    SQLite.delete().from(SessionUser.class).query();
                view.showLogin();
                break;
        }

    }

    @Override
    public void onObtenerUserSesion() {
        handler.execute(getUsuarioUISesion,
                new GetUsuarioUISesion.RequestValues(), new UseCase.UseCaseCallback<GetUsuarioUISesion.ResponseValue>() {
                    @Override
                    public void onSuccess(GetUsuarioUISesion.ResponseValue response) {
                        if (view != null) {
//                            view.setDataForUser(response.getUsuarioUI());
                            view.hidePorgress("");
                        }
                    }

                    @Override
                    public void onError() {
                        if (view != null) {
                            view.hidePorgress("");
                            view.showLogin();
                        }
                    }
                });

    }


}
