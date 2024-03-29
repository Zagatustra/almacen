package com.example.uniquindio.programacion3.yourplace.mapping.mapper;

import com.example.uniquindio.programacion3.yourplace.mapping.dto.EmpleadoDto;
import com.example.uniquindio.programacion3.yourplace.model.Empleado;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T14:34:35-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
*/
public class MapperYourPlaceImpl implements MapperYourPlace {

    @Override
    public EmpleadoDto empleadoToEmpleadoDto(Empleado cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nombre = null;
        String identificacion = null;
        String email = null;

        nombre = cliente.getNombre();
        identificacion = cliente.getIdentificacion();
        email = cliente.getEmail();

        EmpleadoDto empleadoDto = new EmpleadoDto( nombre, identificacion, email );

        return empleadoDto;
    }

    @Override
    public Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto) {
        if ( empleadoDto == null ) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setNombre( empleadoDto.nombre() );
        empleado.setIdentificacion( empleadoDto.identificacion() );
        empleado.setEmail( empleadoDto.email() );

        return empleado;
    }

    @Override
    public List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados) {
        if ( listaEmpleados == null ) {
            return null;
        }

        List<EmpleadoDto> list = new ArrayList<EmpleadoDto>( listaEmpleados.size() );
        for ( Empleado empleado : listaEmpleados ) {
            list.add( empleadoToEmpleadoDto( empleado ) );
        }

        return list;
    }
}
