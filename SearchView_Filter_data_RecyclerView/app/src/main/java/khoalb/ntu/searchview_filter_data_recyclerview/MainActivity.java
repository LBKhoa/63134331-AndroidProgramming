package khoalb.ntu.searchview_filter_data_recyclerview;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.widget.Toolbar;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvUsers;
    private UserAdapter userAdapter;
    private SearchView searchView;

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

        // Trong phương thức onCreate của MainActivity
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        rcvUsers = findViewById(R.id.rcv_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUsers.setLayoutManager(linearLayoutManager);

        userAdapter = new UserAdapter(getListUser());
        rcvUsers.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvUsers.addItemDecoration(itemDecoration);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.img_1,"Lê Bảo Khoa","Hà Nội"));
        list.add(new User(R.drawable.img_2,"Đoàn Hải Duy","Khánh Hòa"));
        list.add(new User(R.drawable.img_3,"Huỳnh Gia Kiệt","Hồ Chí Minh"));
        list.add(new User(R.drawable.img_4,"Lê Quốc Việt","Huế"));
        list.add(new User(R.drawable.img_5,"Trần Thanh Duy","Nghệ An"));
        list.add(new User(R.drawable.img_1, "Nguyễn Hoàng Anh", "Đà Nẵng"));
        list.add(new User(R.drawable.img_2, "Phạm Minh Tuấn", "Hải Phòng"));
        list.add(new User(R.drawable.img_3, "Lê Hoài Phương", "Bình Dương"));
        list.add(new User(R.drawable.img_4, "Trần Thị Ngọc Lan", "Cần Thơ"));
        list.add(new User(R.drawable.img_5, "Ngô Văn Huy", "Vũng Tàu"));
        list.add(new User(R.drawable.img_1, "Bùi Thị Minh Châu", "Quảng Nam"));
        list.add(new User(R.drawable.img_2, "Lê Quốc Đạt", "Nha Trang"));
        list.add(new User(R.drawable.img_3, "Nguyễn Xuân Bình", "Quảng Bình"));
        list.add(new User(R.drawable.img_4, "Trần Phú Quý", "Lâm Đồng"));
        list.add(new User(R.drawable.img_5, "Lý Thị Thanh Mai", "Gia Lai"));
        list.add(new User(R.drawable.img_1, "Nguyễn Thanh Sơn", "Quảng Ngãi"));
        list.add(new User(R.drawable.img_2, "Phan Thị Hồng Nhung", "Bến Tre"));
        list.add(new User(R.drawable.img_3, "Trần Hoàng Khang", "Tây Ninh"));
        list.add(new User(R.drawable.img_4, "Vũ Thành Long", "Hà Tĩnh"));
        list.add(new User(R.drawable.img_5, "Đặng Thị Kim Ngân", "Quảng Trị"));
        list.add(new User(R.drawable.img_1, "Hồ Văn Quang", "Cao Bằng"));
        list.add(new User(R.drawable.img_2, "Lê Hoàng Anh", "An Giang"));
        list.add(new User(R.drawable.img_3, "Trương Hữu Dũng", "Thừa Thiên Huế"));
        list.add(new User(R.drawable.img_4, "Phạm Thị Hồng Liên", "Hải Dương"));
        list.add(new User(R.drawable.img_5, "Nguyễn Văn Tài", "Nam Định"));



        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}