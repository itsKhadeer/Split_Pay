package com.example.splitpay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signup_activity extends AppCompatActivity {

    private static myRetrofit retrofit;
    EditText usernameInputBox;
    EditText passwordInputBox;
    EditText reEnterPasswordInput;
    EditText emailInputBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue, this.getTheme()));
        retrofit = new myRetrofit();
    }

    public void signInFunc(View view) {
        Intent intent = new Intent(this, login_activity.class);
        signup_activity.this.startActivity(intent);
        finish();
    }

    public void registerFunc(View view) {
        usernameInputBox = findViewById(R.id.userNameBox);
        passwordInputBox = findViewById(R.id.passwordBox);
        reEnterPasswordInput = findViewById(R.id.reEnterPasswordBox);
        emailInputBox = findViewById(R.id.emailBox);

        String email = emailInputBox.getText().toString().strip();
        String username = usernameInputBox.getText().toString().strip();
        String password = passwordInputBox.getText().toString().strip();
        String confirmPassword = reEnterPasswordInput.getText().toString();

        if(username.isBlank()) {
            Toast.makeText(this, "Enter your username!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.isBlank()) {
            Toast.makeText(this, "Enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!confirmPassword.equals(password)) {
            Toast.makeText(this, "The password you entered doesn't match with the original password", Toast.LENGTH_LONG).show();
            return;
        }
        if(email.isBlank()) {
            Toast.makeText(this, "Enter your email!", Toast.LENGTH_LONG).show();
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("username", username);
        map.put("password", password);

        Call<Void> call = retrofit.getRetrofitInterface().executeSignup(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200) {
                    Toast.makeText(signup_activity.this,
                            "Signed up successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(signup_activity.this, login_activity.class);
                    signup_activity.this.startActivity(intent);
                    finish();

                } else if (response.code() == 400) {
                    Toast.makeText( signup_activity.this,"Already registered" , Toast.LENGTH_LONG).show();
                } else if (response.code() == 404) {
                    Toast.makeText( signup_activity.this,"You fucked up son" , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(signup_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void selectImg(View view) {
    }
}