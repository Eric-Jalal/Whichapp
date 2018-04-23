package net.teslaa.whichapptest.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import java.util.Objects;

/**
 * Created by teslaa on 4/23/18.
 */

@Entity(tableName = "countries")
public class Country {
    public static DiffUtil.ItemCallback<Country> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Country>() {
        @Override
        public boolean areItemsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return oldItem.iso == newItem.iso;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return oldItem.equals(newItem);
        }
    };
    @NonNull
    @PrimaryKey
    private String iso;
    private String name;
    private String phone;

    public Country(String iso, String name, String phone) {
        this.iso = iso;
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        Country user = (Country) obj;

        return Objects.equals(user.iso, this.iso) &&
                Objects.equals(user.name, this.name) &&
                Objects.equals(user.phone, this.phone);
    }
}
