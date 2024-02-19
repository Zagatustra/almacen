package com.example.uniquindio.programacion3.almacen.model;

public class Producto {

        private String codigo;
        private String nombreProducto;
        private String descripcion;
        private double valor;
        private int cantidad;

        public Producto() {
        }

        public Producto(String codigo, String nombreProducto, String descripcion, double valor, int cantidad) {
            this.codigo = codigo;
            this.nombreProducto = nombreProducto;
            this.descripcion = descripcion;
            this.valor = valor;
            this.cantidad = cantidad;
        }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

