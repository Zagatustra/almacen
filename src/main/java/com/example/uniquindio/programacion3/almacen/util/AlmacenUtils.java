package com.example.uniquindio.programacion3.almacen.util;

import com.example.uniquindio.programacion3.almacen.model.Almacen;
import com.example.uniquindio.programacion3.almacen.model.Cliente;
import com.example.uniquindio.programacion3.almacen.model.Natural;
import com.example.uniquindio.programacion3.almacen.model.Juridico;
import com.example.uniquindio.programacion3.almacen.model.Producto;


public class AlmacenUtils {
    public AlmacenUtils(){

    }
    public static Almacen cargarAlmacen(){
        Almacen almacen = new Almacen();

            Cliente natural = new Cliente();

            natural.setNombre("Pedro");
            natural.setApellido("Navaja");
            natural.setDireccion("Torres del rio b 2 apto 502");
            natural.setIdentificacion("1094948276");

            natural.setTelefono("3195796547");

            almacen.getListaCliente().add(natural);

            natural.setNombre("Aleja");
            natural.setApellido("Bueno");
            natural.setDireccion("Torres del rio b 3 apto 502");
            natural.setIdentificacion("1094948277");

            natural.setTelefono("3195796548");

            almacen.getListaCliente().add(natural);

        return almacen;
    }

}
