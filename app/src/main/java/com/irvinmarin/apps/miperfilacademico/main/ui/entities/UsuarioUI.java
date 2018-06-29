package com.irvinmarin.apps.miperfilacademico.main.ui.entities;

/**
 * Created by irvinmarin on 21/06/2018.
 */

public class UsuarioUI {
    private int idUsuario;
    private String userName;
    private String password;
    private String correo;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    public UsuarioUI() {
    }

    public UsuarioUI(int idUsuario, String userName, String password, String correo, String nombres, String apellidos, String direccion, String telefono) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.password = password;
        this.correo = correo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
