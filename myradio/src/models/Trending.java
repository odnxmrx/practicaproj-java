package models;

public class Trending {
    public void adding(Audio audio) {
        if (audio.getClassification() >= 8) {
            System.out.println("The title '" + audio.getTitle() + "' is one of the top trending right now.");
        } else {
            System.out.println("The title '" + audio.getTitle() + "' is raising in popularity.");
        }
    }
}
