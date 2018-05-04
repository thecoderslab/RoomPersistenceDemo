package room.thecoderslab.com.roompersistencedemo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Movies {


    @PrimaryKey(autoGenerate = true)
    private int id;

    private int movieID;
    private String movieTitle;
    private String movieOverview;

    public Movies() {
    }

    public Movies(int id, int movieID, String movieTitle, String movieOverview) {
        this.id = id;
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieOverview = movieOverview;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
