package de.karrieretutor.LydiaHolmPablo.Pizza;

import control.Existenzebene;
import view.*;

import java.util.ArrayList;

//import view.GUI;

public class Main {

    public static void main(String[] args) {

        ArrayList<Pizza> pizzas = new ArrayList<>();
        Existenzebene existenzebene = new Existenzebene(pizzas);

        new GUI(existenzebene);

    }

}
