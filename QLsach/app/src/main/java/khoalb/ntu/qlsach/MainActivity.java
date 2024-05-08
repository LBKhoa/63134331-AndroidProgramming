package khoalb.ntu.qlsach;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

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
        //tạo CSDL
        SQLiteDatabase db = openOrCreateDatabase("QLSach", MODE_PRIVATE,
                null);
        //chạy thử và xem CSDL được tạo ra chưa
        String sqlXoaBangNeuDaCo="DROP TABLE IF EXISTS Books;";

        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
                                                "BookName text, " +
                                                "Page integer, " +
                                                "Price Float, " +
                                                "Description text);";
        // thực hiện lệnh sql
        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);
    }
}