package room.thecoderslab.com.roompersistencedemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Movies.class} , version = 3 , exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDaoAccess movieDaoAccess();

}
