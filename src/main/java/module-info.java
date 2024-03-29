module com.example.uniquindio.programacion.yourplace {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.mapstruct;



    opens com.example.uniquindio.programacion3.yourplace to javafx.fxml;
    opens com.example.uniquindio.programacion3.yourplace.model to javafx.graphics;
    opens com.example.uniquindio.programacion3.yourplace.mapping.mapper to org.mapstruct;


    exports com.example.uniquindio.programacion3.yourplace.model;
    exports com.example.uniquindio.programacion3.yourplace.mapping.dto;
    exports com.example.uniquindio.programacion3.yourplace to javafx.graphics;

    exports com.example.uniquindio.programacion3.yourplace.viewController;
    opens com.example.uniquindio.programacion3.yourplace.viewController to javafx.fxml;
    exports com.example.uniquindio.programacion3.yourplace.util;
    opens com.example.uniquindio.programacion3.yourplace.util to javafx.graphics;
}