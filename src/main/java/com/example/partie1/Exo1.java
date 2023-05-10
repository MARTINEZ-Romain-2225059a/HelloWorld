package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Exo1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        BorderPane root = new BorderPane();

        Menu File = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu Help = new Menu("Help");

        MenuBar menuBar = new MenuBar(File, Edit, Help);

        root.setTop(menuBar);
        //File -> New, Open, Save et Close
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Close = new MenuItem("Close");

        File.getItems().add(New);
        File.getItems().add(Open);
        File.getItems().add(Save);
        File.getItems().add(Close);

        //Edit -> Cut, Copy et Paste
        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");

        Edit.getItems().add(Cut);
        Edit.getItems().add(Copy);
        Edit.getItems().add(Paste);


        //3boutons a gauche
        VBox vboxBouton = new VBox();
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        Label text = new Label("Boutons :");
        vboxBouton.getChildren().addAll(text, btn1, btn2, btn3);
        VBox.setMargin( text, new Insets(0.0d, 0.0d, 10.0d, 5.0d) );
        VBox.setMargin( btn1, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        VBox.setMargin( btn2, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        VBox.setMargin( btn3, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        vboxBouton.setAlignment(Pos.CENTER);
        root.setLeft(vboxBouton);

        //Milieu
        GridPane gridpane = new GridPane();
        Label name = new Label("Name:");
        TextField entreName = new TextField();
        gridpane.setConstraints(name, 0, 0); // column=2 row=0
        gridpane.setConstraints(entreName, 1, 0);

        Label email = new Label("Email:");
        TextField entreEmail = new TextField();
        gridpane.setConstraints(email, 0, 1); // column=2 row=0
        gridpane.setConstraints(entreEmail, 1, 1);

        Label password = new Label("Password:");
        TextField entrePassword = new TextField();
        gridpane.setConstraints(password, 0, 2); // column=2 row=0
        gridpane.setConstraints(entrePassword, 1, 2);

        Button btnSub = new Button("Submit");
        Button btnCan = new Button("Cancel");
        gridpane.setConstraints(btnSub, 0, 3); // column=2 row=0
        gridpane.setConstraints(btnCan, 1, 3);

        gridpane.setAlignment(Pos.CENTER);
        root.setCenter(gridpane);
        gridpane.getChildren().addAll(name, entreName, email, entreEmail, password, entrePassword, btnSub, btnCan);

        //separateur bas
        Separator sep = new Separator();

        // sep gauche
        Separator sepV = new Separator(Orientation.VERTICAL);
        root.getLeft();

        //Text bas
        VBox bas = new VBox();
        Label Lab = new Label("Ceci est un label de bas de page");
        bas.getChildren().addAll(sep, Lab);
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);


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