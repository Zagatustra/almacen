package com.example.uniquindio.programacion3.almacen.controller;

import com.example.uniquindio.programacion3.almacen.controller.service.IModelFactoryService;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ProductoDto;
import com.example.uniquindio.programacion3.almacen.mapping.mapper.MapperAlmacen;
import com.example.uniquindio.programacion3.almacen.model.Almacen;
import com.example.uniquindio.programacion3.almacen.model.Producto;
import com.example.uniquindio.programacion3.almacen.util.AlmacenUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService,Runnable
{

    MapperAlmacen mapper =MapperAlmacen.INSTANCE;
    Almacen almacen;
    @Override
    public void run() {

    }

    private static class SingletonHolder {
       private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
   }
    private void cargarDatosBase() {
        almacen = AlmacenUtils.cargarAlmacen();
    }
   public static ModelFactoryController getInstance(){return SingletonHolder.eINSTANCE;}
    public ModelFactoryController(){
        cargarDatosBase();
    }
    public boolean agregarCliente(ClienteDto clienteDto){
       try{
           if(!(almacen.verificarExistenciaCliente(clienteDto.identificacion()))){
               getAlmacen().getListaCliente().add(mapper.clienteDtoToCliente(clienteDto));
               return true;
           }else{return false;
           }
       }catch (Exception e){
           return false;
       }
    }
    public Almacen getAlmacen(){
       return almacen;
    }


    //model Productos
    public List<ProductoDto>obtenerProducto(){
        return mapper.getProductosDto(almacen.getListaProductos());
    }

    public boolean agregarProducto(ProductoDto productoDto){
        try{
            if(!(almacen.verificarProductoExistente(productoDto.codigo()))) {
                Producto producto = mapper.productoDtoToProducto(productoDto);
                getAlmacen().agregarProducto(producto);
            }
                return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }


}
