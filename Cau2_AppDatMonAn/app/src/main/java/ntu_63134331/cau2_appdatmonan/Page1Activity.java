package ntu_63134331.cau2_appdatmonan;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Page1Activity extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lvDSMonAn = findViewById(R.id.lvDSMonAn);
        //chuẩn bị nguồn dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Cơm tấm sườn",20000,"Cơm có sườn, chả, trứng",R.drawable.cts));
        dsMonAn.add(new MonAn("Cơm gà",25000,"Cơm có gà và râu",R.drawable.cg));
        dsMonAn.add(new MonAn("Cơm chiên tôm",24000,"Cơm chiên có tôm và râu củ",R.drawable.cct));
        dsMonAn.add(new MonAn("Cơm trộn",22000,"Cơm có thịt và trứng",R.drawable.ct));
        dsMonAn.add(new MonAn("Cơm chiên",20000,"Cơm được chiên giòn",R.drawable.cc));
        dsMonAn.add(new MonAn("Phở bò", 30000, "Món phở truyền thống với thịt bò và nước dùng đậm đà", R.drawable.pho_bo));
        dsMonAn.add(new MonAn("Gà nướng", 35000, "Gà tươi được nướng thơm phức, với gia vị đặc biệt", R.drawable.ga_nuong));
        dsMonAn.add(new MonAn("Bánh mì xúc xích", 25000, "Bánh mì mềm được kết hợp với xúc xích thơm ngon", R.drawable.banh_mi_xuc_xich));
        dsMonAn.add(new MonAn("Bún chả", 28000, "Bún tươi phối hợp với chả nướng và nước mắm chua ngọt", R.drawable.bun_cha));
        dsMonAn.add(new MonAn("Bún bò Huế", 35000, "Một món bún truyền thống từ Huế, có thịt bò và nước dùng đậm đà", R.drawable.bun_bo_hue));
        dsMonAn.add(new MonAn("Hủ tiếu Nam Vang", 30000, "Một món hủ tiếu phong phú từ Nam Vang, với hải sản và thịt lợn", R.drawable.hu_tieu_nam_vang));
        dsMonAn.add(new MonAn("Bánh xèo", 25000, "Bánh xèo giòn rụm với nhân thịt, tôm và rau sống", R.drawable.banh_xeo));
        dsMonAn.add(new MonAn("Cơm gà Hải Nam", 28000, "Cơm gà nướng vàng ươm từ Hải Nam, kèm theo nước sốt đặc biệt", R.drawable.com_ga_hai_nam));


        MonAnAdapter adapter = new MonAnAdapter(this,dsMonAn);
        lvDSMonAn.setAdapter(adapter);
        // bắt đầu xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //lấy phần tử được chọn
                MonAn monAnChon = dsMonAn.get(i);
                //làm gì đó
                Toast.makeText(Page1Activity.this,monAnChon.getTenMonAn(),Toast.LENGTH_LONG).show();
            }
        });
//        btnBack = findViewById(R.id.btnBack);
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //thoát childActivity
//                finish();
//            }
//        });
    }
}