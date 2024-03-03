package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtHoTen, txtGioiTinh, txtQuocTich;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtHoTen = findViewById(R.id.txtName);
        txtGioiTinh = findViewById(R.id.txtGioiTinh);
        txtQuocTich = findViewById(R.id.txtQuocTich);

        btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ MainActivity
        Intent intent = getIntent();
        Bundle myBundle=intent.getBundleExtra("mypackage");
        String hoTen = myBundle.getString("HoTen");
        String gioiTinh = myBundle.getString("GioiTinh");
        String quocTich = myBundle.getString("QuocTich");

        // Hiển thị thông tin
        txtHoTen.setText( hoTen);
        txtGioiTinh.setText(gioiTinh);
        txtQuocTich.setText(quocTich);

        // Kiểm tra và cập nhật txtStatus

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Trở về MainActivity
                finish();
            }
        });
    }

}