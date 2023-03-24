package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main9 extends Application {
    public static void main(String[] args) {launch();}
    @Override
    public void start(Stage primaryStage) {

        Button button = new Button("press");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ation");
            }
        });
        button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("event handler");
            }
        });

        Group root = new Group();
        root.getChildren().addAll(button);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }
}
