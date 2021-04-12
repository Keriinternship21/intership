package com.example.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button btnResister, btnGotoLog;
    EditText registerBussName, registerUsername, registerPassword, registerBussAddress, registerTax, registerEmail, registerPhone;
    boolean vaild = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setControl();
        setEvent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setControl() {
        btnResister = findViewById(R.id.btnRegister);
        btnGotoLog = findViewById(R.id.btnGotologin);
        registerBussName = findViewById(R.id.registerBussName);
        registerUsername = findViewById(R.id.registerUserName);
        registerPassword = findViewById(R.id.registerPassword);
        registerBussAddress = findViewById(R.id.registerBussAddress);
        registerTax = findViewById(R.id.registerTax);
        registerEmail = findViewById(R.id.registerEmail);
        registerPhone = findViewById(R.id.registerPhone);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


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
        btnResister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CheckField
                checkField(registerBussName);
                checkField(registerUsername);
                checkField(registerPassword);
                checkField(registerBussAddress);
                checkField(registerEmail);
                checkField(registerPhone);
                checkField(registerTax);

                if (vaild) {
                    //
                    fAuth.createUserWithEmailAndPassword(registerEmail.getText().toString(), registerPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            DocumentReference df = fStore.collection("Users").document(user.getUid());
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("Username", registerUsername.getText().toString());
                            userInfo.put("Email", registerEmail.getText().toString());
                            userInfo.put("BussName", registerBussName.getText().toString());
                            userInfo.put("BussAddress", registerBussAddress.getText().toString());
                            userInfo.put("Phone", registerPhone.getText().toString());
                            userInfo.put("Tax", registerTax.getText().toString());
                            //
                            userInfo.put("isUser", "1");

                            df.set(userInfo);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivity.this, "Failed to Created Account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        btnGotoLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
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
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnExit:
                finish();
                return true;
            case R.id.btnDelete:
                Intent intent1 = new Intent(RegisterActivity.this, DeleteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.btnUpdate:
                Intent intent2 = new Intent(RegisterActivity.this, UpdateActivity.class);
                startActivity(intent2);
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}