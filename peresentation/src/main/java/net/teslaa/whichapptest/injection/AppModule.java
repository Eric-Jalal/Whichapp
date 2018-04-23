package net.teslaa.whichapptest.injection;

import android.app.Application;
import android.content.Context;

import net.teslaa.whichapptest.ApiRepository;
import net.teslaa.whichapptest.ApiService;
import net.teslaa.whichapptest.AppDatabase;
import net.teslaa.whichapptest.GetCountriesUseCase;
import net.teslaa.whichapptest.RestDataSource;
import net.teslaa.whichapptest.SaveCountriesUseCase;
import net.teslaa.whichapptest.SaveCountryUseCase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by teslaa on 4/23/18.
 */

@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    @Named("BASE_URL")
    String provideBaseUrl() {
        return "https://api.whichapp.com/";
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named("BASE_URL") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiRepository provideApiRepository(Retrofit retrofit) {
        return new RestDataSource(retrofit.create(ApiService.class));
    }

    @Provides
    @Singleton
    GetCountriesUseCase provideGetCountriesUseCase(ApiRepository apiRepository) {
        return new GetCountriesUseCase(apiRepository);
    }

    @Provides
    @Singleton
    @Named("DATABASE_NAME")
    String provideDatabaseName() {
        return "WhichApp";
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context, @Named("DATABASE_NAME") String databaseName) {
        return AppDatabase.newInstance(context, databaseName);
    }

    @Provides
    @Singleton
    SaveCountryUseCase provideSaveCountryUseCase(AppDatabase appDatabase) {
        return new SaveCountryUseCase(appDatabase);
    }

    @Provides
    @Singleton
    SaveCountriesUseCase provideSaveCountiesUseCase(AppDatabase appDatabase) {
        return new SaveCountriesUseCase(appDatabase);
    }
}
