/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.Arrays;

public class PantallaInicialController {

    @FXML
    private ImageView imagenFondo;

    @FXML
    private Button btnMaquinaVsHumano;

    @FXML
    private Button btnJugadorVsJugador;
    
    @FXML
    public void initialize() {
        Image image = new Image(getClass().getResource("/images/img.png").toExternalForm());
        imagenFondo.setImage(image);

        imagenFondo.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                imagenFondo.fitWidthProperty().bind(newScene.widthProperty());
                imagenFondo.fitHeightProperty().bind(newScene.heightProperty());
            }
        });

        btnMaquinaVsHumano.setOnAction(event -> abrirSeleccionFicha());
        btnJugadorVsJugador.setOnAction(event -> iniciarJugadorVsJugador());
    }

    private void abrirSeleccionFicha() {
        try {
            Tablero.esModoJugadorVsJugador = false;
            Tablero.esModoMaquinaVsJugador = true;
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarFicha.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 600, 500);
            Stage stage = (Stage) btnMaquinaVsHumano.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Tres En Raya - Selección de Ficha");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void iniciarJugadorVsJugador() {
        Tablero.esModoJugadorVsJugador = true;
        Arrays.fill(Tablero.tablero, '\u0000');

        try {
            Tablero.esModoJugadorVsJugador = true;
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarFichaJ.fxml"));
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root, 600, 500);
            Stage stage = (Stage) btnJugadorVsJugador.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Tres En Raya - Selección de Ficha");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
