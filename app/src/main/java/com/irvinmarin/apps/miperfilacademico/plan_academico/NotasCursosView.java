package com.irvinmarin.apps.miperfilacademico.plan_academico;


import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;

import java.util.List;

public interface NotasCursosView {
    void showListCiclos(List<CiclosUI> ciclosUIList);

    void shoMsj(String mensaje);

}
