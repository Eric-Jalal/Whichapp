package net.teslaa.whichapptest;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by teslaa on 4/23/18.
 */

public interface ApiService {
    @GET("v1/countries")
    Observable<List<Country>> getCountries();
}
