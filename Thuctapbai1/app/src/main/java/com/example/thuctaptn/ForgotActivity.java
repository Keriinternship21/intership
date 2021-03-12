package com.example.thuctaptn;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ForgotActivity extends AppCompatActivity {
    TextView tvBackLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forrotpass);
        tvBackLogin = findViewById(R.id.tvBack);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setEvent();
    }

    private void setEvent() {
        tvBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnhome:
                Intent intent = new Intent(ForgotActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnexit:
                finish();
                return true;
            case R.id.btnDelete:
                Intent intent1 = new Intent(ForgotActivity.this, DeleteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(ForgotActivity.this, UpdateActivity.class);
                startActivity(intent2);
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:break;

        }
        return super.onOptionsItemSelected(item);

    }
}
