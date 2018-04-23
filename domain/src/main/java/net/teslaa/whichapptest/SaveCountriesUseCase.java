package net.teslaa.whichapptest;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by teslaa on 4/23/18.
 */

public class SaveCountriesUseCase implements UseCase<Completable, List<Country>> {
    private AppDatabase appDatabase;

    public SaveCountriesUseCase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Completable execute(final List<Country> param) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                appDatabase.countryDao().insert(param);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
