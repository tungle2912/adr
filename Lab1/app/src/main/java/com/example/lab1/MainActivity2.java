package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    protected EditText txtName;
    protected ListView list;

    protected FloatingActionButton btnAdd;
    private ListView listView;
    private ArrayAdapter<String> listViewAdapter;
    private ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName = findViewById(R.id.txtName);
        listView = findViewById(R.id.List);
        btnAdd= findViewById(R.id.btnAdd);
        dataList = new ArrayList<>();
        String defaultValue1 = "Lê Văn Tùng";
        String defaultValue2 = "Nguyễn Duy Khánh";
        String defaultValue3 = "Lê Quang VŨ";
        dataList.add(defaultValue1);
        dataList.add(defaultValue2);
        dataList.add(defaultValue3);
        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(listViewAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info=txtName.getText().toString();
                dataList.add(info);
                listViewAdapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dataList.remove(listView.getItemAtPosition(position));
                listViewAdapter.notifyDataSetChanged();
            }
        });
    }
}