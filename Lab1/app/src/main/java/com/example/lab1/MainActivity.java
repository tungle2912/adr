package com.example.lab1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText txtName, txtSdt;
    private RadioButton rtbnNam, rbtnNu;
    private CheckBox cbGame, sbNhac, sbPhim;
    private Spinner spinner;
    private Button btnAdd;
    private ListView listView;
    private ArrayAdapter<String> listViewAdapter;
    private ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        txtName = findViewById(R.id.txtName);
        txtSdt = findViewById(R.id.txtSdt);
        rtbnNam = findViewById(R.id.rtbnNam);
        rbtnNu = findViewById(R.id.rbtnNu);
        cbGame = findViewById(R.id.cbGame);
        sbNhac = findViewById(R.id.sbNhac);
        sbPhim = findViewById(R.id.sbPhim);
        spinner = findViewById(R.id.spinner);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);
        // Khởi tạo danh sách dữ liệu cho ListView và thêm giá trị mặc định



        // Khởi tạo danh sách dữ liệu cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("Hà Nội");
        adapter.add("Hải Dương");
        adapter.add("Hưng Yên");
        adapter.add("Hải Phòng");
        adapter.add("Ninh Bình");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Khởi tạo danh sách dữ liệu cho ListView
        dataList = new ArrayList<>();
        String defaultValue1 = "Nguyen Van A"+"\n"+"0123456789"+"\n"+"Nam"+"\n"+"Chơi game"+"\n"+"Việt Nam";
        String defaultValue2 = "Tran Thi B"+"\n"+"0987654321"+"\n"+ "Nữ"+"\n"+"Nghe nhạc"+"\n"+ "Đài Loan";
        String defaultValue3 = "Le Van C"+"\n"+"0369847123"+"\n"+ "Nam"+"\n"+ "Xem phim"+"\n"+ "Hàn Quốc";
        dataList.add(defaultValue1);
        dataList.add(defaultValue2);
        dataList.add(defaultValue3);
        listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(listViewAdapter);

        // Xử lý sự kiện khi nút "ADD" được nhấn
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra xem các trường đã được nhập đủ chưa
                if (isValidInput()) {
                    // Tạo chuỗi thông tin từ các trường nhập
                    String info = txtName.getText().toString() + "\n" +
                            txtSdt.getText().toString() + "\n" +
                            (rtbnNam.isChecked() ? "Nam" : "Nữ") + "\n" +
                            "Sở thích: " +
                            (cbGame.isChecked() ? "Chơi game " : "") +
                            (sbNhac.isChecked() ? "Nghe nhạc " : "") +
                            (sbPhim.isChecked() ? "Xem phim " : "") + "\n" +
                            "Quốc gia: " + spinner.getSelectedItem().toString();

                    // Thêm thông tin vào danh sách và cập nhật ListView
                    dataList.add(info);
                    listViewAdapter.notifyDataSetChanged();

                    // Xóa nội dung các trường nhập
                    clearFields();
                } else {
                    // Hiển thị thông báo nếu các trường chưa được nhập đủ
                    showAlert("Vui lòng nhập đầy đủ thông tin!");
                }
            }
        });
    }

    // Hàm kiểm tra xem các trường đã được nhập đủ chưa
    private boolean isValidInput() {
        return !txtName.getText().toString().isEmpty() &&
                !txtSdt.getText().toString().isEmpty() &&
                (rtbnNam.isChecked() || rbtnNu.isChecked()) &&
                (cbGame.isChecked() || sbNhac.isChecked() || sbPhim.isChecked());
    }

    // Hàm xóa nội dung các trường nhập
    private void clearFields() {
        txtName.setText("");
        txtSdt.setText("");
        rtbnNam.setChecked(false);
        rbtnNu.setChecked(false);
        cbGame.setChecked(false);
        sbNhac.setChecked(false);
        sbPhim.setChecked(false);
        spinner.setSelection(0);
    }

    // Hàm hiển thị hội thoại thông báo
    private void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Thông báo")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Thực hiện hành động khi người dùng nhấn OK
                    }
                })
                .show();
    }
}
