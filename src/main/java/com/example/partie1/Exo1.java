package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox = new VBox();

        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Help = new Menu("Help");

        MenuBar menuBar = new MenuBar(File, Edit, Help);

        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Close = new MenuItem("Close");


        File.getItems().add(New);
        File.getItems().add(Open);
        File.getItems().add(Save);
        File.getItems().add(Close);

        Separator sep = new Separator();

        // Ajout des contrôleurs au conteneur principal
        vbox.getChildren().addAll(
                menuBar

        );

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox );


        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}