package helpers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ConversionRate;
import models.ExchangeRateDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRate {
    private String API_KEY = "39417c5810cf0e8359738ff3";

    public ExchangeRateDto searchRate(int amount) {

        URI API_URL =  URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY +"/pair/EUR/MXN/" + amount);

        // HTTP Client
        HttpClient client = HttpClient.newHttpClient();
        // HTTP Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(API_URL)
                .build();

        // Gson builder
        Gson gsonBuild = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        try {
            // Response
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            //return gsonBuild.fromJson(response.body(), ExchangeRateDto.class);
            ExchangeRateDto coso =  gsonBuild.fromJson(json, ExchangeRateDto.class);
            System.out.println("cosoooooooo: " + coso);
            return coso;


        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
