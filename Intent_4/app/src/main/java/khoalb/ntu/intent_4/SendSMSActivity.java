package khoalb.ntu.intent_4;

import static khoalb.ntu.intent_4.R.*;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import khoalb.ntu.intent_4.R.id;

public class SendSMSActivity extends AppCompatActivity {
    EditText edtSms;
    ImageButton imgBtnSMS;
    Button btnback2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_smsactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtSms = findViewById(id.edtsms);
        imgBtnSMS = findViewById(R.id.imgBtnSMS);
        btnback2 = findViewById(id.btnback2);
        //xử lý click
        imgBtnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai báo ẩn danh gọi đển ứng dụng tin nhắn
                Intent smsintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtSms.getText().toString()));
                startActivity(smsintent);
            }
        });
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}