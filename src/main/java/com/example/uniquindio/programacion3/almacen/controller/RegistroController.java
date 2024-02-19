package com.example.uniquindio.programacion3.almacen.controller;

import com.example.uniquindio.programacion3.almacen.controller.service.IRegistroService;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;

import java.util.List;

public class RegistroController implements IRegistroService {
    ModelFactoryController modelFactoryController;
    public RegistroController(){
        modelFactoryController= ModelFactoryController.getInstance();}
    @Override
    public boolean registrarCliente(ClienteDto clienteDto){
        return modelFactoryController.agregarCliente(clienteDto);
    }
    @Override
    public List<ClienteDto> obtenerNat() {
        return modelFactoryController.obtenerNat();
    }
    @Override
    public List<ClienteDto> obtenerJur() {
        return modelFactoryController.obtenerJur();
    }
    @Override
    public boolean actualizarCliente(ClienteDto clienteDto){
        return modelFactoryController.actualizarCliente(clienteDto);
    }
    @Override
    public boolean eliminarCliente(ClienteDto clienteDto) {
      return modelFactoryController.eliminarCliente(clienteDto);
    }
}
