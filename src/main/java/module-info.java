module com.example.uniquindio.programacion.almacen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.mapstruct;



    opens com.example.uniquindio.programacion3.almacen to javafx.fxml;
    opens com.example.uniquindio.programacion3.almacen.model to javafx.graphics;
    opens com.example.uniquindio.programacion3.almacen.mapping.mapper to org.mapstruct;


    exports com.example.uniquindio.programacion3.almacen.model;
    exports com.example.uniquindio.programacion3.almacen.mapping.dto;
    exports com.example.uniquindio.programacion3.almacen to javafx.graphics;

    exports com.example.uniquindio.programacion3.almacen.viewController;
    opens com.example.uniquindio.programacion3.almacen.viewController to javafx.fxml;
    exports com.example.uniquindio.programacion3.almacen.util;
    opens com.example.uniquindio.programacion3.almacen.util to javafx.graphics;
}