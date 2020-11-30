/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ejercicio1_Tp5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kolia
 */
public class Main {

    public static void main(String[] args) {
        Compartido comedero = new Compartido(5,0); // creamos la instancia del comedero con la cnatidad de platos
        List<Thread> animales = new ArrayList<>();
        String[] especies = {"Perro", "Gato"};
        Character[] llaves = {'p','g'};

        for (int i = 0; i < especies.length; i++) {
            
            for (int j = 0; j < 5; j++) {

                animales.add(new Thread(new Animal(comedero, llaves[i]), ( especies[i] + (j + 1))));
            
        }

       /*  for (int i = 0; i < 5; i++) {
            animales.add(new Thread(new Animal(comedero, 'p'), ("Perro " + (i + 1))));

        }
        for (int i = 0; i < 5; i++) {
            animales.add(new Thread(new Animal(comedero, 'g'), ("Gato " + (i + 1))));
 */
        }

        animales.forEach((Thread animal) -> {
            animal.start();
        });

    }

}
