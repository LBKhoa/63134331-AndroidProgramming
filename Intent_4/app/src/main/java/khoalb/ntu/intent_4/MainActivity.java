package khoalb.ntu.intent_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btncall, btnsms;
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
        btncall = findViewById(R.id.btncall);
        btnsms = findViewById(R.id.btnsms);
        //xử lý click
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent công khai
                Intent myintent = new Intent(MainActivity.this,CallPhoneActivity.class);
                startActivity(myintent);
            }
        });
        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo intent công khai
                Intent myintent2 = new Intent(MainActivity.this,SendSMSActivity.class);
                startActivity(myintent2);
            }
        });
    }
}