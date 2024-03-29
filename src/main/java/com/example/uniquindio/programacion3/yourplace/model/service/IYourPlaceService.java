package com.example.uniquindio.programacion3.yourplace.model.service;

import com.example.uniquindio.programacion3.yourplace.model.Empleado;

import java.util.List;

public interface IYourPlaceService {
    boolean verificarExistenciaEmpleado(String cedula);


    boolean eliminarNatural(Empleado cliente);



    List<Empleado> obtenerEmp();


   boolean actualizarNatural(Empleado cliente);




}
