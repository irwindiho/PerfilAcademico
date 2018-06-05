package com.irvinmarin.apps.miperfilacademico.cursos_matricula;


import com.irvinmarin.apps.miperfilacademico.cursos_matricula.ui.entities.CursosDetalleUI;

import java.util.List;

public interface ContratosCursosView {
    void showListCiclos(List<CursosDetalleUI> cursosUIList);

    void shoMsj(String mensaje);

}
