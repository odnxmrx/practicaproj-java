package models;

public class Song extends Audio{
    private String album;
    private String singer;
    private String genre;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // We set a new classification special for songs
    @Override
    public int getClassification() {
        if (getTotalLikes() >= 100){
            return 8;
        } else {
            return 4;
        }
    }
}
