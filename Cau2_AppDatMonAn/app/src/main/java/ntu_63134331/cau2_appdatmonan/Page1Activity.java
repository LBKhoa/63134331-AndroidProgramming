package ntu_63134331.cau2_appdatmonan;
import android.content.Intent;
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
    int idAnhMinhHoa[]= {R.drawable.cc,R.drawable.banh_mi_xuc_xich,R.drawable.banh_xeo,R.drawable.bun_bo_hue,R.drawable.bun_cha,R.drawable.cct,R.drawable.cg,R.drawable.com_ga_hai_nam,R.drawable.ct,R.drawable.cts,R.drawable.ga_nuong,R.drawable.hu_tieu_nam_vang,R.drawable.pho_bo};
    String tenMonAn[]= {"Cơm Chiên","Bánh mì xúc xích","Bánh xèo","Bún bò Huế","Bún chả","Cơm chiên tôm","Cơm gà","Cơm gà hải nam","Cơm trộn","Cơm tấm sườn","Gà nướng","Hủ tiếu Nam Vang","Phở bò"};
    double donGia[]={20000,30000,25000,22000,27000,30000,24000,30000,28000,25000,31000,34000,30000};
    String moTa[]={"Cơm được chiên giòn","Bánh mì mềm được kết hợp với xúc xích thơm ngon","Bánh xèo giòn rụm với nhân thịt, tôm và rau sống","Một món bún truyền thống từ Huế"
            ," có thịt bò và nước dùng đậm đà","Bún tươi phối hợp với chả nướng và nước mắm chua ngọt","Cơm chiên có tôm và râu củ","Cơm có gà và râu",
            "Cơm gà nướng vàng ươm từ Hải Nam, kèm theo nước sốt đặc biệt", "Cơm có thịt và trứng","Cơm có sườn, chả, trứng"
            ,"Gà tươi được nướng thơm phức, với gia vị đặc biệt","Một món hủ tiếu phong phú từ Nam Vang, với hải sản và thịt lợn","Món phở truyền thống với thịt bò và nước dùng đậm đà"};
    ArrayList<MonAn> myList;
    ListView lvDSMonAn ;
    MonAnAdapter myAdapter;
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
        lvDSMonAn = findViewById(R.id.lvDSMonAn);
        myList = new ArrayList<>();
        for (int i = 0;i<tenMonAn.length;i++)
        {
            myList.add(new MonAn(tenMonAn[i], donGia[i], moTa[i], idAnhMinhHoa[i]));
        }
        myAdapter = new MonAnAdapter(Page1Activity.this,R.layout.item_monan,myList);
        lvDSMonAn.setAdapter(myAdapter);
        // bắt đầu xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent myintent = new Intent(Page1Activity.this, SubActivity.class);
                myintent.putExtra("tenMonAn",tenMonAn[i]);
                startActivity(myintent);
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