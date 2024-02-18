package com.example.uniquindio.programacion3.almacen.mapping.mapper;

import com.example.uniquindio.programacion3.almacen.mapping.dto.*;
import com.example.uniquindio.programacion3.almacen.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperAlmacen {
    MapperAlmacen INSTANCE= Mappers.getMapper(MapperAlmacen.class);

    @Named("clienteToClienteDto")
    ClienteDto clienteToClienteDto(Cliente cliente);
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

}
