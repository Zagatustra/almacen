package com.example.uniquindio.programacion3.almacen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AlmacenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AlmacenApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 470);
        stage.setTitle("AlmacenUQ");
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}