package net.teslaa.whichapptest;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import net.teslaa.whichapptest.entities.Country;

import java.util.List;

/**
 * Created by teslaa on 4/23/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Country> countriesModelList;

    public RecyclerViewAdapter(List<Country> countriesModelList){
        this.countriesModelList = countriesModelList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position){
        Country countriesModel =  countriesModelList.get(position);
        holder.isoTextView.setText(countriesModel.getIso());
        holder.nameTextView.setText(countriesModel.getName());
        holder.phoneTextView.setText(countriesModel.getPhone());
    }

    @Override
    public int getItemCount() {
        return countriesModelList.size();
    }

    public void addItems(List<Country> countriesModels){
        this.countriesModelList = countriesModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView isoTextView;
        private TextView nameTextView;
        private TextView phoneTextView;

        RecyclerViewHolder(View view) {
            super(view);
            isoTextView = (TextView) view.findViewById(R.id.isoCodeTextView);
            nameTextView = (TextView) view.findViewById(R.id.countryNameTextView);
            phoneTextView = (TextView) view.findViewById(R.id.phoneCodeTextView);
        }
    }
}
