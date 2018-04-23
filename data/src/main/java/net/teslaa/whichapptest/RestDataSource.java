package net.teslaa.whichapptest;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by teslaa on 4/23/18.
 */

public class RestDataSource implements ApiRepository{
    private ApiService apiService;

    public RestDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Country>> getCountries() {
        return apiService.getCountries();
    }
}
