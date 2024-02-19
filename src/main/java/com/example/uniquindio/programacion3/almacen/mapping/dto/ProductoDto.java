package com.example.uniquindio.programacion3.almacen.mapping.dto;

public record ProductoDto(
        String codigo,
        String nombreProducto,
        String descripcion,
        double valor,
        int cantidad){
}
