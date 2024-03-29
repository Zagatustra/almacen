package com.example.uniquindio.programacion3.yourplace.model;

public class Persona {
private String nombre;
private String identificacion;
private String email;


    public Persona() {
    }

    public Persona(String nombre, String identificacion, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
