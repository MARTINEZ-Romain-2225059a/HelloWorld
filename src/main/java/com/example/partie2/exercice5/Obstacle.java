package com.example.partie2.exercice5;

import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public Obstacle(double x, double y, double largeur, double hauteur){

        super(x, y, largeur, hauteur);
    }
    boolean estEnCollision2(Personnage personnage){
        return getBoundsInParent().contains(personnage.getBoundsInParent())
                || personnage.getBoundsInParent().contains(getBoundsInParent());

    }
}
