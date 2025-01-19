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
        FXMLLoader fxmLoader=new FXMLLoader(App.class.getResource("PantallaInicial.fxml"));
        
        Parent root=fxmLoader.load();
        scene=new Scene(root,600,500);
        stage.setScene(scene);
        stage.setTitle("TIC TAC TOE");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/images/icon.png")));
        stage.setResizable(false);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}
