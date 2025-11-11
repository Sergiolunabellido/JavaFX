package com.example.ejercicio3_4;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class HelloController {
    public ComboBox Colores;
    public Button Limpiar;
    public Canvas Dibujo;

    GraphicsContext gc;

    @FXML
    public void initialize() {

        gc = Dibujo.getGraphicsContext2D();

        gc.setStroke(Color.BLACK);

        Colores.setOnAction(e -> {

            if (Colores.getSelectionModel().toString().equals("Azul")) gc.setStroke(Color.BLUE);
            else if (Colores.getValue().equals("Rojo")) gc.setStroke(Color.RED);
            else if (Colores.getValue().equals("Verde")) gc.setStroke(Color.GREEN);
            else gc.setStroke(Color.BLACK);

        });

        gc.setLineWidth(3);

        Dibujo.setOnMousePressed(e -> {

            gc.beginPath();
            gc.moveTo(e.getX(), e.getY());
            gc.stroke();

        });

        Dibujo.setOnMouseDragged(e -> {
          gc.lineTo(e.getX(), e.getY());
          gc.stroke();
        });

    }



    public void limpiar(){

        gc.clearRect(0,0,Dibujo.getWidth(),Dibujo.getHeight());

    }
   }