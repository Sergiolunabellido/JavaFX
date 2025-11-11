package com.example.ejercicio31;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class HelloController {
    public TextField TFBuscar;
    public Button Buscar;
    public Label TextoError;
    public TableView<Producto> TVProductos;
    public TextField Nombre;
    public ComboBox Categoria;
    public TextField Precio;
    public Button Añadir;
    public Button Eliminar;
    public TableColumn NombreTabla;
    public TableColumn ColumnCategoria;
    public TableColumn ColumnPrecio;
    ArrayList<Producto> listaProductos = new ArrayList<>();


    @FXML
    public void añadir(){

        NombreTabla.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        ColumnCategoria.setCellValueFactory(new PropertyValueFactory<Producto, String>("categoria"));
        ColumnPrecio.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));

        String precio = Precio.getText();
        if (precio.matches("\\d+")){
            listaProductos.add(new Producto(Nombre.getText(), Categoria.getValue().toString(), Precio.getText()));
            for (int i = 0; i < listaProductos.size(); i++) {

                TVProductos.getItems().remove(listaProductos.get(i));
                TVProductos.getItems().add(listaProductos.get(i));

            }
            Nombre.setText("");
            Categoria.setValue("Elige");
            Precio.setText("");
            TextoError.setText("Producto añadido con exito");
        }else TextoError.setText("El precio tiene que ser digito");





    }

    @FXML
    public void eliminar(){

       TVProductos.getItems().remove(TVProductos.getSelectionModel().getSelectedIndex());
       listaProductos.remove(TVProductos.getSelectionModel().getSelectedIndex());
       Nombre.setText("");
       Categoria.setValue(null);
       Precio.setText("");
       TextoError.setText("Producto eliminado con exito");

    }

    @FXML
    public void buscar(){

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).nombre.contains(TFBuscar.getText())) TextoError.setText("Se a encontrado el producto.");
            else TextoError.setText("No se a encontrado el producto.");

        }


    }

}