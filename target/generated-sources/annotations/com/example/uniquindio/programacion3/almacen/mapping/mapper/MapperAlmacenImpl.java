package com.example.uniquindio.programacion3.almacen.mapping.mapper;

import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.model.Juridico;
import com.example.uniquindio.programacion3.almacen.model.Natural;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T00:49:37-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
*/
public class MapperAlmacenImpl implements MapperAlmacen {

    @Override
    public ClienteDto naturalToClienteDto(Natural cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String identificacion = null;
        String fecNac = null;
        String email = null;

        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        identificacion = cliente.getIdentificacion();
        if ( cliente.getFecNac() != null ) {
            fecNac = DateTimeFormatter.ISO_LOCAL_DATE.format( cliente.getFecNac() );
        }
        email = cliente.getEmail();

        String tel = null;
        String nit = null;

        ClienteDto clienteDto = new ClienteDto( nombre, apellido, direccion, identificacion, tel, fecNac, email, nit );

        return clienteDto;
    }

    @Override
    public ClienteDto juridicoToClienteDto(Juridico cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String identificacion = null;
        String nit = null;

        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        identificacion = cliente.getIdentificacion();
        nit = cliente.getNit();

        String tel = null;
        String fecNac = null;
        String email = null;

        ClienteDto clienteDto = new ClienteDto( nombre, apellido, direccion, identificacion, tel, fecNac, email, nit );

        return clienteDto;
    }

    @Override
    public Natural clienteDtoToNatural(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Natural natural = new Natural();

        natural.setNombre( clienteDto.nombre() );
        natural.setApellido( clienteDto.apellido() );
        natural.setDireccion( clienteDto.direccion() );
        natural.setIdentificacion( clienteDto.identificacion() );
        natural.setEmail( clienteDto.email() );
        if ( clienteDto.fecNac() != null ) {
            natural.setFecNac( LocalDate.parse( clienteDto.fecNac() ) );
        }

        return natural;
    }

    @Override
    public Juridico clienteDtoToJuridico(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Juridico juridico = new Juridico();

        juridico.setNombre( clienteDto.nombre() );
        juridico.setApellido( clienteDto.apellido() );
        juridico.setDireccion( clienteDto.direccion() );
        juridico.setIdentificacion( clienteDto.identificacion() );
        juridico.setNit( clienteDto.nit() );

        return juridico;
    }

    @Override
    public List<ClienteDto> getClientesDtoNa(List<Natural> listaNat) {
        if ( listaNat == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( listaNat.size() );
        for ( Natural natural : listaNat ) {
            list.add( naturalToClienteDto( natural ) );
        }

        return list;
    }

    @Override
    public List<ClienteDto> getClientesDtoJu(List<Juridico> listaJur) {
        if ( listaJur == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( listaJur.size() );
        for ( Juridico juridico : listaJur ) {
            list.add( juridicoToClienteDto( juridico ) );
        }

        return list;
    }
}
