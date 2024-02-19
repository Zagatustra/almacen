package com.example.uniquindio.programacion3.almacen.util;

import com.example.uniquindio.programacion3.almacen.model.Almacen;
import com.example.uniquindio.programacion3.almacen.model.Cliente;
import com.example.uniquindio.programacion3.almacen.model.Natural;
import com.example.uniquindio.programacion3.almacen.model.Juridico;
import com.example.uniquindio.programacion3.almacen.model.Producto;

import java.time.LocalDate;


public class AlmacenUtils {
    public AlmacenUtils(){

    }
    public static Almacen cargarAlmacen(){
        Almacen almacen = new Almacen();

            Natural natural = new Natural();

            natural.setNombre("Pedro");
            natural.setApellido("Navaja");
            natural.setDireccion("Torres del rio b 2 apto 502");
            natural.setIdentificacion("1094948276");

            natural.setTelefono("3195796547");
            natural.setEmail("qwe@gmail.com");
            natural.setFecNac(LocalDate.now());
            almacen.getListaNat().add(natural);

            Natural natural1 = new Natural();
            natural1.setNombre("Aleja");
            natural1.setApellido("Bueno");
            natural1.setDireccion("Torres del rio b 3 apto 502");
            natural1.setIdentificacion("1094948277");
            natural1.setTelefono("3195796548");
            natural1.setEmail("qwe@gmail.com");
            natural1.setFecNac(LocalDate.now());
            almacen.getListaNat().add(natural1);

            Juridico natural2 = new Juridico();
        natural2.setNombre("Aleja");
        natural2.setApellido("Bueno");
        natural2.setDireccion("Torres del rio b 3 apto 502");
        natural2.setIdentificacion("1094948278");
        natural2.setTelefono("3195796548");
        natural2.setNit("3854384");
        almacen.getListaJur().add(natural2);
        return almacen;
    }

}
