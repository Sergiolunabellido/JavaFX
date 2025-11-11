package com.example.ejercicio32;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    public Circle circuloRojo;

    public Circle circuloAmarillo;
    public Circle circuloVerde;
    public Button Boton;
    int contador;

    public void siguiente() {

        contador++;
        if (contador == 1){

            circuloRojo.setFill(Color.RED);

        }else if (contador == 2){

            circuloAmarillo.setFill(Color.YELLOW);
            circuloRojo.setFill(Color.GREY);

        }else if (contador == 3){
            circuloVerde.setFill(Color.GREEN);
            circuloAmarillo.setFill(Color.GREY);

        }


        if (contador == 4){

            circuloVerde.setFill(Color.GREY);
            contador = 0;

        }

    }

    public void colorRojo(){

        circuloRojo.setFill(Color.RED);

    }

    public void colorAmarillo(){
        circuloAmarillo.setFill(Color.YELLOW);
    }
    public void colorVerde(){
        circuloVerde.setFill(Color.GREEN);
    }
    public void colorGrisVerde(){
        circuloVerde.setFill(Color.GREY);
    }
    public void colorGrisRojo(){
        circuloRojo.setFill(Color.GREY);
    }
    public void colorGrisAmarillo(){
        circuloAmarillo.setFill(Color.GREY);
    }

}