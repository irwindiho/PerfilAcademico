package com.irvinmarin.apps.miperfilacademico.cursos_matricula.adapters.holders;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.cursos_matricula.ui.entities.CursosDetalleUI;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class MatriculaCursosViewHolder extends RecyclerView.ViewHolder {
    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.txtNombreCurso)
    TextView txtNombreCurso;
    @BindView(R.id.txtcCarreraCiclo)
    TextView txtcCarreraCiclo;
    @BindView(R.id.txtGrupo)
    TextView txtGrupo;
    @BindView(R.id.txtNombreDocente)
    TextView txtNombreDocente;
    @BindView(R.id.btnNotas)
    TextView btnNotas;
    @BindView(R.id.btnSilabo)
    TextView btnSilabo;


    public MatriculaCursosViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @SuppressLint("SetTextI18n")
    public void bind(CursosDetalleUI cursosUI) {

        txtNombreCurso.setText(cursosUI.getNombre());
        txtcCarreraCiclo.setText(cursosUI.getEscuelaAcademica() + " - " + cursosUI.getCiclo());
        txtGrupo.setText("Grupo : " + cursosUI.getGrupoCurso());
        txtNombreDocente.setText(cursosUI.getNombreDocente());

        btnSilabo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Proximante", Toast.LENGTH_LONG).show();
            }
        });
        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Proximante", Toast.LENGTH_LONG).show();
            }
        });


    }
}
