package com.example.uniquindio.programacion3.almacen.mapping.mapper;

import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ProductoDto;
import com.example.uniquindio.programacion3.almacen.model.Cliente;
import com.example.uniquindio.programacion3.almacen.model.Producto;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-19T00:42:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
*/
public class MapperAlmacenImpl implements MapperAlmacen {

    @Override
    public ClienteDto clienteToClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String identificacion = null;

        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        identificacion = cliente.getIdentificacion();

        String fecNac = null;

        ClienteDto clienteDto = new ClienteDto( nombre, apellido, direccion, identificacion, fecNac );

        return clienteDto;
    }

    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre( clienteDto.nombre() );
        cliente.setApellido( clienteDto.apellido() );
        cliente.setDireccion( clienteDto.direccion() );
        cliente.setIdentificacion( clienteDto.identificacion() );

        return cliente;
    }

    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        String codigo = null;
        String nombreProducto = null;
        String descripcion = null;
        double valor = 0.0d;
        int cantidad = 0;

        codigo = producto.getCodigo();
        nombreProducto = producto.getNombreProducto();
        descripcion = producto.getDescripcion();
        valor = producto.getValor();
        cantidad = producto.getCantidad();

        ProductoDto productoDto = new ProductoDto( codigo, nombreProducto, descripcion, valor, cantidad );

        return productoDto;
    }

    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCodigo( productoDto.codigo() );
        producto.setNombreProducto( productoDto.nombreProducto() );
        producto.setDescripcion( productoDto.descripcion() );
        producto.setValor( productoDto.valor() );
        producto.setCantidad( productoDto.cantidad() );

        return producto;
    }

    @Override
    public List<ProductoDto> getProductosDto(List<Producto> listaProductos) {
        if ( listaProductos == null ) {
            return null;
        }

        List<ProductoDto> list = new ArrayList<ProductoDto>( listaProductos.size() );
        for ( Producto producto : listaProductos ) {
            list.add( productoToProductoDto( producto ) );
        }

        return list;
    }
}
