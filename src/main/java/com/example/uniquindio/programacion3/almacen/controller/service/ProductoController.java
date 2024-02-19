package com.example.uniquindio.programacion3.almacen.controller.service;

import com.example.uniquindio.programacion3.almacen.controller.ModelFactoryController;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ProductoDto;

import java.util.List;

public class ProductoController {

    ModelFactoryController modelFactoryController;

    public ProductoController(){
        modelFactoryController=ModelFactoryController.getInstance();
    }

   public List<ProductoDto> obtenerProducto(){
        return modelFactoryController.obtenerProducto();
    }

    public boolean agregarProducto(ProductoDto productoDto){
        return modelFactoryController.agregarProducto(productoDto);
    }

    //public boolean eliminarProducto(String codigo){
       // return modelFactoryController.eliminarProducto(codigo);
   // }

    //public boolean actualizarProducto(String codigoActual,ProductoDto productoDto){
        //return modelFactoryController.actualizarProducto(codigoActual,productoDto);
   // }

}
