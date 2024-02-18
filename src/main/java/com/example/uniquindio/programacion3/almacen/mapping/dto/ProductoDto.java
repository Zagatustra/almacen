package com.example.uniquindio.programacion3.almacen.mapping.dto;

public record ProductoDto(
        String codigo,
        String nombre,
        String descripcion,
        double valor,
        int cantidad){
}
