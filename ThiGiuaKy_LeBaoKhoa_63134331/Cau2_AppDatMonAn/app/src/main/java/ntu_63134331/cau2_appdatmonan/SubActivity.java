package ntu_63134331.cau2_appdatmonan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    TextView txt_subMonAn;
    ImageView img_MA;
    TextView txt_subMoTa;
    TextView txt_DonGia;
    Button btnDM, btnBack, btnOut;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt_subMonAn = findViewById(R.id.txt_subMonAn);
        img_MA = findViewById(R.id.img_MA);
        txt_subMoTa = findViewById(R.id.txt_subTTMonAn);
        txt_DonGia = findViewById(R.id.txt_DonGia);
        //nhận intent
        Intent myIntent = getIntent();
        String tenMonAn = myIntent.getStringExtra("tenMonAn");
        int idAnhMinhHoa = myIntent.getIntExtra("idAnhMinhHoa",0);
        String moTa = myIntent.getStringExtra("moTa");
        double donGia = myIntent.getDoubleExtra("donGia",0);

        String donGiaString = String.valueOf(donGia);//chuyển kiểu double của donGia sang hiển thị chuỗi

        txt_subMonAn.setText(tenMonAn);
        img_MA.setImageResource(idAnhMinhHoa);
        txt_subMoTa.setText(moTa);
        txt_DonGia.setText(donGiaString);

        //tìm nút btnDM
        btnDM = findViewById(R.id.btnDM);
        btnBack = findViewById(R.id.btnBack);
        btnOut = findViewById(R.id.btnOut);
        //Xử lý sự kiện khi ấn nút đặt món
        btnDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hiển thị hộp thoại thông báo khi ấn nút Đặt món
                String tenMonAn = txt_subMonAn.getText().toString(); // Lấy tên món ăn từ TextView
                String donGiaString = txt_DonGia.getText().toString(); // Lấy đơn giá từ TextView

                // Tạo thông báo
                String message = tenMonAn + " đã đặt thành công với đơn giá " + donGiaString + ". Món sẽ được giao trong 15 phút.";
                // Hiển thị thông báo bằng Toast
                Toast.makeText(SubActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
        //Xử lý sự kiện khi ấn nút Thót
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi người dùng nhấn nút Quay lại, gọi phương thức finish() để đóng SubActivity và quay lại Activity trước đó
                finish();
            }
        });
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo intent để chuyển về MainActivity
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent);
                // Đóng SubActivity
                finish();
            }
        });
    }
}