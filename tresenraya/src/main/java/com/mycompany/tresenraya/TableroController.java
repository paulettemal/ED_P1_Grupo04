/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.tresenraya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author zaval
 */
public class TableroController implements Initializable {

    @FXML
    private AnchorPane ventanaInicial;
    @FXML
    private Button bt0;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private AnchorPane paneTablero;
    
    public static boolean esTurnoJugador;
    private Button[] arrayBotones= new Button[9];
    
    
     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        arrayBotones[0]=bt0;
        arrayBotones[1]=bt1;
        arrayBotones[2]=bt2;
        arrayBotones[3]=bt3;
        arrayBotones[4]=bt4;
        arrayBotones[5]=bt5;
        arrayBotones[6]=bt6;
        arrayBotones[7]=bt7;
        arrayBotones[8]=bt8;
        
        if(!esTurnoJugador){
            mov4(new ActionEvent());
        }
         
    }


public void empatarYTerminarPartida(){
            String mensajeEmpate="Un empate! Click para reiniciar.";
            Pane overlay = new Pane();
            overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);"); // Fondo semitransparente negro
            overlay.setPrefSize(600, 500);  // Ajustar al tamaño de la ventana
            overlay.setVisible(true);  // In
            Button button = new Button(mensajeEmpate);
            button.setLayoutX(200);  
            button.setLayoutY(250);
            paneTablero.getChildren().add(overlay);
            paneTablero.getChildren().add(button);
            button.setOnAction(event->{
                FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarFicha.fxml"));
                Parent root=null;
                try{
                    root = fxmlloader.load();
                }catch(IOException ex){
                    System.out.println("No se ha podido cargar la venatana de seleccion de ficha");
                }
                
                Scene scene = new Scene(root,600,500);   
                Stage s = (Stage) button.getScene().getWindow();
                s.setScene(scene);
                s.setTitle("Tres en Raya - Seleccion de Ficha");
                s.setResizable(false);
                s.show();
                Tablero.tablero=new char[9];
                
            });
    }

public boolean hayGanador(){
        for(int i=0;i<Tablero.combinaciones.length;i++){
            int[] combinacion =Tablero.combinaciones[i];
            boolean banderaJugador=true;
            boolean banderaMaquina=true;
            for(int e=0;e<combinacion.length;e++){
                int indice=combinacion[e];
                if(Tablero.tablero[indice]!=Tablero.jugador){
                    banderaJugador=false;
                }
                if(Tablero.tablero[indice]!=Tablero.maquina){
                    banderaMaquina=false;
                } 
            }
            if(banderaJugador){
                return banderaJugador;
            }
            if(banderaMaquina){
                return banderaMaquina;
            }
               
        }
        return false;
    }


public void senialarGanadorYTerminarPartida(){
        char fichaGanadora=' ';
        for(int i=0;i<Tablero.combinaciones.length;i++){
            int[] combinacion =Tablero.combinaciones[i];
            boolean banderaJugador=true;
            boolean banderaMaquina=true;
            for(int e=0;e<combinacion.length;e++){
                int indice=combinacion[e];
                if(Tablero.tablero[indice]!=Tablero.jugador){
                    banderaJugador=false;
                }
                if(Tablero.tablero[indice]!=Tablero.maquina){
                    banderaMaquina=false;
                } 
            }
            if(banderaJugador){
                fichaGanadora=Tablero.jugador;
                break;
            }
            if(banderaMaquina){
                fichaGanadora=Tablero.maquina;
                break;
            }
                
  
        }
        if(fichaGanadora!=' '){
            String mensajeGanador="";
            if(fichaGanadora==Tablero.jugador){
                mensajeGanador="Ha ganado usted. Click para Reiniciar.";
            }else{
                mensajeGanador="Ha ganado la maquina. Click para reiniciar.";
            }
            
            Pane overlay = new Pane();
            overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);"); // Fondo semitransparente negro
            overlay.setPrefSize(600, 500);  // Ajustar al tamaño de la ventana
            overlay.setVisible(true);  // In
            Button button = new Button(mensajeGanador);
            button.setLayoutX(200);  
            button.setLayoutY(250);
            paneTablero.getChildren().add(overlay);
            paneTablero.getChildren().add(button);
            button.setOnAction(event->{
                FXMLLoader fxmlloader = new FXMLLoader(App.class.getResource("SeleccionarFicha.fxml"));
                Parent root=null;
                try{
                    root = fxmlloader.load();
                }catch(IOException ex){
                    System.out.println("No se ha podido cargar la venatana de seleccion de ficha");
                }
                
                Scene scene = new Scene(root,600,500);   
                Stage s = (Stage) button.getScene().getWindow();
                s.setScene(scene);
                s.setTitle("Tres en Raya - Seleccion de Ficha");
                s.setResizable(false);
                s.show();
                Tablero.tablero=new char[9];
                
            });
            
            
        }
        
            
            
            
            
    }


public void jugarMaquina(){
        
        int index=Tablero.indiceMovimientoMaquina();
        Tablero.tablero[index]=Tablero.maquina;
        Image image1 = new Image(getClass().getResourceAsStream("/images/"+Tablero.maquina+".png"));  
        ImageView imagenMaquina = new ImageView(image1);
        imagenMaquina.setFitWidth(90);  
        imagenMaquina.setFitHeight(90); 
        arrayBotones[index].setGraphic(imagenMaquina);
        senialarGanadorYTerminarPartida();
        esTurnoJugador=true;
        if(estaSinHuecos()){
            if(!hayGanador()){
                empatarYTerminarPartida();
            }
        }
        
    }



    
   
    
    public void manejarTurno(int index){
        if(esTurnoJugador){
            //jugarJugador(index);
        }else{
            //jugarMaquina();
        }
    }
    
    public boolean estaSinHuecos(){
        int contador=0;
        for(int i=0; i<Tablero.tablero.length;i++){
            if(Tablero.tablero[i]=='\u0000'){
                contador++;
            }
        }
        return contador==0;
    }
    
    
    public void mov0(ActionEvent event){
        manejarTurno(0);
        
        
    }
    
    public void mov1(ActionEvent event){
        
       manejarTurno(1);
        
    }
    
    public void mov2(ActionEvent event){
        manejarTurno(2);
        
    }
    public void mov3(ActionEvent event){
        manejarTurno(3);
    }
    public void mov4(ActionEvent event){
        manejarTurno(4);
        
    }
    public void mov5(ActionEvent event){
        manejarTurno(5);
        
    }
    public void mov6(ActionEvent event){
        manejarTurno(6);
        
    }
    public void mov7(ActionEvent event){
        manejarTurno(7);
        
    }
    public void mov8(ActionEvent event){
        manejarTurno(8);
        
    }
    
}
