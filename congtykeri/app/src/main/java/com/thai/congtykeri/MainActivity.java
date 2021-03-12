package com.thai.congtykeri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtdL;
    ListView lvdsCty;
    Spinner spnlocDL;
    ArrayAdapter adapter;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<Congty> dataCty = new ArrayList<>();

    CtyAdapter ctyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

        ActionBar actionBar = getSupportActionBar();
        TypedArray styledAttributes =
                getTheme().obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        int actionBarSize = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        Drawable drawable= getResources().getDrawable(R.drawable.keri);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Drawable newdrawable = new BitmapDrawable(getResources(),
                Bitmap.createScaledBitmap(bitmap, actionBarSize,  actionBarSize, true));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.keri);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setTitle("Công Ty KERI");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_danhsach,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setEvent() {
        dta();
        ctyAdapter=new CtyAdapter(getApplication(),R.layout.layout_dscty,dataCty);
        lvdsCty.setAdapter(ctyAdapter);

        adapter = new ArrayAdapter(MainActivity.this, R.layout.spnlocdulieu,R.id.txtdL, data);
        spnlocDL.setAdapter(adapter);


        lvdsCty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String[] item={"Thêm", "Xóa", "Sửa"} ;
                AlertDialog.Builder chucnang= new AlertDialog.Builder(MainActivity.this);
                chucnang.setTitle(" Chức năng");
                chucnang.setItems(item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (item[i]){
                            case "Thêm":
                                Log.d("Thêm thanh công","Đã thêm thành công");
                                break;
                            case "Xóa":
                                AlertDialog.Builder cnXoa=new AlertDialog.Builder(MainActivity.this);
                                cnXoa.setTitle(" Cảnh báo");
                                cnXoa.setMessage(" Bạn có muốn xóa? ");
                                cnXoa.setPositiveButton(" YES ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                });
                                cnXoa.setNegativeButton(" NO ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                                AlertDialog dlXoa= cnXoa.create();
                                dlXoa.show();
                                break;
                            default:
                                Log.d("Sửa","Di chuyển tới trang sửa");
                                break;
                        }
                    }
                });
                AlertDialog dlChucnang=chucnang.create();
                dlChucnang.show();
            }
        });
    }

    private void dta() {
        Congty congty=new Congty();
        congty.setTen("Trách nhiệm hữu hạn A");
        congty.setDiachi("Thủ Đức, TPHCM");
        congty.setEmail("abc@gmail.com");
        congty.setPhone("09xxxx");
        dataCty.add(congty);

        Congty congty1=new Congty();
        congty1.setTen("Trách nhiệm hữu hạn B");
        congty1.setDiachi("Thủ Đức, TPHCM");
        congty1.setEmail("xyz@gmail.com");
        congty1.setPhone("08xxxx");
        dataCty.add(congty1);

        data.add(" Mới Nhất ");
        data.add(" Cũ Nhất ");
    }

    private void setControl() {
        txtdL=findViewById(R.id.txtdL);
        lvdsCty=findViewById(R.id.lvdanhSach);
        spnlocDL = findViewById(R.id.splocCty);
    }
}