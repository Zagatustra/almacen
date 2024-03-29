package com.example.uniquindio.programacion3.yourplace.util;

import com.example.uniquindio.programacion3.yourplace.model.YourPlace;
import com.example.uniquindio.programacion3.yourplace.model.Empleado;


public class YourPlaceUtils {
    public YourPlaceUtils(){

    }
    public static YourPlace cargarAlmacen(){
        YourPlace yourPlace = new YourPlace();

            Empleado empleado = new Empleado();

            empleado.setNombre("Pedro");
            empleado.setIdentificacion("Navaja");
            empleado.setEmail("qwe@gmail.com");

            yourPlace.obtenerEmp().add(empleado);

            Empleado empleado1 = new Empleado();
            empleado1.setNombre("Aleja");
            empleado1.setIdentificacion("Bueno");

            empleado1.setIdentificacion("1094948277");

            empleado1.setEmail("qwe@gmail.com");

            yourPlace.obtenerEmp().add(empleado1);


        return yourPlace;
    }

}
