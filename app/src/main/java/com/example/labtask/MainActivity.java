package com.example.labtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword, etAge;
    Button btnLogin;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onClickBtnLogin(View view){
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();
        String age = etAge.getText().toString();

        if(checkValidity(email,password,age))
        {

            if(email.equals("test@umt.edu.pk") && password.equals("umt1234") && Integer.parseInt(age)<25){
                imageView.setImageResource(R.drawable.yes);
            }else{
                imageView.setImageResource(R.drawable.no);
            }
        }
    }

    // Check either text fields are empty or not
    private boolean checkValidity(String email, String password, String age) {
        boolean flag = true;

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            flag = false;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            flag = false;
        }

        if (age.isEmpty()) {
            etAge.setError("Age is required");
            flag = false;
        }

        return flag;
    }

    private void init(){
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAge = findViewById(R.id.etAge);
        btnLogin = findViewById(R.id.btnLogin);
        imageView = findViewById(R.id.imageView);
    }
}