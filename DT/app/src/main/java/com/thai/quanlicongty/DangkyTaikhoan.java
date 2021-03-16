package com.thai.quanlicongty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thai.quanlicongty.firebase.firebaseAccount;
import com.thai.quanlicongty.model.Taikhoan;

public class DangkyTaikhoan extends AppCompatActivity {
    EditText txtdkTaiKhoan, txtdkMatKhau, txtdkxnMatKhau;
    Button btntaoDangky;
    firebaseAccount firebaseAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky_taikhoan);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btntaoDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtdkxnMatKhau.getText().toString().equals(txtdkMatKhau.getText().toString())){
                    AlertDialog.Builder thongbao=new AlertDialog.Builder(DangkyTaikhoan.this);
                    thongbao.setMessage("Nhập sai mật khẩu!");
                    Dialog dialog=thongbao.create();
                    dialog.show();
                }else {
                    Taikhoan taikhoan=new Taikhoan();
                    taikhoan.setTaiKhoan(txtdkTaiKhoan.getText().toString());
                    taikhoan.setMatKhau(txtdkMatKhau.getText().toString());
                    firebaseAccount.themTaikhoan(taikhoan, new firebaseAccount.IListener() {
                        @Override
                        public void onSuccess() {
                            AlertDialog.Builder taothanhcong=new AlertDialog.Builder(DangkyTaikhoan.this);
                            taothanhcong.setMessage("Đăng ký tài khoản thành công!");
                            Dialog dialog2=taothanhcong.create();
                            dialog2.show();
                            Intent intent = new Intent(DangkyTaikhoan.this,MainActivity.class);
                        }

                        @Override
                        public void onFail() {

                        }
                    });
                }

            }
        });
    }

    private void setControl() {
        txtdkTaiKhoan = findViewById(R.id.txtdkTK);
        txtdkMatKhau = findViewById(R.id.txtdkMK);
        txtdkxnMatKhau = findViewById(R.id.txtdkxacnhanMK);
        btntaoDangky = findViewById(R.id.btndktaoTK);
    }
}