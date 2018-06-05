package com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.holders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CursosUI;
import com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.CursosAdapter;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class CiclosViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.txtNroCiclo)
    TextView txtNroCiclo;
    @BindView(R.id.rvCursos)
    RecyclerView rvCursos;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
    CursosAdapter cursosAdapter = new CursosAdapter(new ArrayList<CursosUI>());

    public CiclosViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(CiclosUI ciclosUI, int position) {
        Log.d(TAG, "onBindViewHolder init time: " + new Date().getTime());
        int nroCicloStatic = position + 1;

        txtNroCiclo.setText("Ciclo " + nroCicloStatic);
        rvCursos.setLayoutManager(linearLayoutManager);
        rvCursos.setAdapter(cursosAdapter);
    }
}
