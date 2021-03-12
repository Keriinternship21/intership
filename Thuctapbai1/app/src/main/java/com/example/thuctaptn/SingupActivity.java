package com.example.thuctaptn;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class SingupActivity extends AppCompatActivity {
    Button btnSignup;
    EditText edtten, edtdiachi, edtemail, edtma, edtsdt,edtpass;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        btnSignup = findViewById(R.id.btnRegister);
        edtdiachi = findViewById(R.id.txtBussAddress);
        edtemail = findViewById(R.id.txtEmail);
        edtma = findViewById(R.id.txtTax);
        edtten = findViewById(R.id.txtBussName);
        edtpass = findViewById(R.id.txtmatkhau);
        edtsdt = findViewById(R.id.txtPhone);
        setControl();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setControl() {

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtten.getText().toString();
                String password = edtpass.getText().toString();
                String email = edtemail.getText().toString();
                String address = edtdiachi.getText().toString();
                String phoneNumber = edtsdt.getText().toString();
                String MaTax = edtma.getText().toString();

                String permisstion = "user";

                if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(address)&&!TextUtils.isEmpty(MaTax)
                        && !TextUtils.isEmpty(phoneNumber)){
                    // run register function
                    register(username, password, email, address, phoneNumber,MaTax, permisstion);
                } else if(TextUtils.isEmpty(username)){
                    edtten.setError("Account is invalid!");
                } else if(TextUtils.isEmpty(password)) {
                    edtpass.setError("Password is invalid!");
                } else if(TextUtils.isEmpty(email)) {
                    edtemail.setError("Email is invalid!");
                } else if(TextUtils.isEmpty(address)) {
                    edtdiachi.setError("Address is invalid!");
                } else if(TextUtils.isEmpty(phoneNumber)) {
                    edtsdt.setError("Phone Number is invalid!");
                }else if(TextUtils.isEmpty(MaTax)) {
                    edtma.setError("Tax is invalid!");
                }

            }
        });
    }

    private void register(final String username, final String password, final String email, final String address, final String phoneNumber, final String MaTax,final String permisstion) {
        // create new user account
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // creating success
                if (task.isSuccessful()) {
                    // Get user id of account created
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();
                    // Save user info in Users table
                    databaseReference = FirebaseDatabase.getInstance().getReference("user").child(userId);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("userId", userId);
                    hashMap.put("username", username);
                    hashMap.put("email", email);
                    hashMap.put("address", address);
                    hashMap.put("MaTax",MaTax);
                    hashMap.put("phoneNumber", phoneNumber);
                    hashMap.put("permission", permisstion);

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SingupActivity.this, "Sign up success!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SingupActivity.this, "Sign up failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                } else {
                    Toast.makeText(SingupActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
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
            case R.id.btnhome:
                Intent intent = new Intent(SingupActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnexit:
                finish();
                return true;
            case R.id.btnDelete:
                Intent intent1 = new Intent(SingupActivity.this, DeleteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(SingupActivity.this, UpdateActivity.class);
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