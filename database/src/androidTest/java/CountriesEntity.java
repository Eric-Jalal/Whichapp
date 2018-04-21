import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by teslaa on 4/22/18.
 */

@Entity
public class CountriesEntity {


    @PrimaryKey
    private int phone;

    @ColumnInfo(name = "iso")
    private String iso;

    @ColumnInfo(name = "name")
    private String name;


    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
