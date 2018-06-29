package com.irvinmarin.apps.miperfilacademico.entities;

import com.irvinmarin.apps.miperfilacademico.database.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 21/06/2018.
 */
@Table(database = AppDatabase.class)
public class SessionUser extends BaseModel {
    @PrimaryKey(autoincrement = true)

    private int idUsuario;
    @Column
    private String nombresApellidos;
    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    private String carrera;
    @Column
    private String facutad;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public SessionUser() {
    }

    public SessionUser(int idUsuario, String nombresApellidos, String password, String carrera, String facutad) {
        this.idUsuario = idUsuario;
        this.nombresApellidos = nombresApellidos;
        this.password = password;
        this.carrera = carrera;
        this.facutad = facutad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFacutad() {
        return facutad;
    }

    public void setFacutad(String facutad) {
        this.facutad = facutad;
    }
}
