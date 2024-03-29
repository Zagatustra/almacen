package com.example.uniquindio.programacion3.yourplace.controller.service;

import com.example.uniquindio.programacion3.yourplace.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IRegistroService {
    public boolean registrarEmpleado(EmpleadoDto empleadoDto);


    List<EmpleadoDto> obtenerEmp();


    boolean actualizarEmpleado(EmpleadoDto empleadoDto);

    boolean eliminarCliente(EmpleadoDto empleadoDto);
}
