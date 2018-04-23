package net.teslaa.whichapptest;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by teslaa on 4/23/18.
 */

public interface ApiRepository {
    Observable<List<Country>> getCountries();
}
