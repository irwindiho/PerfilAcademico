package com.irvinmarin.apps.miperfilacademico.cursos.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.UtilsApp;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseHandler;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseThreadPoolScheduler;
import com.irvinmarin.apps.miperfilacademico.cursos.ContratoCursosPresenter;
import com.irvinmarin.apps.miperfilacademico.cursos.ContratoCursosPresenterImpl;
import com.irvinmarin.apps.miperfilacademico.cursos.ContratosCursosView;
import com.irvinmarin.apps.miperfilacademico.cursos.adapters.MatriculaCursosAdapter;
import com.irvinmarin.apps.miperfilacademico.cursos.ui.entities.CursosDetalleUI;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.PlanAcademicoRepository;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.local.PlanAcdemicoLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.remote.PlanAcademicoRemoteDataSource;
import com.irvinmarin.apps.miperfilacademico.plan_academico.domain.usecases.GetNotasCiclosUIList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class ContratoCursosFragment extends Fragment implements ContratosCursosView {

    ContratoCursosPresenter presenter;
    public static int idAlumno;
    Unbinder unbinder;
    @BindView(R.id.txtAnicCargaAcademica)
    TextView txtAnicCargaAcademica;
    @BindView(R.id.spnCargaAcademica)
    Spinner spnCargaAcademica;
    @BindView(R.id.rvContratoCursos)
    RecyclerView rvContratoCursos;



    public static ContratoCursosFragment newIntance(int idAlumno) {
        ContratoCursosFragment.idAlumno = idAlumno;
        return new ContratoCursosFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_contrato_cursos, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupPresenter();

        setupRvContratoCursos();
        return view;
    }



    MatriculaCursosAdapter cursosAdapter;

    private void setupRvContratoCursos() {

        cursosAdapter = new MatriculaCursosAdapter(UtilsApp.populateContratoCursosUI());
        rvContratoCursos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvContratoCursos.setAdapter(cursosAdapter);

    }

    private void setupPresenter() {

        PlanAcademicoRepository repository = PlanAcademicoRepository.getInstace(
                new PlanAcdemicoLocalDataSource(),
                new PlanAcademicoRemoteDataSource());

        presenter = new ContratoCursosPresenterImpl(new UseCaseHandler(
                new UseCaseThreadPoolScheduler()), new GetNotasCiclosUIList(repository));
        presenter.setView(this);
        presenter.onCreate();
        presenter.getContratoCursosUIList(0);
        setPresenter(presenter);
    }

    private void setPresenter(ContratoCursosPresenter presenter) {
        presenter.onCreate();
    }


    @Override
    public void showListCiclos(List<CursosDetalleUI> cursosUIList) {
        cursosAdapter.setListCiclos(cursosUIList);
    }

    @Override
    public void shoMsj(String mensaje) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
