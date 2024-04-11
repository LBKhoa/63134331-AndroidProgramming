package khoalb.ntu.viewpager2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> viewPagerDatas;
    ViewPager2 viewPager2Land;
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
        viewPagerDatas = getDataForViewPager();
        viewPager2Land = findViewById(R.id.vp2Land);
        landScapeAdapter = new LandScapeAdapter(this, viewPagerDatas);

        viewPager2Land.setAdapter(landScapeAdapter);
        viewPager2Land.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    ArrayList<LandScape> getDataForViewPager() {
        ArrayList<LandScape> dsDulieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("kim_tu_thap","Kim Tự Tháp Ai Cập");
        dsDulieu.add(landScape1);
        dsDulieu.add(new LandScape("va_ly_truong_thanh","Vạn Lý Trường Thành"));
        dsDulieu.add(new LandScape("vinh_ha_long","Vịnh Hạ Long"));
        dsDulieu.add(new LandScape("chua","Chùa Một Cột"));
        dsDulieu.add(new LandScape("cau_rong","Cầu Rồng Đà Nẵng"));
        dsDulieu.add(new LandScape("thap_tram_huong","Tháp Trầm Hương Nha Trang"));
        return dsDulieu;
    }
}