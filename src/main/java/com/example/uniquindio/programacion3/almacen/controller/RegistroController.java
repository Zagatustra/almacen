package com.example.uniquindio.programacion3.almacen.controller;

import com.example.uniquindio.programacion3.almacen.controller.service.IRegistroService;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;

public class RegistroController implements IRegistroService {
    ModelFactoryController modelFactoryController;
    public RegistroController(){
        modelFactoryController= ModelFactoryController.getInstance();}
    @Override
    public boolean registrarCliente(ClienteDto clienteDto){
        return modelFactoryController.agregarCliente(clienteDto);
    }

}
