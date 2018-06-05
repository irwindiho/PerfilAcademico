package com.irvinmarin.apps.miperfilacademico.plan_academico.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseHandler;
import com.irvinmarin.apps.miperfilacademico.base.UseCaseThreadPoolScheduler;
import com.irvinmarin.apps.miperfilacademico.plan_academico.NotasCursosPresenter;
import com.irvinmarin.apps.miperfilacademico.plan_academico.NotasCursosPresenterImpl;
import com.irvinmarin.apps.miperfilacademico.plan_academico.NotasCursosView;
import com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.MyFragmentPageAdapter;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.PlanAcademicoRepository;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.local.PlanAcdemicoLocalDataSource;
import com.irvinmarin.apps.miperfilacademico.plan_academico.data.source.remote.PlanAcademicoRemoteDataSource;
import com.irvinmarin.apps.miperfilacademico.plan_academico.domain.usecases.GetNotasCiclosUIList;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.tabs_item.CursosFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class TabsPlanAcademicoFragment extends Fragment implements NotasCursosView {

    NotasCursosPresenter presenter;
    public static int idAlumno;
    @BindView(R.id.tablCiclos)
    TabLayout tablCiclos;
    Unbinder unbinder;
    @BindView(R.id.vpCiclos)
    ViewPager vpCiclos;

    public static TabsPlanAcademicoFragment newIntance(int idAlumno) {
        TabsPlanAcademicoFragment.idAlumno = idAlumno;
        return new TabsPlanAcademicoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_plan_academico, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupPresenter();
//        setupRvCursos();
        return view;
    }

    private void setupPresenter() {

        PlanAcademicoRepository repository = PlanAcademicoRepository.getInstace(
                new PlanAcdemicoLocalDataSource(),
                new PlanAcademicoRemoteDataSource());

        presenter = new NotasCursosPresenterImpl(new UseCaseHandler(
                new UseCaseThreadPoolScheduler()), new GetNotasCiclosUIList(repository));
        presenter.setView(this);
        presenter.onCreate();
        presenter.getCiclosNotasUIList(0);
        setPresenter(presenter);
    }

    private void setPresenter(NotasCursosPresenter presenter) {
        presenter.onCreate();
    }


    @Override
    public void showListCiclos(List<CiclosUI> ciclosUIList) {
        setupTabsCiclos(ciclosUIList);
    }

    private void setupTabsCiclos(List<CiclosUI> ciclosUIList) {


        MyFragmentPageAdapter fragmentAdapter = new MyFragmentPageAdapter(getChildFragmentManager());

        for (CiclosUI ciclosUI : ciclosUIList) {
            fragmentAdapter.addFragment(CursosFragment.newInstance(ciclosUI.getCursosUIList(), idAlumno), ciclosUI.getNombreCiclo());
        }

//        vpCiclos.setOffscreenPageLimit(2);
        vpCiclos.setAdapter(fragmentAdapter);
        vpCiclos.setOffscreenPageLimit(1);
        tablCiclos.setupWithViewPager(vpCiclos);
        vpCiclos.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablCiclos));
        tablCiclos.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpCiclos.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void shoMsj(String mensaje) {
        Snackbar.make(tablCiclos.getRootView(), mensaje, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
