package net.teslaa.whichapptest;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by teslaa on 4/23/18.
 */

public class GetCountriesUseCase implements UseCase<Observable<List<Country>>, Void> {
    private ApiRepository apiRepository;

    public GetCountriesUseCase(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public Observable<List<Country>> execute(Void param) {
        return apiRepository.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }}
