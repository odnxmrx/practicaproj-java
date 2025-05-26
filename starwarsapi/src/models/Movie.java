package models;

public class Movie {
    private String title;
    private String director;
    private String openingCrawl;
    private String releaseDate;

    // Constructors
    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Movie(MovieDto movieDto){
        this.title = movieDto.title();
        this.director = movieDto.director();
        this.openingCrawl = movieDto.openingCrawl();
        this.releaseDate = movieDto.releaseDate();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    // Setters
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Movie: " +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate='" + releaseDate + "'.";
    }
}
