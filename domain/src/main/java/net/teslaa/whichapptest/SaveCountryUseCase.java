package net.teslaa.whichapptest;

import net.teslaa.whichapptest.entities.Country;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by teslaa on 4/23/18.
 */

public class SaveCountryUseCase implements UseCase<Completable, Country> {
    private AppDatabase appDatabase;

    public SaveCountryUseCase(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Completable execute(final Country param) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                appDatabase.countryDao().insert(param);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
