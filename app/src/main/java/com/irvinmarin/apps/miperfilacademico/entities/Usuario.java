package com.irvinmarin.apps.miperfilacademico.entities;

import com.irvinmarin.apps.miperfilacademico.database.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 14/06/2018.
 */
@Table(database = AppDatabase.class)
public class Usuario extends BaseModel {
    @PrimaryKey
    private int idUsuario;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean activo;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, boolean activo) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
