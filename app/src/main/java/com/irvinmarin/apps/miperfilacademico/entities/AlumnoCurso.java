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
public class AlumnoCurso extends BaseModel {
    @PrimaryKey
    private long id;
    @Column
    private double nota;

    private RubroEvaluacion rubroEvaluacion;

    private Alumno alumno;

    private Curso curso;

    public AlumnoCurso() {
    }

    public AlumnoCurso(long id, double nota, RubroEvaluacion rubroEvaluacion, Alumno alumno, Curso curso) {
        this.id = id;
        this.nota = nota;
        this.rubroEvaluacion = rubroEvaluacion;
        this.alumno = alumno;
        this.curso = curso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public RubroEvaluacion getRubroEvaluacion() {
        return rubroEvaluacion;
    }

    public void setRubroEvaluacion(RubroEvaluacion rubroEvaluacion) {
        this.rubroEvaluacion = rubroEvaluacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
