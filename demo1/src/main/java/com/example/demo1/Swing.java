package com.example.demo1;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import javax.swing.*;

public class swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing and javaFX");
        JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel);
        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Group group = new Group();
        Scene scene = new Scene(group, Color.ALICEBLUE);
        group.getChildren().addAll(new Button("press"));
        jfxPanel.setScene(scene);

    }
}