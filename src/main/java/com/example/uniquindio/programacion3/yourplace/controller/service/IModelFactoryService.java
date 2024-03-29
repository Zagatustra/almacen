package com.example.uniquindio.programacion3.yourplace.controller.service;

import com.example.uniquindio.programacion3.yourplace.mapping.dto.EmpleadoDto;

public interface IModelFactoryService {


    boolean actualizarEmpleado(EmpleadoDto empleadoDto);
//
    boolean eliminarUsuario(EmpleadoDto empleadoDto);
}
