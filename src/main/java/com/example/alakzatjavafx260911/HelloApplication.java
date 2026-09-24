package com.example.alakzatjavafx260911;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        Image windowIconImage = null;
        if (!HelloAppTest.isRunningTest)  scene = new Scene(fxmlLoader.load());
        if (!HelloAppTest.isRunningTest) stage.setTitle("Alakzatok");
        if (!HelloAppTest.isRunningTest) stage.setScene(scene);
        if (!HelloAppTest.isRunningTest)  windowIconImage = new Image("file:icons/icons/negyzet.png");
        if (!HelloAppTest.isRunningTest) stage.getIcons().add(windowIconImage);
        if (!HelloAppTest.isRunningTest) stage.show();
    }

    public static void main(String[] args) {
        if (!HelloAppTest.isRunningTest) launch();
    }
}