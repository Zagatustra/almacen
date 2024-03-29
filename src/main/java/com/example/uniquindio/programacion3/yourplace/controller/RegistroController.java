package com.example.uniquindio.programacion3.yourplace.controller;

import com.example.uniquindio.programacion3.yourplace.controller.service.IRegistroService;
import com.example.uniquindio.programacion3.yourplace.mapping.dto.EmpleadoDto;

import java.util.List;

public class RegistroController implements IRegistroService {
    ModelFactoryController modelFactoryController;
    public RegistroController(){
        modelFactoryController= ModelFactoryController.getInstance();}
    @Override
    public boolean registrarEmpleado(EmpleadoDto empleadoDto){
        return modelFactoryController.agregarCliente(empleadoDto);
    }
    @Override
    public List<EmpleadoDto> obtenerEmp() {
        return modelFactoryController.obtenerEmplados();
    }

    @Override
    public boolean actualizarEmpleado(EmpleadoDto empleadoDto){
        return modelFactoryController.actualizarEmpleado(empleadoDto);
    }
    @Override
    public boolean eliminarCliente(EmpleadoDto empleadoDto) {
      return modelFactoryController.eliminarUsuario(empleadoDto);
    }
}
