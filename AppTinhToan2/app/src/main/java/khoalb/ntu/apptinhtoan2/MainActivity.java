package khoalb.ntu.apptinhtoan2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TimView();
        //gắn các bộ lắng nghe
        btnCong.setOnClickListener(boLangNgheCong);
        btnTru.setOnClickListener(boLangNgheTru);
        btnNhan.setOnClickListener(boLangNgheNhan);
       // btnChia.setOnClickListener(boLangNgheChia);
        //ẩn danh
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code xử lý cộng ổ đây
                // lấy 1 và 2
                String strSo1 = edtSoA.getText().toString();
                String strSo2 = edtSoB.getText().toString();
                // CHUYỂN THÀNH SỐ ĐỂ TÍNH TOÁN
                double soA = Double.parseDouble(strSo1);
                double soB = Double.parseDouble(strSo2);
                //tÍNH TOÁN
                double Thuong = soA / soB;
                String strKQ = String.valueOf(Thuong);
                tvKetQua.setText(strKQ);
            }
        });
    }
    // Tạo bộ lắng nghe và xử lý sự kiện
    View.OnClickListener boLangNgheCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //code xử lý cộng ổ đây
            // lấy 1 và 2
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            // CHUYỂN THÀNH SỐ ĐỂ TÍNH TOÁN
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //tÍNH TOÁN
            double Tong = soA + soB;
            String strKQ = String.valueOf(Tong);
            tvKetQua.setText(strKQ);
        }
    };
    View.OnClickListener boLangNgheTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //code xử lý cộng ổ đây
            // lấy 1 và 2
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            // CHUYỂN THÀNH SỐ ĐỂ TÍNH TOÁN
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //tÍNH TOÁN
            double Hieu = soA - soB;
            String strKQ = String.valueOf(Hieu);
            tvKetQua.setText(strKQ);
        }
    };
    View.OnClickListener boLangNgheNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //code xử lý cộng ổ đây
            // lấy 1 và 2
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            // CHUYỂN THÀNH SỐ ĐỂ TÍNH TOÁN
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //tÍNH TOÁN
            double Tich = soA * soB;
            String strKQ = String.valueOf(Tich);
            tvKetQua.setText(strKQ);
        }
    };
    View.OnClickListener boLangNgheChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //code xử lý cộng ổ đây
            // lấy 1 và 2
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            // CHUYỂN THÀNH SỐ ĐỂ TÍNH TOÁN
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //tÍNH TOÁN
            double Thuong = soA / soB;
            String strKQ = String.valueOf(Thuong);
            tvKetQua.setText(strKQ);
        }
    };
    void TimView (){
        edtSoA = findViewById(R.id.edtA);
        edtSoB = findViewById(R.id.edtB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvKetQua = findViewById(R.id.edtKQ);
    }
    // Khai báo các đối tượng ứng với các điều khiển cần thao tác
    EditText edtSoA;
    EditText edtSoB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView tvKetQua;
}