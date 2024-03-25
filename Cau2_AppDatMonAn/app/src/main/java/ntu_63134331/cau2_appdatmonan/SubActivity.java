package ntu_63134331.cau2_appdatmonan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {
    TextView txt_subMonAn;
    ImageView img_MA;
    TextView txt_subMoTa;
    TextView txt_DonGia;
    
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
    }
}