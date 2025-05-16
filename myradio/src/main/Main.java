package main;

import models.Podcast;
import models.Song;

public class Main {
    public static void main(String[] args) {

        // New song instantiation
        Song mySong = new Song();
        mySong.setTitle("Party 4 u");
        mySong.setSinger("charlie xcx");

        // New podcast instatiation
        Podcast myPodcast = new Podcast();
        myPodcast.setPresenter("Armando Gama");
        myPodcast.setTitle("Programming with me");

    }
}
