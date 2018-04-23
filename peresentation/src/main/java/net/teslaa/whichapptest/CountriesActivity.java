package net.teslaa.whichapptest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.teslaa.whichapptest.entities.Country;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CountriesActivity extends AppCompatActivity {
    @Inject
    CountriesViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_countries);

//            viewModel.getAllof();

            recyclerView = findViewById(R.id.recyclerView);
            recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<Country>());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(recyclerViewAdapter);

            viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);

            viewModel.getAllof().observe(
                    CountriesActivity.this,
                    new Observer<List<Country>>() {
                        @Override
                        public void onChanged(@android.support.annotation.Nullable List<Country> countries) {
                            recyclerViewAdapter.addItems(countries);
                        }

            });

        }

    }
