package khoalb.ntu.giaodienapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen,edtCCCD,edtBoSung;
    Button btngui;
    RadioGroup idgroup;
    CheckBox chkDocBao,chkDocSach,chkCoding;
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
        //ánh xạ id
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        edtBoSung = findViewById(R.id.edtBoSung);
        btngui = findViewById(R.id.btngui);
        idgroup = findViewById(R.id.idgroup);
        chkCoding = findViewById(R.id.chkCoding);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        //xử lý click vào button
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoTen.getText().toString();
                if(hoten.length() < 3 ){
                    Toast.makeText(MainActivity.this,"Họ tên phải >= 3 ký tự",Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus();
                    edtHoTen.selectAll();
                }
                //lấy thông tin
                String CCCD = edtCCCD.getText().toString();
                if(CCCD.length()!=12){
                    Toast.makeText(MainActivity.this,"CCCD phải đúng 12 số ",Toast.LENGTH_LONG).show();
                    edtCCCD.requestFocus();
                    edtCCCD.selectAll();
                    return;
                }
                //lấy thông tin bằng cấp
                int idselect = idgroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String bangcap = radselect.getText().toString();
                //lấy thông tin sở thích
                String sothich = "";
                if(chkDocSach.isChecked()){
                    sothich += chkDocSach.getText().toString()+"-";
                }
                if(chkDocBao.isChecked()){
                    sothich += chkDocBao.getText().toString()+"-";
                }
                if(chkCoding.isChecked()){
                    sothich += chkCoding.getText().toString()+"-";
                }
                //lấy thông tin bổ sung
                String bosung = edtBoSung.getText().toString();
                String tonghop = hoten+"\n"+CCCD+"\n"+bangcap+"\n"+sothich+"\n";
                        tonghop += "----------------Thông Tin Bổ Sung--------------";
                        tonghop += bosung+"\n";
                        tonghop +="------------------------------------------------";
                //tạo Dialog và hiển thị thông tin tông hợp
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("THÔNG TIN CÁ NHÂN");
                mydialog.setMessage(tonghop);
                mydialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.create().show();
            }
        });
    }
}