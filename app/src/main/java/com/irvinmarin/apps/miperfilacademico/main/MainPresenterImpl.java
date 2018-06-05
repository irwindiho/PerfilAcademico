package com.irvinmarin.apps.miperfilacademico.main;


import com.irvinmarin.apps.miperfilacademico.R;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    public MainPresenterImpl() {
    }


    @Override
    public void onCreate() {
        if (view != null)
            view.showInitMessage();
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
        }

    }


}
