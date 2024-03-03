package com.example.testintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

        TextView txtHoTen, txtGioiTinh, txtQuocTich, txtStatus;
        Button btnBack;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            txtHoTen = findViewById(R.id.txtQuocTich);
            txtGioiTinh = findViewById(R.id.txtQuocTich);
            txtQuocTich = findViewById(R.id.txtQuocTich);

            btnBack = findViewById(R.id.btnBack);

            // Nhận dữ liệu từ MainActivity
            Intent intent = getIntent();
            String hoTen = intent.getStringExtra("HoTen");
            String gioiTinh = intent.getStringExtra("GioiTinh");
            String quocTich = intent.getStringExtra("QuocTich");

            // Hiển thị thông tin
            txtHoTen.setText("Họ tên: " + hoTen);
            txtGioiTinh.setText("Giới tính: " + gioiTinh);
            txtQuocTich.setText("Quốc tịch: " + quocTich);

            // Kiểm tra và cập nhật txtStatus
            if (quocTich != null && quocTich.equals("Việt Nam")) {
                txtStatus.setText("true");
            } else {
                txtStatus.setText("false");
            }

            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Trở về MainActivity
                    finish();
                }
            });
        }

}