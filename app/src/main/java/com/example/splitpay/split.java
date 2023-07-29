package com.example.splitpay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class split extends AppCompatActivity {
    ArrayList<people> splitPeople;
    RecyclerView splitRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);

        SplitRVAdapter adapter = new SplitRVAdapter(splitPeople, this);
        splitRV.setAdapter(adapter);
        splitRV.setLayoutManager(new LinearLayoutManager(this));

    }

    public void reset_recycler_view(View view) {
    }

    public void add_people(View view) {

    }

    public void save_post_split(View view) {
    }
}