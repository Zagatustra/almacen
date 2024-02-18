package com.example.uniquindio.programacion3.almacen.viewController;

import com.example.uniquindio.programacion3.almacen.controller.RegistroController;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;

public class RegistroViewController {
    RegistroController registroControllerService;
    @FXML
    private Button actualizarUsuario;

    @FXML
    private Button borrarUsuario;

    @FXML
    private DatePicker dpFecNac;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFecNac;

    @FXML
    private Button registrarUsuario;

    @FXML
    private TableView<?> tableUsuarios;

    @FXML
    private TableColumn<?, ?> tcApellido;

    @FXML
    private TableColumn<?, ?> tcDir;

    @FXML
    private TableColumn<?, ?> tcId;

    @FXML
    private TableColumn<?, ?> tcNombre;

    @FXML
    private TableColumn<?, ?> tcTel;

    @FXML
    private TextField txtFldApellido;

    @FXML
    private TextField txtFldDireccion;

    @FXML
    private TextField txtFldEmail;

    @FXML
    private TextField txtFldId;

    @FXML
    private TextField txtFldNombre;

    @FXML
    private RadioButton rdoBtnJuridico;

    @FXML
    private RadioButton rdoBtnNatural;

    private ToggleGroup grupoRadioButton;

    @FXML
    private TextField txtFldTel;
    @FXML
    void initialize() {
        grupoRadioButton=new ToggleGroup();
        rdoBtnNatural.setToggleGroup(grupoRadioButton);
        rdoBtnNatural.setToggleGroup(grupoRadioButton);

        registroControllerService = new RegistroController();
    }

    void registrarCliente(ClienteDto clienteDto) {
        if(registroControllerService.registrarCliente(clienteDto)){
            mostrarMensaje("MENSAJE", "correcto.");
            //limpiarCampos();
        }else{
            mostrarMensaje("ERROR", "incorrecto.");
        }
    }

    @FXML
    void confirmarRegistro(ActionEvent event) {
        if (!(rdoBtnNatural.isSelected() || rdoBtnJuridico.isSelected())) {
            mostrarMensaje("ERROR", "Eliga una opción.");
        }else{
            validarSeleccion();
            registrarCliente(crearCliente());
        }
    }
    public ClienteDto crearCliente() {
        return new ClienteDto(
                txtFldNombre.getText(),
                txtFldApellido.getText(),
                txtFldDireccion.getText(),
                txtFldId.getText(),
                txtFldTel.getText());
    }

    private void mostrarMensaje(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public boolean validarSeleccion() {
        boolean seleccion = false;
        if (rdoBtnJuridico.isSelected()) {
            seleccion = true;
        } else if (rdoBtnNatural.isSelected()) {
            rdoBtnJuridico.isDisable();
        }
        return seleccion;
    }
    public void seleccionNatural(ActionEvent actionEvent) {
        if (rdoBtnNatural.isSelected()) {
            rdoBtnJuridico.setSelected(false);
        } else {
            rdoBtnJuridico.setSelected(true);
        }
    }

    public void seleccionJuridica(ActionEvent actionEvent) {
        if (rdoBtnJuridico.isSelected()) {
            rdoBtnNatural.setSelected(false);
        } else {
            rdoBtnNatural.setSelected(true);
        }
    }
}