package net.teslaa.whichapptest;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

/**
 * Created by teslaa on 4/22/18.
 */

@Dao
public interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Country country);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(List<Country> countries);

    @Query("SELECT * FROM countries ORDER BY name ASC")
    public abstract DataSource.Factory<Integer, Country> getAll();

    @Query("SELECT * FROM countries")
    public LiveData<List<Country>> getAllSync();
}
