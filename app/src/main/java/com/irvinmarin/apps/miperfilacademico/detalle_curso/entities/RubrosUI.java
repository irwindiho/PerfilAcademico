package com.irvinmarin.apps.miperfilacademico.detalle_curso.entities;

/**
 * Created by irvinmarin on 21/06/2018.
 */

public class RubrosUI {
    private int rubroId;
    private String nombreRubro;
    private double ponderado;
    private double nota;


    public RubrosUI() {
    }

    public RubrosUI(int rubroId, String nombreRubro, double ponderado, double nota) {
        this.rubroId = rubroId;
        this.nombreRubro = nombreRubro;
        this.ponderado = ponderado;
        this.nota = nota;
    }

    public int getRubroId() {
        return rubroId;
    }

    public void setRubroId(int rubroId) {
        this.rubroId = rubroId;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    public double getPonderado() {
        return ponderado;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
