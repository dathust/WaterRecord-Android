package com.wr.datpt.waterrecord.View.DangNhap_DangKy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wr.datpt.waterrecord.Model.DangNhap_DangKy.ModelDangNhap;
import com.wr.datpt.waterrecord.R;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

/**
 * Created by DatPT on 11/04/2018.
 */

public class FragmentDangNhap extends Fragment implements View.OnClickListener{
    Button btnDangNhap;
    ModelDangNhap modelDangNhap;
    EditText edTaiKhoan, edMatKhau;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_dangnhap,container,false);

        modelDangNhap = new ModelDangNhap();
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(this);
        edTaiKhoan = view.findViewById(R.id.edTaiKhoanDN);
        edMatKhau = view.findViewById(R.id.edMatKhauDN);
        return view;
    }

    @Override
    public void onClick(View view) {
        String taiKhoan = edTaiKhoan.getText().toString();
        String matKhau = edMatKhau.getText().toString();
        modelDangNhap = new ModelDangNhap();
        boolean kiemtra = modelDangNhap.KiemTraDangNhap(getActivity(),taiKhoan,matKhau);
        if(kiemtra){
            Intent iTrangChu = new Intent(getActivity(), HomeView.class);
            startActivity(iTrangChu);
        }else{
            Toast.makeText(getActivity(),"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
        }

    }
}
