package khoalb.ntu.intent_1_vd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvHoten, tvNamSinh;
    Button btnnhap;

    Intent myintent;

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

        tvHoten = findViewById(R.id.tvHoTen);
        tvNamSinh = findViewById(R.id.tvNamSinh);
        btnnhap = findViewById(R.id.btnnhap);

        myintent = getIntent();

        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, NhapLieuActivity.class);

                startActivityForResult(myIntent,8000);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 8000){
            if (resultCode == RESULT_OK){
                String hotennhanduoc = data.getStringExtra("HT");
                int namsinhnhanduoc = data.getIntExtra("NS", 2020);

                tvHoten.setText(hotennhanduoc);
                tvNamSinh.setText(String.valueOf(namsinhnhanduoc));
            } else {
                Toast.makeText(this, "Trả về không thành công", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}