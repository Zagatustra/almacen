package com.example.uniquindio.programacion3.yourplace.model;

import com.example.uniquindio.programacion3.yourplace.model.service.IYourPlaceService;
import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class YourPlace implements IYourPlaceService, Serializable {
    private static final long serialVersionUID=1L;

    private ArrayList<Persona> listaPersona =new ArrayList();

    public void setListaNat(ArrayList<Empleado> listaNat) {
        this.listaNat = listaNat;
    }

    public ArrayList<Juridico> getListaJur() {
        return listaJur;
    }

    public void setListaJur(ArrayList<Juridico> listaJur) {
        this.listaJur = listaJur;
    }

    private ArrayList<Empleado> listaNat=new ArrayList<>();
    private ArrayList<Juridico> listaJur=new ArrayList<>();


    public YourPlace() {

    }



    @Override
    public boolean verificarExistenciaEmpleado(String id) {
        boolean existe = false;
        for (Persona c : obtenerEmp()) {
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
    public boolean eliminarNatural(Empleado cliente){

        if (obtenerEmp().removeIf(p -> p.getIdentificacion().equals(cliente.getIdentificacion()))) {
            return true;
        } else {
           mostrarMensaje("ERROR","No se llevo acabo la acción solicitada.");
           return false;
        }
    }

    @Override
    public List<Empleado> obtenerEmp() {    return listaNat;   }

    @Override
    public boolean actualizarNatural(Empleado empleado) {
        boolean actualizado = false;
        for (Empleado c : obtenerEmp()) {
            if (c.getIdentificacion().equals(empleado.getIdentificacion())) {
                c.setNombre(empleado.getNombre());
                c.setIdentificacion(empleado.getIdentificacion());
                c.setEmail(empleado.getEmail());
                actualizado = true;
                break;

            }
        }
        if (!actualizado) {
            mostrarMensaje("ERROR","No se pudo actualizar el cliente.");
        }
        return actualizado;
    }


}
