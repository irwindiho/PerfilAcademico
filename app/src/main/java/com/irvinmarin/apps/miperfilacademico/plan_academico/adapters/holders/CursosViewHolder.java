package com.irvinmarin.apps.miperfilacademico.plan_academico.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CursosUI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class CursosViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.txtNombreCurso)
    TextView txtNombreCurso;
    @BindView(R.id.txtcCarreraCiclo)
    TextView txtCredito;
    @BindView(R.id.txtNroHoras)
    TextView txtNroHoras;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.txtNota)
    TextView txtNota;


    public CursosViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(CursosUI cursosUI) {

        txtNombreCurso.setText(cursosUI.getNombre());
        txtCredito.setText("Creditos : " + cursosUI.getCreditos());
        txtNroHoras.setText("Horas :" + cursosUI.getHoras());
        txtNota.setText(cursosUI.getNotaCurso());

    }
}
