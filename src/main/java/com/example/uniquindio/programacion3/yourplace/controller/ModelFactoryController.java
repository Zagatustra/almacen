package com.example.uniquindio.programacion3.yourplace.controller;

import com.example.uniquindio.programacion3.yourplace.controller.service.IModelFactoryService;
import com.example.uniquindio.programacion3.yourplace.mapping.dto.EmpleadoDto;
import com.example.uniquindio.programacion3.yourplace.mapping.mapper.MapperYourPlace;
import com.example.uniquindio.programacion3.yourplace.model.YourPlace;
import com.example.uniquindio.programacion3.yourplace.model.Empleado;
import com.example.uniquindio.programacion3.yourplace.util.YourPlaceUtils;

import java.util.ArrayList;
import java.util.List;

public class ModelFactoryController implements IModelFactoryService,Runnable
{

    MapperYourPlace mapper = MapperYourPlace.INSTANCE;
    YourPlace yourPlace;
    @Override
    public void run() {

    }
//-----------------------------------------------------------//
    private static class SingletonHolder {
       private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
   }
    private void cargarDatosBase() {
        yourPlace = YourPlaceUtils.cargarAlmacen();
    }
    public static ModelFactoryController getInstance(){return SingletonHolder.eINSTANCE;}
    public ModelFactoryController(){
        cargarDatosBase();
    }


    //---------------------------------------------------------//
    public boolean agregarCliente(EmpleadoDto empleadoDto){
      try{
            if(!(yourPlace.verificarExistenciaEmpleado(empleadoDto.identificacion()))){

                getYourPlace().obtenerEmp().add(mapper.empleadoDtoToEmpleado(empleadoDto));
                return true;

            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    public List<EmpleadoDto> obtenerEmplados() {
        List<Empleado> lista1 = new ArrayList<>(getYourPlace().obtenerEmp());


        return mapper.getEmpleadosDto(lista1);
    }



    @Override
    public boolean actualizarEmpleado(EmpleadoDto empleadoDto) {

            Empleado c = mapper.empleadoDtoToEmpleado(empleadoDto);
            if (getYourPlace().actualizarNatural(c)) {
                return true;
            } else {
                return false;
            }
    }
      @Override
        public boolean eliminarUsuario(EmpleadoDto empleadoDto) {
        Empleado c = mapper.empleadoDtoToEmpleado(empleadoDto);
            if (getYourPlace().eliminarNatural(c)) {
                return true;
            } else {
                return false;
            }
    }
    public YourPlace getYourPlace(){
       return yourPlace;
    }
}
