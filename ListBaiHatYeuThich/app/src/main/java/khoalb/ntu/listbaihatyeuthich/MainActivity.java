package khoalb.ntu.listbaihatyeuthich;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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
        //hiển thị dữ liệu trên listView
        //B1 nguồn dữ liệu (có thể tạo sẵn(hardcode)/lấy từ tệp/csdl)
        ArrayList<String> nguonDuLieu = new ArrayList<String>();
        nguonDuLieu.add("Chúng Ta Của Tương Lai");
        nguonDuLieu.add("Em Của Ngày Hôm Qua");
        nguonDuLieu.add("Ông Trời Làm Tội Anh Chưa");
        nguonDuLieu.add("Mưa Tháng 6");
        //B2 tìm tham chiếu đến listView
        ListView listBaiHat = findViewById(R.id.lvDSBaiHat);
        //B3 Tạo adapter và gắn với nguồn
        ArrayAdapter<String> BaiHatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nguonDuLieu);
        //B4 gắn và nạp dữ liệu từ nguồn vào view
        listBaiHat.setAdapter(BaiHatAdapter);

        //XỬ LÝ THÊM SỰ KIỆN
        listBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                // i là vị trí của Item được chọn/ chọn/ click trên listView
                //lấy giá trị của Item vừa chọn
                String value = BaiHatAdapter.getItem(i);
                //xử lý khác theo yêu cầu
                //ví dụ
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
            }
        });
    }
}