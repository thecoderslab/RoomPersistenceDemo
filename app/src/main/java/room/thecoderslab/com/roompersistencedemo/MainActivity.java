package room.thecoderslab.com.roompersistencedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private MovieDatabase movieDatabase;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);

        movieDatabase = MovieDatabase.getDatabase(this);

        //insert into database when floating button in pressed
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //performing database operation in new thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Movies movie = new Movies();
                        movie.setMovieID(21 + 1);
                        movie.setMovieTitle("Avengers");
                        movie.setMovieOverview("Half of the world is wiped out");

                        movieDatabase.movieDaoAccess().insertSingleMovie(movie);

                        count = movieDatabase.movieDaoAccess().getCount();

                        Log.d("Count","rows = "+count);
                    }
                }).start();
            }
        });
    }

}

