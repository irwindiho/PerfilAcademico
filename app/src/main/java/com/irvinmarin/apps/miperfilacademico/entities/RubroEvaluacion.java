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
public class RubroEvaluacion extends BaseModel {

    @PrimaryKey
    private long id;
    @Column
    private String nombreRubro;

    public RubroEvaluacion() {
    }

    public RubroEvaluacion(long id, String nombreRubro) {
        this.id = id;
        this.nombreRubro = nombreRubro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }
}
