package com.example.uniquindio.programacion3.almacen.viewController;

import com.example.uniquindio.programacion3.almacen.controller.RegistroController;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.model.Cliente;
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

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegistroViewController {
    ClienteDto clienteSelec;
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
    private Button confirmarRegistro;

    @FXML
    private TableView<ClienteDto> tableUsuarios;

    @FXML
    private TableColumn<ClienteDto, String> tcApellido;

    @FXML
    private TableColumn<ClienteDto, String> tcDir;

    @FXML
    private TableColumn<ClienteDto, String> tcId;

    @FXML
    private TableColumn<ClienteDto, String> tcNombre;

    @FXML
    private TableColumn<ClienteDto, String> tcTel;

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
    private ObservableList<ClienteDto> listaClienteDto= FXCollections.observableArrayList();
    ClienteDto clienteToClienteDto;
    @FXML
    private TextField txtFldTel;
    @FXML
    void initialize() {
        lblEmail.setVisible(false);
        txtFldEmail.setVisible(false);
        dpFecNac.setVisible(false);
        lblFecNac.setVisible(false);
        grupoRadioButton=new ToggleGroup();
        rdoBtnNatural.setToggleGroup(grupoRadioButton);
        rdoBtnNatural.setToggleGroup(grupoRadioButton);
        registroControllerService = new RegistroController();
        initDataBinding();
        configurarTabla();
        obtenerClientes();

    }

    void registrarCliente(ClienteDto clienteDto) {
        if(registroControllerService.registrarCliente(clienteDto)){
            mostrarMensaje("MENSAJE", "correcto.");
            limpiarCampos();
            obtenerClientes();
        }else{
            mostrarMensaje("ERROR", "incorrecto.");
        }
    }

    private void limpiarCampos() {
        txtFldNombre.setText("");
        txtFldApellido.setText("");
        txtFldDireccion.setText("");
        txtFldId.setText("");
        txtFldTel.setText("");
        txtFldEmail.setText("");
        dpFecNac.setValue(null);
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
        if (rdoBtnNatural.isSelected()){
        return new ClienteDto(
                txtFldNombre.getText(),
                txtFldApellido.getText(),
                txtFldDireccion.getText(),
                txtFldId.getText(),
                txtFldTel.getText(),
                String.valueOf(dpFecNac.getValue()),
                txtFldEmail.getText(), null);
           }else if(rdoBtnJuridico.isSelected()){
            return new ClienteDto(
                    txtFldNombre.getText(),
                    txtFldApellido.getText(),
                    txtFldDireccion.getText(),
                    txtFldId.getText(),
                    txtFldTel.getText(),
                    null,
                    null, txtFldEmail.getText());
        }else{
            return null;
        }
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
            lblEmail.setVisible(true);
            lblEmail.setText("Email: ");
            txtFldEmail.setVisible(true);
            dpFecNac.setVisible(true);
            lblFecNac.setVisible(true);
        } else {
            rdoBtnJuridico.setSelected(true);

        }
    }

    public void seleccionJuridica(ActionEvent actionEvent) {
        if (rdoBtnJuridico.isSelected()) {
            rdoBtnNatural.setSelected(false);
            lblEmail.setText("Nit: ");
            dpFecNac.setVisible(false);
            lblFecNac.setVisible(false);
        } else {
            rdoBtnNatural.setSelected(true);
        }
    }

    private void initDataBinding() {

        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().apellido())));
        tcDir.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().direccion())));
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().identificacion())));
        tcTel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tel()));
    }


    private void obtenerClientes() {
        listaClienteDto.clear();
        listaClienteDto.addAll(registroControllerService.obtenerNat());
        listaClienteDto.addAll(registroControllerService.obtenerJur());
    }
    private void configurarTabla() {
        // Configurar las columnas de la tabla
        tableUsuarios.setItems(listaClienteDto);
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesCliente(newValue));
    }
    private void mostrarDetallesCliente(ClienteDto clienteDto) {
        clienteSelec = clienteDto;

        if (clienteDto != null) {
            // Actualizar los campos de texto con los datos del cliente seleccionado
            txtFldNombre.setText(clienteDto.nombre());
            txtFldApellido.setText(clienteDto.apellido());
            txtFldDireccion.setText(clienteDto.direccion());
            txtFldId.setText(clienteDto.identificacion());
            txtFldTel.setText(clienteDto.tel());


            // Verificar si es cliente natural y actualizar campos adicionales
            if (clienteDto.fecNac() != null) {
                rdoBtnNatural.setSelected(true);
                rdoBtnJuridico.setSelected(false);
                lblEmail.setVisible(true);
                lblEmail.setText("Email: ");
                dpFecNac.setVisible(true);
                lblFecNac.setVisible(true);
                dpFecNac.setValue(LocalDate.parse(clienteDto.fecNac()));
                txtFldEmail.setVisible(true);
                txtFldEmail.setText(clienteDto.email());

                // Aquí puedes agregar lógica adicional para campos específicos de Cliente Natural
            } else {
                // Limpiar el DatePicker si no es cliente natural
                rdoBtnNatural.setSelected(false);
                rdoBtnJuridico.setSelected(true);
                lblEmail.setVisible(true);
                lblEmail.setText("Nit: ");
                dpFecNac.setVisible(false);
                lblFecNac.setVisible(false);
                dpFecNac.setValue(null);
                txtFldEmail.setVisible(true);
                txtFldEmail.setText(clienteDto.nit() );
            }
        } else {
            // Limpiar los campos si no hay cliente seleccionado
            limpiarCampos();
        }
    }
    @FXML
    void eliminarCliente() {
        if (registroControllerService.eliminarCliente(clienteSelec)) {
            mostrarMensaje("","Se elimino con éxito.");
            listaClienteDto.remove(clienteSelec);
            clienteSelec = null;
            tableUsuarios.getSelectionModel().clearSelection();
            limpiarCampos();
        } else {
            mostrarMensaje("","No se puedo eliminar, intente más tarde.");
        }

    }
    @FXML
    void actualizarCliente() {
    ClienteDto cDto=new ClienteDto(txtFldNombre.getText(),txtFldApellido.getText(),txtFldDireccion.getText(),
            txtFldId.getText(),txtFldTel.getText(),String.valueOf(clienteSelec.fecNac()),txtFldEmail.getText(),txtFldEmail.getText());
        if (registroControllerService.actualizarCliente(cDto)) {
            mostrarMensaje("","Se actualizo con éxito.");
            listaClienteDto.add(cDto);
            listaClienteDto.remove(clienteSelec);
            tableUsuarios.refresh();
            limpiarCampos();

        } else {
            mostrarMensaje("","No se pudo actualizar, intente más tarde.");
        }
    }

    }