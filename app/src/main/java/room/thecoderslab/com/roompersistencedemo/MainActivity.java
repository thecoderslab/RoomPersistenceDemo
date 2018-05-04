package room.thecoderslab.com.roompersistencedemo;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME="movie_db";
    private MovieDatabase movieDatabase;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating instance of movieDatabase
        movieDatabase = Room.databaseBuilder(getApplicationContext(),MovieDatabase.class,DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        // .allowMainThreadQueries() //use this to allow query in main thread(not recommended may cause ANR)
                        .build();

        //adding button dynamically in layout
        Button button = new Button(this);
        button.setText(R.string.button_label_text);

        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        layout.addView(button);

       //setting up onclick listener for button click
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //performing database operation in new thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Movies movie = new Movies();
                        movie.setMovieID(21);
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
