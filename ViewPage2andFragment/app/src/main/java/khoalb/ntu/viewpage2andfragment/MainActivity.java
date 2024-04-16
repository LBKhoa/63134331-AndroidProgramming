package khoalb.ntu.viewpage2andfragment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

import khoalb.ntu.viewpage2andfragment.fragment.MyViewPager2Adapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;

    // Map resource IDs to page indexes
    private final Map<Integer, Integer> navigationMap = new HashMap<>();

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

        // Initialize ViewPager2 and adapter
        mViewPager2 = findViewById(R.id.view_pager_2);
        MyViewPager2Adapter adapter = new MyViewPager2Adapter(this);
        mViewPager2.setAdapter(adapter);

        // Initialize BottomNavigationView
        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set up mapping of resource IDs to page indexes
        navigationMap.put(R.id.menu_home, 0);
        navigationMap.put(R.id.menu_favorite, 1);
        navigationMap.put(R.id.menu_my_page, 2);

        // Register OnPageChangeCallback
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Update the BottomNavigationView's selected item based on the page index
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        // Set up navigation item selected listener
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Integer pageIndex = navigationMap.get(item.getItemId());
            if (pageIndex != null) {
                mViewPager2.setCurrentItem(pageIndex);
                return true; // Return true to indicate the selection was handled
            }
            return false;
        });
    }
}
