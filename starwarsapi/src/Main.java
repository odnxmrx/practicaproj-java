import helpers.SaveFile;
import models.Movie;
import models.MovieDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                ******************
                Exploring Star Wars API
                ******************
                """);

        MovieSearch searching = new MovieSearch();
        Scanner userInput = new Scanner(System.in);
        ArrayList<Movie> myMovieList = new ArrayList<>();

        while (true){
            System.out.println("Enter a number between '1-6', or '0' to exit:");

            try {
                var newSearch = Integer.valueOf(userInput.nextLine());

                if(newSearch.equals(0)) break;

                MovieDto movieTitleFromApi = searching.searchMovie(newSearch);
                //System.out.println("myMovie2: " + movieTitleFromApi);

                Movie myMovie = new Movie(movieTitleFromApi);

                myMovieList.add(myMovie);

                SaveFile saving = new SaveFile();
                saving.saveJson(myMovieList);

            } catch (NumberFormatException e) {
                System.out.println("Please, enter a valid number. " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
