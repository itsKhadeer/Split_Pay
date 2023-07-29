package com.example.splitpay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login_activity extends AppCompatActivity {

    MaterialButton signupButton;
    EditText emailInput;
    TextInputEditText passwordInput;
    RetrofitInterface retrofitInterface;

    private final String BASE_URL = "http://192.168.29.151:8000";
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue, this.getTheme()));
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);


    }

    public void signUpFunc(View view) {
        Intent intent = new Intent(this, signup_activity.class);
        login_activity.this.startActivity(intent);
        finish();

    }

    public void loginFunc(View view) {
        emailInput = findViewById(R.id.emailBox);
        passwordInput = findViewById(R.id.passwordBox);
        String email = emailInput.getText().toString().strip();
        String password = passwordInput.getText().toString().strip();

        if(email.isBlank()) {
            Toast.makeText(this, "Enter your username!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.isBlank()) {
            Toast.makeText(this, "Enter your password! ", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("username", email);
        map.put("password", password);
        Call<LoginResult> call = retrofitInterface.executeLogin(map);
        call.enqueue(new Callback<LoginResult>() {

            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                if (response.code() == 200) {
                    LoginResult result = response.body();
                    Intent intent = new Intent(login_activity.this, dashBoard.class);
                    assert result != null;
                    intent.putExtra("username", result.getUsername());
                    intent.putExtra("email", result.getEmail());
                    intent.putExtra("userid", result.getUserid());
                    startActivity(intent);

                } else if (response.code() == 404) {
                    Toast.makeText(login_activity.this, "bad credentials", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(login_activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}