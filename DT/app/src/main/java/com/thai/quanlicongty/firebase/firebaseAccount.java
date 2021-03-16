package com.thai.quanlicongty.firebase;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.thai.quanlicongty.model.Taikhoan;

import java.util.ArrayList;

public class firebaseAccount {
    String tai_Khoan = "TAI_KHOAN";
    private Context context;
    DatabaseReference mdatabase;
    FirebaseStorage storage;
    StorageReference storageReference;
    ArrayList<Taikhoan> arrTaikhoan;
    ProgressDialog dialog;

    public firebaseAccount(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
        dialog.setMessage("Loading...");
        mdatabase = FirebaseDatabase.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        arrTaikhoan = new ArrayList<>();
    }

    public void showLoading(boolean show) {
        if (dialog != null) {
            if (show) {
                dialog.show();
            } else {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }
    }

    public interface IListener {
        void onSuccess();

        void onFail();
    }

    public void themTaikhoan(Taikhoan taikhoan, IListener iListener) {
        String id = mdatabase.child(tai_Khoan).push().getKey();
        taikhoan.setKey(id);
        mdatabase.child(tai_Khoan).child(taikhoan.getKey()).setValue(taikhoan).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                showLoading(false);
                iListener.onSuccess();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                iListener.onFail();
            }
        });
    }

}
