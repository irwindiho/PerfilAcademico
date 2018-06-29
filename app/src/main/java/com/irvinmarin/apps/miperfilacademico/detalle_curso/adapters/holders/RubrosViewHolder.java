package com.irvinmarin.apps.miperfilacademico.detalle_curso.adapters.holders;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.cursos.ui.entities.CursosDetalleUI;
import com.irvinmarin.apps.miperfilacademico.detalle_curso.entities.RubrosUI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class RubrosViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.txtNombreRubro)
    TextView txtNombreRubro;
    @BindView(R.id.txtPonderado)
    TextView txtPonderado;
    @BindView(R.id.txtNota)
    TextView txtNota;


    public RubrosViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @SuppressLint("SetTextI18n")
    public void bind(RubrosUI rubrosUI) {

        txtNombreRubro.setText(rubrosUI.getNombreRubro());
        txtNota.setText(rubrosUI.getNota() + "");
        txtPonderado.setText(rubrosUI.getPonderado() + "%");


    }
}
