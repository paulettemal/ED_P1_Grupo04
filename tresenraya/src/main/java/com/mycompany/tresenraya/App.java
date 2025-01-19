package com.mycompany.tresenraya;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static String pathFiles="src/main/resources/files/";
    //publics static String pathImg="src/main/resources/images/";
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader=new FXMLLoader(App.class.getResource("SeleccionarFicha.fxml"));
        
        Parent root=fxmLoader.load();
        scene=new Scene(root,600,500);
        stage.setScene(scene);
        stage.setTitle("Tres En Raya - Seleccion de ficha");
        stage.setResizable(false);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}