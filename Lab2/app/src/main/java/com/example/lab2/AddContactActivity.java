package com.example.lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddContactActivity extends AppCompatActivity {

    private EditText editTextName, editTextPhoneNumber;
    private CheckBox checkBoxStatus;
    protected List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        contacts = (List<Contact>) getIntent().getSerializableExtra("contacts");
        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        checkBoxStatus = findViewById(R.id.checkBoxStatus);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(view -> saveContact());
    }

    private void saveContact() {
        String name = editTextName.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        boolean status = checkBoxStatus.isChecked();

        // Validate input
        if (name.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(this, "Tên và số điện thoại không được để trống", Toast.LENGTH_SHORT).show();
            return;
        }

        // Nhận danh sách contacts từ Intent
        contacts = (List<Contact>) getIntent().getSerializableExtra("contacts");

        // Generate a unique id for the new contact
        int newId = contacts.size() + 1;

        // Add new contact to the list
        Contact newContact = new Contact(newId, name, phoneNumber, status);
        contacts.add(newContact);

        Toast.makeText(this, "Đã thêm mới contact", Toast.LENGTH_SHORT).show();

        // Không kết thúc Activity
         finish();
    }



}
