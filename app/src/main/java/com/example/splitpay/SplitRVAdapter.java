package com.example.splitpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SplitRVAdapter extends RecyclerView.Adapter<SplitRVAdapter.ViewHolder> {

    ArrayList<people> data;
    Context context;

    SplitRVAdapter (ArrayList<people> people, Context context) {
        this.data = people;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_item_layout_split, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView giver_name_tv, giver_money_tv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            giver_money_tv = itemView.findViewById(R.id.giverMoney);
            giver_name_tv = itemView.findViewById(R.id.giverName);
        }
    }
}
