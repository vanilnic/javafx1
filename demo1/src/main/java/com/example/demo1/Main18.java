package com.example.demo1;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Main18 extends Application {

    private PerspectiveCamera camera;
    private final double sceneWidth = 600;
    private final double cameraModifier = 50.0;
    private final double cameraQuantity = 10.0;
    private final double sceneHeight = 600;
    private double mouseXold = 0;
    private double mouseYold = 0;
    private final double cameraYlimit = 15;
    private final double rotateModifier = 25;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Camera camera = new PerspectiveCamera(true);
        camera.setFarClip(50000.0);
        camera.setTranslateZ(-1000);

        Cylinder cylinder = new Cylinder(50, 100);
        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKORANGE);
        blueMaterial.setSpecularColor(Color.NAVAJOWHITE);
        cylinder.setMaterial(blueMaterial);

        cylinder.setRotationAxis(Rotate.X_AXIS);
        cylinder.setRotate(45);

        Group root = new Group();
        root.getChildren().addAll(cylinder);
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.PLUM);
        scene.setCamera(camera);

       /* scene.setOnMouseClicked(event-> {
            Node picked = event.getPickResult().getIntersectedNode();
            if(null != picked) {
                double scalar = 2;
                if(picked.getScaleX() > 1)
                    scalar = 1;
                picked.setScaleX(scalar);
                picked.setScaleY(scalar);
                picked.setScaleZ(scalar);
            }
        });*/

        scene.setOnKeyPressed(event -> {
            double change = cameraQuantity;
            if (event.isShiftDown()) {
                change = cameraModifier;
            }
            KeyCode keycode = event.getCode();
            if (keycode == KeyCode.W) {
                camera.setTranslateZ(camera.getTranslateZ() + change);
            }
            if (keycode == KeyCode.S) {
                camera.setTranslateZ(camera.getTranslateZ() - change);
            }
            if (keycode == KeyCode.A) {
                camera.setTranslateX(camera.getTranslateX() - change);
            }
            if (keycode == KeyCode.D) {
                camera.setTranslateX(camera.getTranslateX() + change);
            }
        });

        Rotate xRotate = new Rotate(0,0,0,0,Rotate.X_AXIS);
        Rotate yRotate = new Rotate(0,0,0,0,Rotate.Y_AXIS);
        camera.getTransforms().addAll(xRotate,yRotate);
        scene.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED || event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double mouseXnew = event.getSceneX();
                double mouseYnew = event.getSceneY();
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    double pitchRotate = xRotate.getAngle() + (mouseYnew - mouseYold) / rotateModifier;
                    pitchRotate = pitchRotate > cameraYlimit ? cameraYlimit : pitchRotate;
                    pitchRotate = pitchRotate < -cameraYlimit ? -cameraYlimit : pitchRotate;
                    xRotate.setAngle(pitchRotate);
                    double yawRotate = yRotate.getAngle() - (mouseXnew - mouseXold) / rotateModifier;
                    yRotate.setAngle(yawRotate);
                }
                mouseXold = mouseXnew;
                mouseYold = mouseYnew;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}