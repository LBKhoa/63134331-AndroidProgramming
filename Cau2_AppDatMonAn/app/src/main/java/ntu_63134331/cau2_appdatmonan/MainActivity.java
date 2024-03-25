package ntu_63134331.cau2_appdatmonan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText editTextEmail;
    EditText editTextPassword;

    // Thay thế các giá trị này bằng các giá trị thực tế của bạn
    private static final String CORRECT_EMAIL = "lebaokhoa@gmail.com";
    private static final String CORRECT_PASSWORD = "khoa1234";
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
        // Ánh xạ các thành phần trong giao diện
        editTextEmail = findViewById(R.id.editTextText);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị nhập vào từ EditText
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (email.equals(CORRECT_EMAIL) && password.equals(CORRECT_PASSWORD)) {
                    // Nếu đúng, chuyển sang Activity khác
                    Intent intent = new Intent(MainActivity.this, Page1Activity.class);
                    startActivity(intent);
                } else {
                    // Nếu không đúng, hiển thị thông báo lỗi
                    Toast.makeText(MainActivity.this, "Email hoặc Password của bạn bị sai, mời nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //tìm listview



    }
}