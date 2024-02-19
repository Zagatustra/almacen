package com.example.uniquindio.programacion3.almacen.mapping.mapper;

import com.example.uniquindio.programacion3.almacen.mapping.dto.*;
import com.example.uniquindio.programacion3.almacen.model.*;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import org.mapstruct.*;

import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperAlmacen {
    MapperAlmacen INSTANCE= Mappers.getMapper(MapperAlmacen.class);




    //Mappers Productos
    @Named("productoToProductoDto")
    ProductoDto productoToProductoDto(Producto producto);
    Producto productoDtoToProducto(ProductoDto productoDto);

    @IterableMapping(qualifiedByName = "productoToProductoDto")
    List<ProductoDto> getProductosDto(List<Producto> listaProductos) ;

   // @Mapping(target = "nombreProducto",source = "producto.nombreProducto")
    //@IterableMapping(qualifiedByName = "cuentaToCuentaDto")
   // ProductoDto productoToProductodto(Producto producto);



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
