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

/**
 * FXML Controller class
 *
 * @author zaval
 */
public class ElegirFichaController implements Initializable {
    @FXML
    private ImageView imgCirculo;
    @FXML
    private ImageView imgEquis;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ScaleTransition scaleIn = new ScaleTransition(Duration.millis(200), imgCirculo);
        scaleIn.setToX(1.1);
        scaleIn.setToY(1.1);

        TranslateTransition translateIn = new TranslateTransition(Duration.millis(200), imgCirculo);
        translateIn.setToX(-5);
        translateIn.setToY(-5);

        ScaleTransition scaleOut = new ScaleTransition(Duration.millis(500), imgCirculo);
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);

        TranslateTransition translateOut = new TranslateTransition(Duration.millis(500), imgCirculo);
        translateOut.setToX(0);
        translateOut.setToY(0);

        ScaleTransition scaleIn2 = new ScaleTransition(Duration.millis(300), imgEquis);
        scaleIn2.setToX(1.1);
        scaleIn2.setToY(1.1);

        TranslateTransition translateIn2 = new TranslateTransition(Duration.millis(300), imgEquis);
        translateIn2.setToX(-5);
        translateIn2.setToY(-5);

        ScaleTransition scaleOut2 = new ScaleTransition(Duration.millis(500), imgEquis);
        scaleOut2.setToX(1.0);
        scaleOut2.setToY(1.0);

        TranslateTransition translateOut2 = new TranslateTransition(Duration.millis(500), imgEquis);
        translateOut2.setToX(0);
        translateOut2.setToY(0);

        imgCirculo.setOnMouseEntered(event -> {
            scaleIn.play();
            translateIn.play();
        });

        imgCirculo.setOnMouseExited(event -> {
            scaleOut.play();
            translateOut.play();
        });

        imgEquis.setOnMouseEntered(event -> {
            scaleIn2.play();
            translateIn2.play();
        });

        imgEquis.setOnMouseExited(event -> {
            scaleOut2.play();
            translateOut2.play();
        });
        
        imgCirculo.setOnMouseClicked(event ->{
            Tablero.jugador='O';
            Tablero.maquina='X';
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarTurno.fxml"));
            Parent root=null;
            try{
                root= fxmlloader.load();
            }catch(IOException ex){
                System.out.println("No se ha podido cargar la ventana 2 de seleccion de turno. ");
                
            }
            
            Scene scene = new Scene(root,600,500);   
            Stage s = (Stage) imgCirculo.getScene().getWindow();
            s.setScene(scene);
            s.setTitle("Tres En Raya - Seleccion de turno");
            s.setResizable(false);
            s.show();
        });
        
        imgEquis.setOnMouseClicked(event ->{
            Tablero.jugador='X';
            Tablero.maquina='O';
            FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarTurno.fxml"));
            Parent root=null;
            try{
                root= fxmlloader.load();
            }catch(IOException ex){
                System.out.println("No se ha podido cargar la ventana 2 de seleccion de turno. ");
                
            }
            
            Scene scene = new Scene(root,600,500);   
            Stage s = (Stage) imgEquis.getScene().getWindow();
            s.setScene(scene);
            s.setTitle("Tres En Raya - Seleccion de turno");
            s.setResizable(false);
            s.show();
        });

        
        
        
   
        
        
        
        
        
        

    }    
    
}
