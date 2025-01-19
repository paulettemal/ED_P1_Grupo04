/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tresenraya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ElegirFichaController implements Initializable {

    @FXML
    private ImageView imgCirculo;
    @FXML
    private ImageView imgEquis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgCirculo.setOnMouseEntered(event -> {
            new ScaleTransition(Duration.millis(200), imgCirculo).setToX(1.1);
        });
        imgCirculo.setOnMouseExited(event -> {
            new ScaleTransition(Duration.millis(200), imgCirculo).setToX(1.0);
        });
        
        imgEquis.setOnMouseEntered(event -> {
            new ScaleTransition(Duration.millis(200), imgEquis).setToX(1.1);
        });
        imgEquis.setOnMouseExited(event -> {
            new ScaleTransition(Duration.millis(200), imgEquis).setToX(1.0);
        });

        imgCirculo.setOnMouseClicked(event -> {
            Tablero.jugador = 'O'; 
            Tablero.maquina = 'X';
            if (Tablero.esModoJugadorVsJugador) {
                cargarTablero();
            } else if (Tablero.esModoMaquinaVsJugador) {
                cargarSeleccionTurno();
            }
        });
        
        imgEquis.setOnMouseClicked(event -> {
            Tablero.jugador = 'X';
            Tablero.maquina = 'O';
            if (Tablero.esModoJugadorVsJugador) {
                cargarTablero();  
            } else if (Tablero.esModoMaquinaVsJugador) {
                cargarSeleccionTurno(); 
            }
        });
    }
    
    private void cargarSeleccionTurno() {
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarTurno.fxml"));
        Parent root = null;
        try {
            root = fxmlloader.load();
        } catch (IOException ex) {
            System.out.println("No se ha podido cargar la ventana de selección de turno.");
        }

        Scene scene = new Scene(root, 600, 500);
        Stage s = (Stage) imgCirculo.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("Tres En Raya - Selección de turno");
        s.setResizable(false);
        s.show();
    }

    private void cargarTablero() {
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Tablero.fxml"));
        Parent root = null;
        try {
            root = fxmlloader.load();
        } catch (IOException ex) {
            System.out.println("No se ha podido cargar el tablero.");
        }

        Scene scene = new Scene(root, 600, 500);
        Stage s = (Stage) imgCirculo.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("Tres En Raya - Tablero");
        s.setResizable(false);
        s.show();
    }
}
