package main;

import models.Podcast;
import models.Song;
import models.Trending;

public class Main {
    public static void main(String[] args) {

        // New song instantiation
        Song mySong = new Song();
        mySong.setTitle("Party 4 u");
        mySong.setSinger("charlie xcx");

        for (int i = 0; i < 4000; i++) {
            mySong.play();
        }

        for (int i = 0; i < 200; i++) {
            mySong.giveLike();
        }

        System.out.println("Total plays: " + mySong.getTotalPlays());
        System.out.println("Total likes: " + mySong.getTotalLikes());

        // New podcast instatiation
        Podcast myPodcast = new Podcast();
        myPodcast.setPresenter("Armando Gama");
        myPodcast.setTitle("Programming with me");

        for (int i = 0; i < 200; i++) {
            myPodcast.play();
        }

        for (int i = 0; i < 10; i++) {
            myPodcast.giveLike();
        }

        Trending favorites = new Trending();
        favorites.adding(mySong);
        favorites.adding(myPodcast);

        /*
        * La importancia de aplicar conceptos de orientación a objetos,
        * como la herencia y el polimorfismo, que permiten que las clases
        * compartan características y comportamientos, facilitando la
        * reutilización del código y la creación de aplicaciones más flexibles.
        *
        * Por ejemplo, al utilizar herencia, podrías tener una clase base
        * llamada "Contenido" de la cual tanto "Canción" como "Podcast" heredan
        * atributos y métodos comunes, lo que simplifica la gestión de estos objetos.
        * También es fundamental entender cómo el polimorfismo permite que
        * diferentes clases respondan a la misma interfaz, lo que puede ser
        * muy útil en tu aplicación de audio/música.
        * */
        
    }
}
