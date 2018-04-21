import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by teslaa on 4/22/18.
 */

@Database(entities = {CountriesEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CountriesEntity countriesEntity();
}