/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irvinmarin.apps.miperfilacademico.entities;

import com.irvinmarin.apps.miperfilacademico.database.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @author USUARIO
 */
@Table(database = AppDatabase.class)
public class Curso extends BaseModel {

    @PrimaryKey
    private long id;
    @Column
    private String nombreCurso;
    @Column
    private int totalHoras;
    @Column
    private int totalCreditos;

    private CargaAcademica cargaAcademica;


    public Curso() {
    }

    public Curso(long id, String nombreCurso, int totalHoras, int totalCreditos, CargaAcademica cargaAcademica) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.totalHoras = totalHoras;
        this.totalCreditos = totalCreditos;
        this.cargaAcademica = cargaAcademica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public int getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(int totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public CargaAcademica getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(CargaAcademica cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

}
