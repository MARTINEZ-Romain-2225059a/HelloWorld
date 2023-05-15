package com.example.partie2.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.AQUA;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        //Obstacle
        Obstacle mur = new Obstacle(100, 100, 40,100);
        mur.setFill(AQUA);
        //on construit une scene 640 * 480 pixels
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(mur);
        root.setCenter(jeu);

        //Game over
        VBox gameOver = new VBox();
        Label finitot = new Label("Game Over");
        Button quitter = new Button("Quitter");
        gameOver.getChildren().addAll(finitot, quitter);
        gameOver.setAlignment(Pos.CENTER);
        gameOver.setMargin( finitot, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );

        quitter.setOnAction(event -> {
            Platform.exit();
        });

        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, mur, gameOver);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     *
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacle mur, VBox gameOver) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double j1x = j1.getLayoutX();
            double j1y = j1.getLayoutY();
            double j2x = j2.getLayoutX();
            double j2y = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;

                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;

            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                root.setCenter(gameOver);
            }
            if (mur.estEnCollision2(j1)) {
                System.out.println("J1 Collision avec le mur");
                j1.setLayoutX(j1x);
                j1.setLayoutY(j1y);
            }
            if (mur.estEnCollision2(j2)) {
                System.out.println("J2 Collision avec le mur");
                j2.setLayoutX(j2x);
                j2.setLayoutY(j2y);
            }
        });
    }


}
