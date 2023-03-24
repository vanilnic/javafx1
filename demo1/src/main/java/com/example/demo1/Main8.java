package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main8 extends Application {
    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage primaryStage) throws Exception{
        CustomControl customControl = new CustomControl();

        Group root = new Group();
        root.getChildren().addAll(customControl);
        primaryStage.setScene(new Scene(root, 500,500));
        primaryStage.show();
    }
}
