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
    @Query("SELECT * FROM user")
    List<CountriesEntity> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<CountriesEntity> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    CountriesEntity findByName(String first, String last);

    @Insert
    void insertAll(CountriesEntity... users);

    @Delete
    void delete(CountriesEntity user);
}
