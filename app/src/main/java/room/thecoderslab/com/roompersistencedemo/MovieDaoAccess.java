package room.thecoderslab.com.roompersistencedemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MovieDaoAccess {

    @Insert
    void insertSingleMovie(Movies movies);

    @Insert
    void inserMultipleMovies(List<Movies> moviesList);

    @Query("Select * from Movies where movieID = :movieID ")
     Movies fetchMovieByID(int movieID);

    @Update
    void  updateMovie(Movies movies);

    @Delete
    void deleteMovie(Movies movies);

    @Query("Select count(*) from Movies ")
    int getCount();


}
