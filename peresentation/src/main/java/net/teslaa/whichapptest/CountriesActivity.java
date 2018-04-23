package net.teslaa.whichapptest;

import android.os.Bundle;

import javax.inject.Inject;


public class CountriesActivity extends BaseActivity {
    @Inject
    CountriesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        viewModel.getCountries();
    }
}
