package com.example.thuctaptn;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnhome:
                Intent intent = new Intent(DeleteActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnexit:
                finish();
                return true;
            case R.id.btnDelete:
                Intent intent1 = new Intent(DeleteActivity.this, DeleteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(DeleteActivity.this, UpdateActivity.class);
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
