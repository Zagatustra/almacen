package com.example.uniquindio.programacion3.yourplace.viewController;

import com.example.uniquindio.programacion3.yourplace.controller.RegistroController;
import com.example.uniquindio.programacion3.yourplace.mapping.dto.EmpleadoDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegistroViewController {
    EmpleadoDto empleadoSelec;
    RegistroController registroControllerService;
    @FXML
    private Button actualizarUsuario;

    @FXML
    private Button borrarUsuario;


    @FXML
    private TableView<EmpleadoDto> tableUsuarios;

    @FXML
    private TableColumn<EmpleadoDto, String> tcIdentificacion;

    @FXML
    private TableColumn<EmpleadoDto, String> tcEmail;


    @FXML
    private TableColumn<EmpleadoDto, String> tcNombre;


    @FXML
    private TextField txtFldIdentificacion;

    @FXML
    private TextField txtFldEmail;



    @FXML
    private TextField txtFldNombre;



    private final ObservableList<EmpleadoDto> listaEmpleadoDto = FXCollections.observableArrayList();
    EmpleadoDto clienteToEmpleadoDto;

    @FXML
    void initialize() {

        registroControllerService = new RegistroController();
        initDataBinding();
        configurarTabla();
        obtenerEmpleado();

    }

    void registrarEmpleado(EmpleadoDto empleadoDto) {
        if(registroControllerService.registrarEmpleado(empleadoDto)){
            mostrarMensaje("MENSAJE", "correcto.");
            limpiarCampos();
            obtenerEmpleado();
        }else{
            mostrarMensaje("ERROR", "incorrecto.");
        }
    }

    private void limpiarCampos() {
        txtFldNombre.setText("");
        txtFldIdentificacion.setText("");
        txtFldEmail.setText("");
    }

    @FXML
    void confirmarRegistro(ActionEvent event) {

            registrarEmpleado(crearEmpleado());

    }

    public EmpleadoDto crearEmpleado() {

        return new EmpleadoDto(
                txtFldNombre.getText(),
                txtFldIdentificacion.getText(),
                txtFldEmail.getText());


    }

    private void mostrarMensaje(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private void initDataBinding() {

        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().identificacion())));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().email())));
    }


    private void obtenerEmpleado() {
        listaEmpleadoDto.clear();
        listaEmpleadoDto.addAll(registroControllerService.obtenerEmp());

    }
    private void configurarTabla() {
        // Configurar las columnas de la tabla
        tableUsuarios.setItems(listaEmpleadoDto);
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesCliente(newValue));
    }
    private void mostrarDetallesCliente(EmpleadoDto empleadoDto) {
        empleadoSelec = empleadoDto;

        if (empleadoDto != null) {
            // Actualizar los campos de texto con los datos del cliente seleccionado
            txtFldNombre.setText(empleadoDto.nombre());
            txtFldIdentificacion.setText(empleadoDto.identificacion());
            txtFldEmail.setText(empleadoDto.email());

        }
    }
    @FXML
    void eliminarCliente() {
        if (registroControllerService.eliminarCliente(empleadoSelec)) {
            mostrarMensaje("","Se elimino con éxito.");
            listaEmpleadoDto.remove(empleadoSelec);
            empleadoSelec = null;
            tableUsuarios.getSelectionModel().clearSelection();
            limpiarCampos();
        } else {
            mostrarMensaje("","No se puedo eliminar, intente más tarde.");
        }

    }
    @FXML
    void actualizarCliente() {
    EmpleadoDto cDto=new EmpleadoDto(txtFldNombre.getText(), txtFldIdentificacion.getText(), txtFldEmail.getText());
        if (registroControllerService.actualizarEmpleado(cDto)) {
            mostrarMensaje("","Se actualizo con éxito.");
            listaEmpleadoDto.add(cDto);
            listaEmpleadoDto.remove(empleadoSelec);
            tableUsuarios.refresh();
            limpiarCampos();

        } else {
            mostrarMensaje("","No se pudo actualizar, intente más tarde.");
        }
    }

    }