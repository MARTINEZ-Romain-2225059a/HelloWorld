package com.example.partie2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.geometry.Pos.*;

public class Exo4 extends Application {
    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        BorderPane root = new BorderPane();

        Label text = new Label("");
        Button Vert = new Button("Vert");
        Button Rouge = new Button("Rouge");
        Button Bleu = new Button("Bleu");

        //Texte du haut
        VBox haut = new VBox();
        root.setTop(haut);
        haut.getChildren().addAll(text);
        haut.setAlignment(Pos.CENTER);

        //Boutons du bas
        HBox hboxbas = new HBox();
        hboxbas.getChildren().addAll(Vert, Rouge, Bleu);
        root.setBottom(hboxbas);
        hboxbas.setAlignment(Pos.CENTER);
        HBox.setMargin( Vert, new Insets(10.0d, 10.0d, 10.0d, 0.0d) );
        HBox.setMargin( Rouge, new Insets(10.0d, 10.0d, 10.0d, 0.0d) );
        HBox.setMargin( Bleu, new Insets(10.0d, 10.0d, 10.0d, 0.0d) );

        //Milieu
        Pane Milieu = new Pane();
        Milieu.setStyle("-fx-background-color: blank;");
        root.setCenter(Milieu);

        Vert.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Milieu.setStyle("-fx-background-color: green;");
                text.setText(Vert.getText()+" choisi "+ ++nbVert +" fois");
            }
        });

        Rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Milieu.setStyle("-fx-background-color: red;");
                text.setText(Rouge.getText()+" choisi "+ ++nbRouge +" fois");
            }
        });

        Bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Milieu.setStyle("-fx-background-color: Blue;");
                text.setText(Bleu.getText()+" choisi "+ ++nbBleu +" fois");
            }
        });

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 400 );
        primaryStage.setHeight( 200 );
        primaryStage.setTitle("");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
