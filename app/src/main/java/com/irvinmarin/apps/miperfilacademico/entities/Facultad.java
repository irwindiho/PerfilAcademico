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
public class Facultad extends BaseModel {

    @PrimaryKey
    private long id;
    @Column
    private String nombreFacultad;

    public Facultad() {
    }

    public Facultad(long id, String nombreFacultad) {
        this.id = id;
        this.nombreFacultad = nombreFacultad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }
}
