package khoalb.ntu.appmonan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.ListIterator;

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
        //tìm listview
        ListView lvDSMonAn = findViewById(R.id.lvDSMonAn);

        //chuẩn bị nguồn dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Cơm tấm sườn",20000,"Cơm có sườn, chả, trứng",R.drawable.cts));
        dsMonAn.add(new MonAn("Cơm gà",25000,"Cơm có gà và râu",R.drawable.cg));
        dsMonAn.add(new MonAn("Cơm chiên tôm",24000,"Cơm chiên có tôm và râu củ",R.drawable.cct));
        dsMonAn.add(new MonAn("Cơm trộn",22000,"Cơm có thịt và trứng",R.drawable.ct));
        dsMonAn.add(new MonAn("Cơm chiên",20000,"Cơm được chiên giòn",R.drawable.cc));

        MonAnAdapter adapter = new MonAnAdapter(this,dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        // bắt đầu xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //lấy phần tử được chọn
                MonAn monAnChon = dsMonAn.get(i);
                //làm gì đó
                Toast.makeText(MainActivity.this,monAnChon.getTenMonAn(),Toast.LENGTH_LONG).show();
            }
        });
    }
}