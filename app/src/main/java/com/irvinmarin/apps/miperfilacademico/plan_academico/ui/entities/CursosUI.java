package com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities;

import java.io.Serializable;

/**
 * Created by irvinmarin on 17/05/2018.
 */

public class CursosUI implements Serializable {
    private int idCurso;
    private String nombre;
    private String creditos;
    private String thp;
    private String hnp;
    private String horas;
    private String notaCurso;

    public CursosUI() {
    }

    public CursosUI(int idCurso, String nombre, String creditos, String thp, String hnp, String horas, String notaCurso) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.creditos = creditos;
        this.thp = thp;
        this.hnp = hnp;
        this.horas = horas;
        this.notaCurso = notaCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getThp() {
        return thp;
    }

    public void setThp(String thp) {
        this.thp = thp;
    }

    public String getHnp() {
        return hnp;
    }

    public void setHnp(String hnp) {
        this.hnp = hnp;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getNotaCurso() {
        return notaCurso;
    }

    public void setNotaCurso(String notaCurso) {
        this.notaCurso = notaCurso;
    }

    @Override
    public String toString() {
        return "CursosUI{" +
                "idCurso=" + idCurso +
                ", nombre='" + nombre + '\'' +
                ", creditos='" + creditos + '\'' +
                ", thp='" + thp + '\'' +
                ", hnp='" + hnp + '\'' +
                ", horas='" + horas + '\'' +
                ", notaCurso='" + notaCurso + '\'' +
                '}';
    }

}
