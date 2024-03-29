package com.example.uniquindio.programacion3.yourplace.model;

import java.util.ArrayList;

public class Empleado extends Persona {
    private ArrayList<Evento> listaEventosAsociados;


    public Empleado(){super();};
    public Empleado(String nombre,String id, String email,ArrayList<Evento> listaEventosAsociados){
        super(nombre, id, email);
        this.listaEventosAsociados=listaEventosAsociados;
    }

    public ArrayList<Evento> getListaEventosAsociados() {
        return listaEventosAsociados;
    }

    public void setListaEventosAsociados(ArrayList<Evento> listaEventosAsociados) {
        this.listaEventosAsociados = listaEventosAsociados;
    }
}
