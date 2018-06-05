package com.irvinmarin.apps.miperfilacademico.plan_academico.ui.tabs_item;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.CursosAdapter;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CursosUI;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by irvinmarin on 29/05/2018.
 */

public class CursosFragment extends Fragment {


    private static final String TAG = CursosFragment.class.getSimpleName();
    private int idAlumno;
    private List<CursosUI> cursosUIList;
    @BindView(R.id.rvCursos)
    RecyclerView rvCursos;
    Unbinder unbinder;

    public static CursosFragment newInstance(List<CursosUI> cursosUIList, int idAlumno) {
//        CicloUIFragment.idAlumno = idAlumno;
//        CicloUIFragment.cursosUIList = cursosUIList;
        Bundle bundle = new Bundle();
        bundle.putSerializable("list_cursos", (Serializable) cursosUIList);
        bundle.putInt("idAlumno", idAlumno);

        Log.d(TAG, "newInstance: ");
        Log.d(TAG, "cursosUIList: " + cursosUIList.toString());
        CursosFragment cicloUIFragment = new CursosFragment();
        cicloUIFragment.setArguments(bundle);
        return cicloUIFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idAlumno = getArguments().getInt("idAlumno");
            cursosUIList = (List<CursosUI>) getArguments().getSerializable("list_cursos");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_item_ciclo, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupRVcursos();
        return view;
    }

    CursosAdapter cursosAdapter;

    private void setupRVcursos() {
        Log.d(TAG, "setupRVcursos: " + cursosUIList.toString());
        cursosAdapter = new CursosAdapter(cursosUIList);
        rvCursos.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvCursos.setAdapter(cursosAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
