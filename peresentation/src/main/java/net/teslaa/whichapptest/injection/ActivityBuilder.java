package net.teslaa.whichapptest.injection;

import net.teslaa.whichapptest.CountriesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by teslaa on 4/23/18.
 */

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = CountriesActivityModule.class)
    abstract CountriesActivity bindActivity();
}
