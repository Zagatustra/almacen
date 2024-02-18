package com.example.uniquindio.programacion3.almacen.model;

import java.time.LocalDate;

public class Natural extends Cliente {
    private String email;

    private LocalDate fecNac;

    public Natural(){super();};
    public Natural(String nombre,String apellido,String direccion, String id, String telefono, String email,LocalDate fecNac){
        super(nombre,apellido,direccion, id, telefono);
        this.email=email;
        this.fecNac=fecNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }
}
