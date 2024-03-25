package ntu_63134331.cau2_appdatmonan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {

    //dữ liệu
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MonAnAdapter( Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewHienHanh = view;
        if (viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan, null);
        //lấy dữ liệu món an
        MonAn monAnHienHanh = dsMonAn.get(i);
        //gắn thiết bị lên điều khiển

        //tim điều khiển
        TextView textView_TenMon = viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia = viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView_Anh = viewHienHanh.findViewById(R.id.imAnhDaiDien);
        //set lên
        textView_TenMon.setText(monAnHienHanh.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienHanh.getDonGia()));
        textView_MoTa.setText(monAnHienHanh.getMoTa());
        imageView_Anh.setImageResource(monAnHienHanh.getIdAnhMinhHoa());
        return viewHienHanh;
    }
}

