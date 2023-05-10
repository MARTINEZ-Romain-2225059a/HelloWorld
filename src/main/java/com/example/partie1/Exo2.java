package com.example.partie1;

import com.example.partie2.BonjourFenetre;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class Exo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        GridPane root = new GridPane();

        Label case1 = new Label();
        Label case2 = new Label();
        Label case3 = new Label();
        Label case4 = new Label();
        Label case5 = new Label();
        Label case6 = new Label();
        Label case7 = new Label();
        Label case8 = new Label();
        Label case9 = new Label();

        // Chargement de l'image
        Image croix = new Image( Exo2.class.getResource("exercice2/Croix.png").toString() );
        Image rond = new Image( Exo2.class.getResource("exercice2/Rond.png").toString() );
        Image vide = new Image( Exo2.class.getResource("exercice2/Vide.png").toString() );

        ImageView Croix = new ImageView();
        Croix.setImage(croix);
        ImageView Rond = new ImageView();
        Rond.setImage(rond);
        ImageView Vide = new ImageView();
        Vide.setImage(vide);

        Random random = new Random();
        Label[] tab = {case1, case2, case3, case4, case5, case6, case7, case8, case9};
        for(int i=0;i<9;++i){
            int nombre = random.nextInt(3);
            if(nombre == 0)
                tab[i].setGraphic(Croix);
            else if(nombre == 1)
                tab[i].setGraphic(Rond);
            else if(nombre == 2)
                tab[i].setGraphic(Vide);
        }

        root.setConstraints(case1, 0, 0); // column=2 row=0
        root.setConstraints(case2, 1, 0);
        root.setConstraints(case3, 2, 0);
        root.setConstraints(case4, 0, 1);
        root.setConstraints(case5, 1, 1);
        root.setConstraints(case6, 2, 1);
        root.setConstraints(case7, 0, 2);
        root.setConstraints(case8, 1, 2);
        root.setConstraints(case9, 2, 2);
        root.getChildren().addAll(case1, case2, case3, case4, case5, case6, case7, case8, case9);
        root.setGridLinesVisible(true);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        //primaryStage.setWidth( 800 );
        //primaryStage.setHeight( 600 );
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}