package khoalb.ntu.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land,parent,false);
        ItemLandHolder holderCreated = new ItemLandHolder(vItem);
        return holderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // lấy dũ liệu
        LandScape landScapeHienThi = lstData.get(position);
        // trích sẵn thông tin
        String caption = landScapeHienThi.getLandCaption();
        String tenAnh = landScapeHienThi.getLandImageFileName();
        //đặt vào các trường thông tin cảu holder
        holder.tvCaption.setText(caption);
        //đặt ảnh
            String packageName = holder.itemView.getContext().getPackageName();
            int imageID = holder.itemView.getResources().getIdentifier(tenAnh, "mipmap",packageName);
        holder.ivLandScape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCaption);
            ivLandScape = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //code ở đây
            int viTriDuocClick = getAdapterPosition();
            LandScape phanTuDuocClick = lstData.get(viTriDuocClick);
            // bản thông báo
            String ten = phanTuDuocClick.getLandCaption();
            String tenFile = phanTuDuocClick.getLandImageFileName();
            //Toast tên
            String chuoiThongBao = "Bạn vừa click vào: "+ ten;
            Toast.makeText(v.getContext(),chuoiThongBao,Toast.LENGTH_SHORT).show();
        }
    }
}
