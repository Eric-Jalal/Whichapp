package net.teslaa.whichapptest.injection;

import net.teslaa.whichapptest.AppDatabase;
import net.teslaa.whichapptest.CountriesViewModel;
import net.teslaa.whichapptest.GetCountriesUseCase;
import net.teslaa.whichapptest.SaveCountriesUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by teslaa on 4/23/18.
 */

@Module
public class CountriesActivityModule {
    @Provides
    CountriesViewModel provideCountriesViewModel(AppDatabase appDatabase,
                                                 GetCountriesUseCase getCountriesUseCase,
                                                 SaveCountriesUseCase saveCountriesUseCase) {
        return new CountriesViewModel(appDatabase,
                getCountriesUseCase,
                saveCountriesUseCase);
    }
}
