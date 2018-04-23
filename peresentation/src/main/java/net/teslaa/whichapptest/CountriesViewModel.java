package net.teslaa.whichapptest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.util.Log;

import net.teslaa.whichapptest.entities.Country;

import java.util.List;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by teslaa on 4/23/18.
 */

public class CountriesViewModel extends ViewModel {
    private static final String TAG = "CountriesViewModel";

    public LiveData<PagedList<Country>> countries;

    private GetCountriesUseCase getCountriesUseCase;
    private SaveCountriesUseCase saveCountriesUseCase;

    public CountriesViewModel(AppDatabase appDatabase,
                              GetCountriesUseCase getCountriesUseCase,
                              SaveCountriesUseCase saveCountriesUseCase) {
        this.getCountriesUseCase = getCountriesUseCase;
        this.saveCountriesUseCase = saveCountriesUseCase;

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                        .setPrefetchDistance(10)
                        .setPageSize(20).build();

        countries = (new LivePagedListBuilder(appDatabase.countryDao().getAll(), pagedListConfig))
                .build();
    }

    void getCountries() {
        getCountriesUseCase.execute(null).subscribe(new Consumer<List<Country>>() {
            @Override
            public void accept(List<Country> countries) throws Exception {
                Log.d(TAG, countries.toString());

                saveCountriesUseCase.execute(countries).subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d(TAG, "Save to DB done");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "Save to DB failed");
                    }
                });
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, throwable.toString());
            }
        });
    }
}
