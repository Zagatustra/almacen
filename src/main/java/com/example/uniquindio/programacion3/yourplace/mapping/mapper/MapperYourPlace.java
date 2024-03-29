package com.example.uniquindio.programacion3.yourplace.mapping.mapper;

import com.example.uniquindio.programacion3.yourplace.mapping.dto.*;
import com.example.uniquindio.programacion3.yourplace.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperYourPlace {
    MapperYourPlace INSTANCE= Mappers.getMapper(MapperYourPlace.class);


    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado cliente);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);


}
