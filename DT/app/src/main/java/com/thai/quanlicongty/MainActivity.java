package com.thai.quanlicongty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText txttaiKhoan, txtmatKhau;
    Button btndangNhap, btndangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btndangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangkyTaikhoan.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        txttaiKhoan = findViewById(R.id.txtTK);
        txtmatKhau = findViewById(R.id.txtMK);
        btndangNhap = findViewById(R.id.btndangNhap);
        btndangKy = findViewById(R.id.btndangKy);
    }
}