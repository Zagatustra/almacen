package com.example.uniquindio.programacion3.almacen.model.service;

import com.example.uniquindio.programacion3.almacen.model.Cliente;
import com.example.uniquindio.programacion3.almacen.model.Juridico;
import com.example.uniquindio.programacion3.almacen.model.Natural;
import com.example.uniquindio.programacion3.almacen.model.Producto;

import java.util.ArrayList;
import java.util.List;

public interface IAlmacenService {
    boolean verificarExistenciaCliente(String cedula);


    boolean eliminarNatural(Natural cliente);

    boolean eliminarJuridico(Juridico cliente);

    List<Natural> obtenerNat();


   boolean actualizarNatural(Natural cliente);

    boolean actualizarJuridico(Juridico cliente);

    List<Juridico> obtenerJur();
}
