import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by teslaa on 4/22/18.
 */

@Dao
public interface CountriesDao {
    @Query("SELECT * FROM countriesentity")
    List<CountriesEntity> getAll();

    @Query("SELECT * FROM countriesentity WHERE phone IN (:phoneCode)")
    List<CountriesEntity> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM countriesentity WHERE iso LIKE :iso AND "
            + "last_name LIKE :name LIMIT 1")
    CountriesEntity findByName(String first, String last);

    @Insert
    void insertAll(CountriesEntity... users);

    @Delete
    void delete(CountriesEntity user);
}
