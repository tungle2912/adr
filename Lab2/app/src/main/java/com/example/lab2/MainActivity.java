package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewContacts;
    protected List<Contact> contacts;
    private ArrayAdapter<Contact> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContacts = findViewById(R.id.ListView);
        Button btnDelete = findViewById(R.id.btnXoa);
        Button btnAdd = findViewById(R.id.btnThemMoi);

        contacts = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, contacts);
        listViewContacts.setAdapter(adapter);
        listViewContacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteSelectedContacts();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                // Chuyển danh sách contacts sang AddContactActivity
                intent.putExtra("contacts", (Serializable) contacts);
                startActivity(intent);
            }
        });

    }

    private void deleteSelectedContacts() {
        int count = listViewContacts.getCount();
        for (int i = count - 1; i >= 0; i--) {
            if (listViewContacts.isItemChecked(i)) {
                // Confirm before delete
                // deleteContact(contacts.get(i));
                Toast.makeText(this, "Xóa contact " + contacts.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        }
        listViewContacts.clearChoices();
    }
}
