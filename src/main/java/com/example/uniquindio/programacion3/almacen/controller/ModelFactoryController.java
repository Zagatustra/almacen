package com.example.uniquindio.programacion3.almacen.controller;

import com.example.uniquindio.programacion3.almacen.controller.service.IModelFactoryService;
import com.example.uniquindio.programacion3.almacen.mapping.dto.ClienteDto;
import com.example.uniquindio.programacion3.almacen.mapping.mapper.MapperAlmacen;
import com.example.uniquindio.programacion3.almacen.model.Almacen;
import com.example.uniquindio.programacion3.almacen.model.Cliente;
import com.example.uniquindio.programacion3.almacen.model.Juridico;
import com.example.uniquindio.programacion3.almacen.model.Natural;
import com.example.uniquindio.programacion3.almacen.util.AlmacenUtils;

import java.util.ArrayList;
import java.util.List;

public class ModelFactoryController implements IModelFactoryService,Runnable
{

    MapperAlmacen mapper =MapperAlmacen.INSTANCE;
    Almacen almacen;
    @Override
    public void run() {

    }
//-----------------------------------------------------------//
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


    //---------------------------------------------------------//
    public boolean agregarCliente(ClienteDto clienteDto){
       try{
           if(!(almacen.verificarExistenciaCliente(clienteDto.identificacion()))){
               if(clienteDto.fecNac()==null){
                getAlmacen().getListaJur().add(mapper.clienteDtoToJuridico(clienteDto));
                return true;
               }else{
                   getAlmacen().getListaNat().add(mapper.clienteDtoToNatural(clienteDto));
                   return true;
               }
           }else{
               return false;
           }
       }catch (Exception e){
           return false;
       }
    }
    public List<ClienteDto> obtenerNat() {
        List<Natural> lista1 = new ArrayList<>(getAlmacen().obtenerNat());
        List<Juridico> lista2 = new ArrayList<>(getAlmacen().obtenerJur());

        return mapper.getClientesDtoNa(lista1);
    }
    public List<ClienteDto> obtenerJur() {

        List<Juridico> lista2 = new ArrayList<>(getAlmacen().obtenerJur());

        return mapper.getClientesDtoJu(lista2);
    }


    @Override
    public boolean actualizarCliente(ClienteDto clienteDto) {
        if(clienteDto.fecNac()!=null){
            Natural c = mapper.clienteDtoToNatural(clienteDto);
            if (getAlmacen().actualizarNatural(c)) {
                return true;
            } else {
                return false;
            }
        }else {Juridico c = mapper.clienteDtoToJuridico(clienteDto);
            if (getAlmacen().actualizarJuridico(c)) {
                return true;
            } else {
                return false;
            }
    }
    }
      @Override
        public boolean eliminarCliente(ClienteDto clienteDto) {
        if(clienteDto.fecNac()!=null){
        Natural c = mapper.clienteDtoToNatural(clienteDto);
            if (getAlmacen().eliminarNatural(c)) {
                return true;
            } else {
                return false;
            }
            }else {Juridico c = mapper.clienteDtoToJuridico(clienteDto);
            if (getAlmacen().eliminarJuridico(c)) {
                return true;
            } else {
                return false;
            }

    }}
    public Almacen getAlmacen(){
       return almacen;
    }
}
