package com.thai.congtykeri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CtyAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Congty> dta;

    public CtyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Congty> dta) {
        super(context, resource, dta);
        this.context = context;
        this.resource = resource;
        this.dta = dta;
    }

    @Override
    public int getCount() {
        return dta.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewcongty = convertView;
        if (viewcongty == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewcongty = inflater.inflate(R.layout.layout_dscty, null);
        }

        Congty congty= (Congty) getItem(position);

        if (congty!=null){
            TextView txtTen = viewcongty.findViewById(R.id.txtTen);
            TextView txtDiachi = viewcongty.findViewById(R.id.txtdiachi);
            TextView txtEmail = viewcongty.findViewById(R.id.txtemail);
            TextView txtPhone = viewcongty.findViewById(R.id.txtphne);

            txtTen.setText(congty.getTen());
            txtDiachi.setText(congty.getDiachi());
            txtEmail.setText(congty.getEmail());
            txtPhone.setText(congty.getPhone());
        }

        return viewcongty;
    }
}
