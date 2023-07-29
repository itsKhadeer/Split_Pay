package com.example.splitpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

    }

    public void equal_splitter(View view) {

        Intent intent = new Intent(this, split.class);
        this.startActivity(intent);

    }

    public void transactions_check(View view) {

        Intent intent = new Intent(this, split.class);
        this.startActivity(intent);

    }
}