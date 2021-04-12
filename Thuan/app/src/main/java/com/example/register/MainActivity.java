package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnXoa, btnSua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }


    private void setControl() {
        btnSua =findViewById(R.id.btnSua);
        btnXoa =findViewById(R.id.btnXoa);
    }
    private void setEvent() {
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
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
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnExit:
                finish();
                return true;
            case R.id.btnDelete:
                Intent intent1 = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(MainActivity.this, UpdateActivity.class);
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