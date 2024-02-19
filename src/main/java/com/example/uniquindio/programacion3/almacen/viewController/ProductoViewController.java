package com.example.uniquindio.programacion3.almacen.viewController;

import com.example.uniquindio.programacion3.almacen.controller.service.ProductoController;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ProductoDto;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private ComboBox<String> cbPais;

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

        tcCodigo.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().codigo()));
        tcNombreProducto.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().nombreProducto()));
        tcDescripcion.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().descripcion()));
        tcValor.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().valor())));
        tcCantidad.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(cellData.getValue().cantidad())));
    }

    private void obtenerProductos(){

        //listaProductoDto.addAll(productoControllerService.obtenerProducto);
    }

    private void listenerSelection(){

        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            productoSeleccionado=newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });

    }

    private void mostrarInformacionProducto(ProductoDto productoSeleccionado){
        if(productoSeleccionado!=null){
            txtCodigo.setText(productoSeleccionado.codigo());
            txtNombreProducto.setText(productoSeleccionado.nombreProducto());
            txtDescripcion.setText(productoSeleccionado.descripcion());
            txtValor.setText(String.valueOf(productoSeleccionado.valor()));
            txtCantidad.setText(String.valueOf(productoSeleccionado.cantidad()));

        }

    }

    @FXML
    void nuevoProductoAction(ActionEvent event) {
        txtCodigo.setText("Ingrese el Codigo");
        txtNombreProducto.setText("Ingrese el Nombre");
        txtDescripcion.setText("Ingrese la Descripción");
        txtValor.setText("Ingrese el Valor");
        txtCantidad.setText("Ingrese la Cantidad");
    }


    @FXML
    void registrarProductoAction(ActionEvent event) {
        crearProducto();
    }
    @FXML
    void actualizarProductoAction(ActionEvent event) {
      //  actualizaProducto();
    }

    @FXML
    void borrarProductoAction(ActionEvent event) {
        //borrarProducto();
    }

    private void crearProducto(){
        //1. Capturar datos
        ProductoDto productoDto=construirProductoDto();
        //2.Validar la información
        if (datosValidos(productoDto)){
            if(productoControllerService.agregarProducto(productoDto)){
                listaProductoDto.add(productoDto);
                mostrarMensaje("Notificación producto","Producto creado","El producto se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposProducto();
            }else{
                mostrarMensaje("notificacion producto","Producto no creado","El producto no se ha creado", Alert.AlertType.INFORMATION);
            }
        }else{
            mostrarMensaje("Notificacion producto","Producto no creado","Los datos ingresados son invalidos", Alert.AlertType.WARNING);
        }

    }

    private ProductoDto construirProductoDto(){
        return new ProductoDto(
                txtCodigo.getText(),
                txtNombreProducto.getText(),
                txtDescripcion.getText(),
                Double.valueOf(txtValor.getText()),
                Integer.valueOf(txtCantidad.getText())
        );
    }

    private boolean datosValidos(ProductoDto productoDto){
        String mensaje="";
        if(productoDto.codigo()==null||productoDto.codigo().equals(""))
            mensaje+="El codigo es invalido \n";
        if(productoDto.nombreProducto()==null||productoDto.nombreProducto().equals(""))
            mensaje+="El nombre del producto es invalido \n";
        if(productoDto.descripcion()==null||productoDto.descripcion().equals(""))
            mensaje+="La descripcion es invalido \n";
        if(productoDto.valor()<0)
            mensaje+="El valor es invalido \n";
        if(productoDto.cantidad()<0)
            mensaje+="La cantidad es invalido \n";
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificacion usuario","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){

        Alert aler=new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void limpiarCamposProducto(){
        txtCodigo.setText("");
        txtNombreProducto.setText("");
        txtDescripcion.setText("");
        txtValor.setText("");
        txtCantidad.setText("");
    }

}
