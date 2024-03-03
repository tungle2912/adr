package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText txtHoTen, txtQuocTich;
    RadioGroup radioGroup;
    Spinner spinner;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoTen = findViewById(R.id.txtQuocTich);
        txtQuocTich = findViewById(R.id.txtQuocTich);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        btnSubmit = findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("Việt Nam");
        adapter.add("Hàn Quốc");
        adapter.add("Nhật Bản");
        adapter.add("Mỹ");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ các trường nhập
                String hoTen = txtHoTen.getText().toString();
                String gioiTinh = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                String quocTich = spinner.getSelectedItem().toString();



                // Tạo Intent để chuyển dữ liệu sang MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle myBundle=new Bundle();
                myBundle.putString("HoTen", hoTen);
                myBundle.putString("GioiTinh", gioiTinh);
                myBundle.putString("QuocTich", quocTich);
                intent.putExtra("mypackage",myBundle);
                startActivity(intent);
            }

        });
//        if (txtQuocTich != null && txtQuocTich.equals("Việt Nam")) {
//            txtStatus.setText("true");
//        } else {
//            txtStatus.setText("false");
//        }
    }
}