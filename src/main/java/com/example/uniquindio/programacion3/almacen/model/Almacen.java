package com.example.uniquindio.programacion3.almacen.model;

import com.example.uniquindio.programacion3.almacen.model.service.IAlmacenService;

import java.io.Serializable;
import java.util.ArrayList;

public class Almacen implements IAlmacenService, Serializable {
    private static final long serialVersionUID=1L;

    private ArrayList<Cliente> listaCliente=new ArrayList();

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    private ArrayList<Producto> listaProductos=new ArrayList<>();
    private Natural n1= new Natural("a","","","1","","",null);
    private Natural n2= new Natural("b","","","2","","",null);


    //private Juridico j1= new Natural("","","","","","");

    public Almacen() {

    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }


    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    @Override
    public boolean verificarExistenciaCliente(String id) {
        boolean existe = false;
        for (Cliente c : getListaCliente()) {
            if (c.getIdentificacion().equals(id)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //metodos Productos

    public void agregarProducto(Producto nuevoProducto){
        getListaProductos().add(nuevoProducto);
    }

    public boolean verificarProductoExistente(String codigo) {
        boolean existe = false;
        for (Producto producto : getListaProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

}
