import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Movie;
import models.MovieDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieSearch {
    public MovieDto searchMovie(int movieNumber){
        URI myAddress = URI.create("https://swapi.py4e.com/api/films/" + movieNumber + "/");

        // HTTP Request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(myAddress)
                .build();

        // Gson build
        Gson myGson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) // Recibiendo formato en MAYUS desde API
                .setPrettyPrinting()
                .create();

        try {
            HttpResponse<String> response = null;

            response = client
                    .send(req, HttpResponse.BodyHandlers.ofString());

            return myGson.fromJson(response.body(), MovieDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
