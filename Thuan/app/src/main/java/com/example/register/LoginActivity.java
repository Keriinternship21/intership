package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextView tvSignUpNow, tvResPassword;
    RadioButton radQLy, radNVien;
    EditText logUsername, logPassword;
    boolean vaild = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setControl();
        setEvent();
    }


    private void setControl() {
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUpNow = findViewById(R.id.tvSignUpNow);
        tvResPassword = findViewById(R.id.tvForgotPass);
        radNVien = findViewById(R.id.radNVien);
        radQLy = findViewById(R.id.radQLy);
        logPassword = findViewById(R.id.logPassword);
        logUsername = findViewById(R.id.logUsername);
    }

    public boolean checkField(EditText textField) {
        if (textField.getText().toString().isEmpty()) {
            textField.setError("error");
            vaild = false;
        } else {
            vaild = true;
        }
        return vaild;
    }

    private void setEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CheckField
                checkField(logPassword);
                checkField(logUsername);

                if (radQLy.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (radNVien.isChecked()) {
                    Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent1);
                }
            }
        });

        tvSignUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        tvResPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnHome:
                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnExit:
                finish();
                return true;
            case R.id.btnDelete:
                Intent intent1 = new Intent(LoginActivity.this, DeleteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(LoginActivity.this, UpdateActivity.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}