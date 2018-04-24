package com.wr.datpt.waterrecord.View.GhiSoKhachHang;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.wr.datpt.waterrecord.Model.DangNhap_DangKy.ModelDangNhap;
import com.wr.datpt.waterrecord.Model.ObjectClass.Indication;
import com.wr.datpt.waterrecord.Presenter.GhiSoKhachHang.PresenterLogicGhiSoKhachHang;
import com.wr.datpt.waterrecord.R;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;
import com.wr.datpt.waterrecord.View.KhachHangTheoTram.HienThiKhachHangTheoTramActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by DatPT on 19/04/2018.
 */

public class GhiSoKhachHangActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener, ViewGhiSoKhachHang {

    TextView txtName, txtPhone, txtAddress, txtNgayGhiSo, txtTongChiSo, txtToaDoX, txtToaDoY, txtChiSoThangTruoc;
    EditText edChiSo, edghichu;
    TextInputLayout inputChiSo;
    Button btnNhanDienAnh, btnCapNhatViTri, btnXacNhan, btnLayViTri;
    boolean kiemTraTT = false;
    ModelDangNhap modelDangNhap;
    PresenterLogicGhiSoKhachHang presenterLogicGhiSoKhachHang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ghiso_khachhang);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.txtAddress);
        txtNgayGhiSo = findViewById(R.id.txtNgayghi);
        txtTongChiSo = findViewById(R.id.txtTongso);
        txtToaDoX = findViewById(R.id.txtToadoX);
        txtToaDoY = findViewById(R.id.txtToadoY);
        txtChiSoThangTruoc = findViewById(R.id.txtChiSoTruoc);
        edChiSo = findViewById(R.id.edchisodongho);
        edghichu = findViewById(R.id.edghihchu);
        inputChiSo = findViewById(R.id.input_edChiSo);
        btnNhanDienAnh = findViewById(R.id.btnNhandienanh);
        btnCapNhatViTri = findViewById(R.id.btnVitri);
        btnXacNhan = findViewById(R.id.btnXacnhan);
        btnLayViTri = findViewById(R.id.btnLayVitri);


        Intent intent = getIntent();
        int maKhachHang = intent.getIntExtra("maKhachHang", 0);
        String tenKhachHang = intent.getStringExtra("tenKhachHang");
        String soDienThoai = intent.getStringExtra("soDienThoai");
        String diaChi = intent.getStringExtra("diaChi");
        int tongChiSo = intent.getIntExtra("tongChiSo", 0);
        float toaDoX = intent.getFloatExtra("toaDoX", 0);
        float toaDoY = intent.getFloatExtra("toaDoY", 0);
        int chiSoThangNay = intent.getIntExtra("chiSoThangNay",0);
        int chiSoThangTruoc = intent.getIntExtra("chiSoThangTruoc",0);

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");

        txtName.setText(tenKhachHang);
        txtPhone.setText(soDienThoai);
        txtAddress.setText(diaChi);
        txtNgayGhiSo.setText(timeFormat.format(date));
        txtTongChiSo.setText(String.valueOf(tongChiSo));
        txtChiSoThangTruoc.setText(String.valueOf(chiSoThangTruoc));
        edChiSo.setText(String.valueOf(chiSoThangNay));
        txtToaDoX.setText(String.valueOf(toaDoX));
        txtToaDoY.setText(String.valueOf(toaDoY));

        presenterLogicGhiSoKhachHang = new PresenterLogicGhiSoKhachHang(this);

        edChiSo.setOnFocusChangeListener(this);
        btnXacNhan.setOnClickListener(this);
        btnLayViTri.setOnClickListener(this);
        btnCapNhatViTri.setOnClickListener(this);
        btnNhanDienAnh.setOnClickListener(this);


    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id = view.getId();
        switch (id) {
            case R.id.edchisodongho:
                if (!b) {
                    String s = ((EditText) view).getText().toString();
                    if (s.trim().equals("") || s.equals(null)) {
                        inputChiSo.setEnabled(true);
                        inputChiSo.setError("Cần nhập thông tin");
                        kiemTraTT = false;
//                    } else {
//                        int chiSo = Integer.parseInt(s);
//                        int chiSoTruoc = Integer.parseInt(txtChiSoThangTruoc.getText().toString());
//                        if (chiSo < chiSoTruoc){
//                            inputChiSo.setEnabled(true);
//                            inputChiSo.setError("Số nhập không hợp lệ");
//                            kiemTraTT = false;
                    } else {
                        inputChiSo.setErrorEnabled(false);
                        inputChiSo.setError("");
                        kiemTraTT = true;
                    }
                }

                break;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnXacnhan:
                Intent intent = getIntent();
                int trangThai = intent.getIntExtra("trangThai", 0);
                int maTram = intent.getIntExtra("maTram", 0);
                if (trangThai == 0) {
                    Indication indication = new Indication();
                    modelDangNhap = new ModelDangNhap();
                    int maKhachHang = intent.getIntExtra("maKhachHang", 0);
                    String maNV = modelDangNhap.LayMaNhanVien(this);
                    String chiSo = edChiSo.getText().toString();
                    String ghiChu = edghichu.getText().toString();

                    indication.setMaKhachHang(maKhachHang);
                    indication.setMaNhanVien(Integer.parseInt(maNV));
                    indication.setChiSo(Integer.parseInt(chiSo));
                    indication.setGhiChu(ghiChu);
                    indication.setNgayGhiSo(null);
                    presenterLogicGhiSoKhachHang.ThucHienGhiSo(indication);
                    Intent iTrangChu = new Intent(this, HienThiKhachHangTheoTramActivity.class);
                    iTrangChu.putExtra("maTram", maTram);
                    startActivity(iTrangChu);
                } else if (trangThai == 2) {
                    AlertDialog.Builder b = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
                    b.setMessage("Chỉ số đồng hồ đã được in hóa đơn \n Bạn không thể thay đổi lúc này!");
                    b.setPositiveButton("Chấp nhận", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    b.create().show();
                }


                break;
            case R.id.btnLayVitri:
                Toast.makeText(this, "Lấy vị trí", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnVitri:
                Toast.makeText(this, "Vị trí", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNhandienanh:
                Intent intentCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCam, 0);
                break;
        }
    }


    @Override
    public void GhiSoThanhCong() {
        Toast.makeText(this, "Ghi số thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void GhiSoThatBai() {
        Toast.makeText(this, "Ghi số thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final Bitmap bitmap = (Bitmap) data.getExtras().get("data");

        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
        if (!textRecognizer.isOperational()) {
            Log.d("Error", "Noooooooooo");
        } else {

            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<TextBlock> items = textRecognizer.detect(frame);
            StringBuilder stringBuilder = new StringBuilder();
            String s = new String();
            String digit = "0123456789";
            String result = new String();
            for (int i = 0; i < items.size(); i++) {
                TextBlock item = items.valueAt(i);
                s = s + item.getValue();
                stringBuilder.append(item.getValue());
                stringBuilder.append("\n");
            }
            for (int j = 0; j < s.length(); j++) {
                if (digit.contains("" + s.charAt(j))) {
                    result = result + s.charAt(j);
                }
            }
            edChiSo.setText(result);
        }
    }
}
