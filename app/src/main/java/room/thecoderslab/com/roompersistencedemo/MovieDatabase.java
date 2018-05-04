package room.thecoderslab.com.roompersistencedemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Movies.class} , version = 3 , exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase instance;
    private static final String DATABASE_NAME = "movie_db";

    //creating singleton
    public static MovieDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (MovieDatabase.class) {
                if (instance == null) {

                    instance = Room.databaseBuilder(context.getApplicationContext(), MovieDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            // .allowMainThreadQueries() //use this to allow query in main thread(not recommended may cause ANR)
                            .build();
                }
            }

        }
        return instance;

    }

    public abstract MovieDaoAccess movieDaoAccess();

}
