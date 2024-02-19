package com.example.uniquindio.programacion3.almacen.mapping.mapper;

import com.example.uniquindio.programacion3.almacen.mapping.dto.*;
import com.example.uniquindio.programacion3.almacen.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperAlmacen {
    MapperAlmacen INSTANCE= Mappers.getMapper(MapperAlmacen.class);


    @Named("naturalToClienteDto")
    ClienteDto naturalToClienteDto(Natural cliente);

    @Named("juridicoToClienteDto")
    ClienteDto juridicoToClienteDto(Juridico cliente);

    Natural clienteDtoToNatural(ClienteDto clienteDto);

    Juridico clienteDtoToJuridico(ClienteDto clienteDto);
    @IterableMapping(qualifiedByName = "naturalToClienteDto")
    List<ClienteDto> getClientesDtoNa(List<Natural> listaNat);

    @IterableMapping(qualifiedByName = "juridicoToClienteDto")
    List<ClienteDto> getClientesDtoJu(List<Juridico> listaJur);
}
