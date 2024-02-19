package com.example.uniquindio.programacion3.almacen.controller.service;

import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;

public interface IModelFactoryService {


    boolean actualizarCliente(ClienteDto clienteDto);
//
    boolean eliminarCliente(ClienteDto clienteDto);
}
