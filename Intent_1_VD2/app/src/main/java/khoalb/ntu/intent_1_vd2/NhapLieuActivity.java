package khoalb.ntu.intent_1_vd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NhapLieuActivity extends AppCompatActivity {
    EditText edthoten, edtnamsinh;
    Button btnnl, btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nhap_lieu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edthoten = findViewById(R.id.edthoten);
        edtnamsinh = findViewById(R.id.edtnamsinh);
        btnnl = findViewById(R.id.btnnl);
        btnthoat = findViewById(R.id.btnthoat);

        btnnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hoten = edthoten.getText().toString();
                int namsinh = Integer.parseInt(edtnamsinh.getText().toString());

                Intent resultIntent = new Intent();
                resultIntent.putExtra("HT", hoten);
                resultIntent.putExtra("NS", namsinh);

                setResult(RESULT_OK, resultIntent);
                finish(); // Kết thúc hoạt động và trả kết quả về MainActivity
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}