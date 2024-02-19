package com.example.uniquindio.programacion3.almacen.controller.service;

import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;

import java.util.List;

public interface IRegistroService {
    public boolean registrarCliente(ClienteDto clienteDto);


    List<ClienteDto> obtenerNat();
    List<ClienteDto> obtenerJur();

    boolean actualizarCliente(ClienteDto clienteDto);

    boolean eliminarCliente(ClienteDto clienteDto);
}
