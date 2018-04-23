package net.teslaa.whichapptest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.teslaa.whichapptest.entities.Country;

/**
 * Created by teslaa on 4/23/18.
 */

@Database(entities = {Country.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase newInstance(Context context, String name) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, name).build();
    }

    abstract CountryDao countryDao();
}
