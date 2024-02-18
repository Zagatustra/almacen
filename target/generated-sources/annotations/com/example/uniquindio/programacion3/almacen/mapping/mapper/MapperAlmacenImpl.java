package com.example.uniquindio.programacion3.almacen.mapping.mapper;

import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.model.Cliente;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-17T17:35:46-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
*/
public class MapperAlmacenImpl implements MapperAlmacen {

    @Override
    public ClienteDto clienteToClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String identificacion = null;

        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        identificacion = cliente.getIdentificacion();

        String fecNac = null;

        ClienteDto clienteDto = new ClienteDto( nombre, apellido, direccion, identificacion, fecNac );

        return clienteDto;
    }

    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre( clienteDto.nombre() );
        cliente.setApellido( clienteDto.apellido() );
        cliente.setDireccion( clienteDto.direccion() );
        cliente.setIdentificacion( clienteDto.identificacion() );

        return cliente;
    }
}
