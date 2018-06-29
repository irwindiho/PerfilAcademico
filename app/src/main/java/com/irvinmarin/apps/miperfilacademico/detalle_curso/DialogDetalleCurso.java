package com.irvinmarin.apps.miperfilacademico.detalle_curso;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.cursos.ui.entities.CursosDetalleUI;
import com.irvinmarin.apps.miperfilacademico.detalle_curso.adapters.RubrosCursosAdapter;
import com.irvinmarin.apps.miperfilacademico.detalle_curso.entities.RubrosUI;
import com.irvinmarin.apps.miperfilacademico.estado_financiero.ui.entities.CuotasUI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class DialogDetalleCurso extends DialogFragment {


    private static List<RubrosUI> rubrosUIList;
    private static CursosDetalleUI cursosDetalleUI;
    private final String TAG = this.getClass().getSimpleName();

    View viewPadre;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.txtNombreCursoDetalle)
    TextView txtNombreCursoDetalle;
    @BindView(R.id.txtProfesorCursoDetalle)
    TextView txtProfesorCursoDetalle;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.rvListaRubros)
    RecyclerView rvListaRubros;
    @BindView(R.id.txtPromedio)
    TextView txtPromedio;
    Unbinder unbinder;


    public static DialogDetalleCurso newInstance(CursosDetalleUI cursosDetalleUI, List<RubrosUI> rubrosUIList) {
        DialogDetalleCurso.rubrosUIList = rubrosUIList;
        DialogDetalleCurso.cursosDetalleUI = cursosDetalleUI;
        return new DialogDetalleCurso();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.dialog_detalle_curso, container, false);
        unbinder = ButterKnife.bind(this, viewPadre);

        setupDataCurso();
        setupRv();
        return viewPadre;
    }

    private void setupDataCurso() {
        txtNombreCursoDetalle.setText(cursosDetalleUI.getNombre());
        txtProfesorCursoDetalle.setText(cursosDetalleUI.getNombreDocente());
    }

    private void setupRv() {


        rvListaRubros.setLayoutManager(new LinearLayoutManager(getContext()));
        rvListaRubros.setAdapter(new RubrosCursosAdapter(populateRubros()));

        getPromedio();


    }

    double promedio = 0;

    private void getPromedio() {
        double numerador = 0;
        double denominador = 0;
        for (RubrosUI rubrosUI : populateRubros()) {
            numerador = rubrosUI.getNota() * rubrosUI.getPonderado() + numerador;
            denominador = rubrosUI.getPonderado() + denominador;
        }
        promedio = numerador / denominador;
        txtPromedio.setText("Promedio : " + promedio);
    }

    private List<RubrosUI> populateRubros() {
        List<RubrosUI> rubrosUIS = new ArrayList<>();

        rubrosUIS.add(new RubrosUI(1, "Practicas Calificadads: Evaluacion de Practicas e informes", 5.0, 17));
        rubrosUIS.add(new RubrosUI(2, "Elaboracion de Proyecto: 1er Sustentcaion y Avance ", 10.0, 18));
        rubrosUIS.add(new RubrosUI(3, "Elaboracion de Proyecto: 2da Sustentcaion y Avance ", 15.0, 14));
        rubrosUIS.add(new RubrosUI(4, "Elaboracion de Proyecto: 3er Sustentcaion y Avance ", 20.0, 16));
        rubrosUIS.add(new RubrosUI(5, "Aspecto Formativo: Responsabilidad y Puntuliada", 10.0, 0));
        rubrosUIS.add(new RubrosUI(5, "Elaboracion de Proyecto:Presentacion Final ", 25.0, 0));
        rubrosUIS.add(new RubrosUI(6, "Evaluacion SUmativa : tareas y classroom", 15.0, 0));


        return rubrosUIS;

    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
