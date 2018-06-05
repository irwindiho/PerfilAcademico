package com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities;

import java.util.List;

/**
 * Created by irvinmarin on 21/05/2018.
 */

public class CiclosUI {
    private int idCiclo;
    private String nombreCiclo;
    private boolean estado;
    private List<CursosUI> cursosUIList;

    public CiclosUI() {
    }

    public CiclosUI(int idCiclo, String nombreCiclo, boolean estado, List<CursosUI> cursosUIList) {
        this.idCiclo = idCiclo;
        this.nombreCiclo = nombreCiclo;
        this.estado = estado;
        this.cursosUIList = cursosUIList;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<CursosUI> getCursosUIList() {
        return cursosUIList;
    }

    public void setCursosUIList(List<CursosUI> cursosUIList) {
        this.cursosUIList = cursosUIList;
    }

    @Override
    public String toString() {
        return "CiclosUI{" +
                "idCiclo=" + idCiclo +
                ", nombreCiclo='" + nombreCiclo + '\'' +
                ", estado=" + estado +
                ", cursosUIList=" + cursosUIList +
                '}';
    }
}
