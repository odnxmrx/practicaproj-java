package helpers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Movie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFile {
    public void saveJson(ArrayList<Movie> movieList) throws IOException {
        // Gson build
        Gson myGson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // Recibiendo formato en MAYUS desde API
                .setPrettyPrinting()
                .create();

        // Write into file
        File myFile = new File("mymovies.json");
        FileWriter fileWrite = new FileWriter(myFile); // this needed the throws IOException
        fileWrite.write(myGson.toJson(movieList)); // Convert MovieList into JSON (with the help of Gson)
        fileWrite.close();
    }
}
