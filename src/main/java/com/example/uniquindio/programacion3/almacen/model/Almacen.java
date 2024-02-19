package com.example.uniquindio.programacion3.almacen.model;

import com.example.uniquindio.programacion3.almacen.model.service.IAlmacenService;
import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Almacen implements IAlmacenService, Serializable {
    private static final long serialVersionUID=1L;

    private ArrayList<Cliente> listaCliente=new ArrayList();

    public ArrayList<Natural> getListaNat() {
        return listaNat;
    }

    public void setListaNat(ArrayList<Natural> listaNat) {
        this.listaNat = listaNat;
    }

    public ArrayList<Juridico> getListaJur() {
        return listaJur;
    }

    public void setListaJur(ArrayList<Juridico> listaJur) {
        this.listaJur = listaJur;
    }

    private ArrayList<Natural> listaNat=new ArrayList<>();
    private ArrayList<Juridico> listaJur=new ArrayList<>();


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



    private void mostrarMensaje(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @Override
    public boolean eliminarNatural(Natural cliente){

        if (getListaNat().removeIf(p -> p.getIdentificacion().equals(cliente.getIdentificacion()))) {
            return true;
        } else {
           mostrarMensaje("ERROR","No se llevo acabo la acción solicitada.");
           return false;
        }
    }
    @Override
    public boolean eliminarJuridico(Juridico cliente){

        if (getListaJur().removeIf(p -> p.getIdentificacion().equals(cliente.getIdentificacion()))) {
            return true;
        } else {
            mostrarMensaje("ERROR","No se llevo acabo la acción solicitada.");
            return false;
        }
    }
    @Override
    public List<Natural> obtenerNat() {    return getListaNat();   }

    @Override
    public boolean actualizarNatural(Natural cliente) {
        boolean actualizado = false;
        for (Natural c : getListaNat()) {
            if (c.getIdentificacion().equals(cliente.getIdentificacion())) {
                c.setNombre(cliente.getNombre());
                c.setApellido(cliente.getApellido());
                c.setDireccion(cliente.getApellido());
                c.setIdentificacion(cliente.getIdentificacion());
                c.setTelefono(cliente.getTelefono());
                c.setEmail(cliente.getEmail());
                c.setFecNac(cliente.getFecNac());
                actualizado = true;
                break;

            }
        }
        if (!actualizado) {
            mostrarMensaje("ERROR","No se pudo actualizar el cliente.");
        }
        return actualizado;
    }

    @Override
    public boolean actualizarJuridico(Juridico cliente) {
        boolean actualizado = false;
        for (Juridico c : getListaJur()) {
            if (c.getIdentificacion().equals(cliente.getIdentificacion())) {
                c.setNombre(cliente.getNombre());
                c.setApellido(cliente.getApellido());
                c.setDireccion(cliente.getApellido());
                c.setIdentificacion(cliente.getIdentificacion());
                c.setTelefono(cliente.getTelefono());
                c.setNit(cliente.getNit());

                actualizado = true;
                break;

            }
        }
        if (!actualizado) {
            mostrarMensaje("ERROR","No se pudo actualizar el cliente.");
        }
        return actualizado;
    }

    @Override
    public List<Juridico> obtenerJur() {     return getListaJur();  }
}
