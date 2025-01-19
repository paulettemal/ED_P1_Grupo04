/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tresenraya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zaval
 */
public class ElegirTurnoController implements Initializable {

    @FXML
    private Button btnSi;
    @FXML
    private Button btnNo;
    @FXML
    private ImageView imagenFondo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image image = new Image(getClass().getResource("/images/jugarP.png").toExternalForm());
            imagenFondo.setImage(image);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
            e.printStackTrace();
        }
    }   
    
    
    public void iniciarJugador(ActionEvent event) throws IOException{
        TableroController.esTurnoJugador=true;
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Tablero.fxml"));
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root,600,500);   
        Stage s = (Stage) btnSi.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("TIC TAC TO");
        s.setResizable(false);
        s.show();
    }
    public void iniciarMaquina(ActionEvent event) throws IOException{
        TableroController.esTurnoJugador=false;
        FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("Tablero.fxml"));
        Parent root = fxmlloader.load();
        TableroController tableroController = fxmlloader.getController();
        
        Scene scene = new Scene(root,600,500);   
        Stage s = (Stage) btnNo.getScene().getWindow();
        s.setScene(scene);
        s.setTitle("TIC TAC TOE");
        s.setResizable(false);
        s.show();
        tableroController.jugarMaquina();
    }
}
