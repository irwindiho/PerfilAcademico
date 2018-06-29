package com.irvinmarin.apps.miperfilacademico.cursos;


import com.irvinmarin.apps.miperfilacademico.cursos.ui.entities.CursosDetalleUI;

import java.util.List;

public interface ContratosCursosView {
    void showListCiclos(List<CursosDetalleUI> cursosUIList);

    void shoMsj(String mensaje);

}
