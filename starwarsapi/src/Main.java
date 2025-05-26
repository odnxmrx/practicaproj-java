import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Movie;
import models.MovieDto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                ******************
                Exploring Star Wars API
                ******************
                """);

        URI URI_API = URI.create("https://swapi.py4e.com/api/films/");
        Scanner userInput = new Scanner(System.in);
        ArrayList<Movie> myMovieList = new ArrayList<>();

        // Gson build
        Gson myGson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // Recibiendo formato en MAYUS desde API
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Enter a number between '1-6', or '0' to exit:");
            var newSearch = userInput.nextLine();

            if(newSearch.equals("0")) break;

            try{
                // HTTP Request
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest req = HttpRequest.newBuilder()
                        .uri(URI.create(URI_API + newSearch + "/"))
                        .build();

                HttpResponse<String> response = client
                        .send(req, HttpResponse.BodyHandlers.ofString());

                String myResponseJson = response.body();

                // Making object
                MovieDto movieTitleFromApi = myGson.fromJson(myResponseJson, MovieDto.class);
                //System.out.println("Obj. convert: " + movieTitle);
                Movie myMovie = new Movie(movieTitleFromApi);

                System.out.println("Ya en mi clase: " + myMovie);

                // Adding title to my list of Movies
                myMovieList.add(myMovie);

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Saving in file
        File myFile = new File("mymovies.json");
        FileWriter fileWrite = new FileWriter(myFile); // this needed the throws IOException
        fileWrite.write(myGson.toJson(myMovieList)); // Convert MovieList into JSON (with the help of Gson)
        fileWrite.close();

    }
}
