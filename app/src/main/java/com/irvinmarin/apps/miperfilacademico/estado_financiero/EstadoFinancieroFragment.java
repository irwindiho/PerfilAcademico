package com.irvinmarin.apps.miperfilacademico.estado_financiero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.estado_financiero.adapters.EstadoFinancieroAdapter;
import com.irvinmarin.apps.miperfilacademico.estado_financiero.ui.entities.CuotasUI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by irvinmarin on 10/05/2018.
 */

public class EstadoFinancieroFragment extends Fragment {
    @BindView(R.id.rvEstadosFinan)
    RecyclerView rvEstadosFinan;
    Unbinder unbinder;

    public static EstadoFinancieroFragment newIntance(int idAlumno) {
        return new EstadoFinancieroFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_estado_financiero, container, false);
        unbinder = ButterKnife.bind(this, view);


        setupRv();
        return view;
    }

    private void setupRv() {

        rvEstadosFinan.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvEstadosFinan.setAdapter(new EstadoFinancieroAdapter(new ArrayList<CuotasUI>()));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

