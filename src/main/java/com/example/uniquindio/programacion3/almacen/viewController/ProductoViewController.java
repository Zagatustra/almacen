package com.example.uniquindio.programacion3.almacen.viewController;

import com.example.uniquindio.programacion3.almacen.controller.service.ProductoController;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ProductoDto;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductoViewController {

    ProductoController productoControllerService;

    ObservableList <ProductoDto> listaProductoDto= FXCollections.observableArrayList();

    ProductoDto productoSeleccionado;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnBorrarProducto;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnRegistrarProducto;

    @FXML
    private ComboBox<?> cbPais;

    @FXML
    private DatePicker dpFechaVencimiento;

    @FXML
    private RadioButton radEnvasado;

    @FXML
    private RadioButton radPerecedeo;

    @FXML
    private RadioButton radRefrigerado;

    @FXML
    private TableView<ProductoDto> tableProductos;

    @FXML
    private TableColumn<ProductoDto, String> tcCantidad;

    @FXML
    private TableColumn<ProductoDto, String> tcCodigo;

    @FXML
    private TableColumn<ProductoDto, String> tcDescripcion;

    @FXML
    private TableColumn<ProductoDto, String> tcNombreProducto;

    @FXML
    private TableColumn<ProductoDto, String> tcValor;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCodigoAprovacion;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtTemperatura;

    @FXML
    private TextField txtValor;

    void initialize(){
        productoControllerService =new ProductoController();
        intiView();
    }

    private void intiView(){
        initDataBinding();
        obtenerProductos();
        tableProductos.getItems().clear();
        tableProductos.setItems(listaProductoDto);
        listenerSelection();
    }

    private void initDataBinding(){

    }

    private void obtenerProductos(){

    }

    private void listenerSelection(){

    }

    private void mostrarInformacionProducto(ProductoDto productoSeleccionado){

    }

    @FXML
    void nuevoEmpleadoAction(ActionEvent event) {

    }

}
