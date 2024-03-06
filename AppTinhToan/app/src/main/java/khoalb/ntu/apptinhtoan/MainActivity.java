package khoalb.ntu.apptinhtoan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // khai báo các đối tượng gắn với điều khiển tương ứng ở đây
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKetQua;
    Button nutCong,nutTru,nutNhan,nutChia;
    void TimDieuKhien(){
        editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        editTextSo2 = (EditText) findViewById(R.id.edtSo2);
        editTextKetQua = (EditText) findViewById(R.id.edtKetQua);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }
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
        TimDieuKhien();
    }

    // Xử lý cộng
    public void XuLyCong(View view){
        //Code xử lý cộng ở đây
        //b1 lấy dữ liệu 2 số

        //b1.1 lấy dữ liệu từ 2 điều khiển
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //Tinh Toan
        float Tong = soA + soB;
        //Xuất kết quả

        String chuoiKQ = String.valueOf(Tong);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKetQua.setText(chuoiKQ);
    }
    // Xử lý trừ
    public void XuLyTru(View view){
        //Code xử lý trừ ở đây
        //b1 lấy dữ liệu 2 số

        //b1.1 lấy dữ liệu từ 2 điều khiển
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //Tinh Toan
        float Hieu = soA - soB;
        //Xuất kết quả

        String chuoiKQ = String.valueOf(Hieu);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKetQua.setText(chuoiKQ);
    }
    // Xử lý Nhân
    public void XuLyNhan(View view){
        //Code xử lý nhân ở đây
        //b1 lấy dữ liệu 2 số

        //b1.1 lấy dữ liệu từ 2 điều khiển
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //Tinh Toan
        float Tich = soA * soB;
        //Xuất kết quả

        String chuoiKQ = String.valueOf(Tich);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKetQua.setText(chuoiKQ);
    }
    // Xử lý chia
    public void XuLyChia(View view){
        //Code xử lý chia ở đây
        //b1 lấy dữ liệu 2 số

        //b1.1 lấy dữ liệu từ 2 điều khiển
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //Tinh Toan
        float Thuong = soA / soB;
        //Xuất kết quả

        String chuoiKQ = String.valueOf(Thuong);
        //GÁN KẾT QUẢ LÊN ĐIỀU KHIỂN
        editTextKetQua.setText(chuoiKQ);
    }
}