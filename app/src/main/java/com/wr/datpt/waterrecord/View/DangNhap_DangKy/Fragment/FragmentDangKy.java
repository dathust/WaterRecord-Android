package com.wr.datpt.waterrecord.View.DangNhap_DangKy.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wr.datpt.waterrecord.Model.ObjectClass.Staff;
import com.wr.datpt.waterrecord.Presenter.DangKy.PresenterLogicDangKy;
import com.wr.datpt.waterrecord.R;
import com.wr.datpt.waterrecord.View.DangNhap_DangKy.ViewDangKy;

import java.util.regex.Pattern;

/**
 * Created by DatPT on 11/04/2018.
 */

public class FragmentDangKy extends Fragment implements ViewDangKy,View.OnClickListener,View.OnFocusChangeListener{

    PresenterLogicDangKy presenterLogicDangKy;
    Button btnDangKy;
    EditText edHoTen,edSoDienThoai,edDiaChi,edTaiKhoan,edMatKhau,edNhapLaiMK;
    TextInputLayout input_HoTen, input_SDT,input_DiaChi, input_TaiKhoan, input_MatKhau, input_NhapLaiMK;
    boolean kiemTraTT = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_dangky,container,false);

        btnDangKy = view.findViewById(R.id.btnDangKy);
        edHoTen = view.findViewById(R.id.edHoTenDK);
        edSoDienThoai = view .findViewById(R.id.edSDTDK);
        edDiaChi = view.findViewById(R.id.edDiaChiDK);
        edTaiKhoan = view.findViewById(R.id.edTaiKhoanDK);
        edMatKhau = view.findViewById(R.id.edMatKhauDK);
        edNhapLaiMK = view.findViewById(R.id.edNhapLaiMatKhauDK);

        input_HoTen = view.findViewById(R.id.input_edHoTenDK);
        input_SDT = view.findViewById(R.id.input_SDTDK);
        input_DiaChi = view.findViewById(R.id.input_DiaChiDK);
        input_TaiKhoan = view.findViewById(R.id.input_edTaiKhoanDK);
        input_MatKhau = view.findViewById(R.id.input_MatKhauDK);
        input_NhapLaiMK = view.findViewById(R.id.input_NhapLaiMatKhauDK);

        btnDangKy.setOnClickListener(this);

        edHoTen.setOnFocusChangeListener(this);
        edSoDienThoai.setOnFocusChangeListener(this);
        edDiaChi.setOnFocusChangeListener(this);
        edTaiKhoan.setOnFocusChangeListener(this);
        edMatKhau.setOnFocusChangeListener(this);
        edNhapLaiMK.setOnFocusChangeListener(this);


        presenterLogicDangKy = new PresenterLogicDangKy(this);

        return view;
    }

    @Override
    public void DangKyThanhCong() {
        Toast.makeText(getActivity(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void DangKyThatBai() {
        Toast.makeText(getActivity(),"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
       btnDangKy();
    }

    private void btnDangKy(){
          String hoTen = edHoTen.getText().toString();
          String soDienThoai = edSoDienThoai.getText().toString();
          String diaChi = edDiaChi.getText().toString();
          String taiKhoan = edTaiKhoan.getText().toString();
          String matKhau = edMatKhau.getText().toString();
          String nhapLaiMK= edNhapLaiMK.getText().toString();

          if (kiemTraTT){
              Staff staff = new Staff();
              staff.setTenNhanVien(hoTen);
              staff.setSoDienThoai(soDienThoai);
              staff.setDiaChi(diaChi);
              staff.setTaiKhoan(taiKhoan);
              staff.setMatKhau(matKhau);
              presenterLogicDangKy.ThucHienDangKy(staff);
          }

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id = view.getId();
        switch (id){
            case R.id.edHoTenDK:
                if(!b){
                    String s = ((EditText)view).getText().toString();
                    if(s.trim().equals("")||s.equals(null)){
                        input_HoTen.setEnabled(true);
                        input_HoTen.setError("Cần nhập thông tin");
                        kiemTraTT = false;
                    }else {
                        input_HoTen.setErrorEnabled(false);
                        input_HoTen.setError("");
                        kiemTraTT = true;
                    }
                }
                break;
            case  R.id.edSDTDK:
                if(!b){
                    String s = ((EditText)view).getText().toString();

                    if(s.trim().equals("")||s.equals(null)){
                        input_SDT.setEnabled(true);
                        input_SDT.setError("Cần nhập thông tin");
                        kiemTraTT = false;
                    }else {
                        boolean kiemtraSDT = Patterns.PHONE.matcher(s).matches();
                        if (!kiemtraSDT) {
                            input_SDT.setEnabled(true);
                            input_SDT.setError("Số điện thoại không chính xác");
                            kiemTraTT = false;
                        } else {
                            if(s.length()>11 || s.length() <10){
                                input_SDT.setEnabled(true);
                                input_SDT.setError("Số điện thoại không chính xác");
                                kiemTraTT = false;
                            } else {
                                input_SDT.setErrorEnabled(false);
                                input_SDT.setError("");
                                kiemTraTT = true;
                            }
                        }
                    }
                }
                break;
            case R.id.edDiaChiDK:
                if(!b){
                    String s = ((EditText)view).getText().toString();
                    if(s.trim().equals("")||s.equals(null)){
                        input_DiaChi.setEnabled(true);
                        input_DiaChi.setError("Cần nhập thông tin");
                        kiemTraTT = false;
                    }else {
                        input_DiaChi.setErrorEnabled(false);
                        input_DiaChi.setError("");
                        kiemTraTT = true;
                    }
                }
                break;
            case R.id.edTaiKhoanDK:
                if(!b){
                    String s = ((EditText)view).getText().toString();
                    if(s.trim().equals("")||s.equals(null)){
                        input_TaiKhoan.setEnabled(true);
                        input_TaiKhoan.setError("Cần nhập thông tin");
                        kiemTraTT = false;
                    }else {
                        input_TaiKhoan.setErrorEnabled(false);
                        input_TaiKhoan.setError("");
                        kiemTraTT = true;
                    }
                }
                break;
            case R.id.edMatKhauDK:
                if(!b){
                    String s = ((EditText)view).getText().toString();
                    if(s.trim().equals("")||s.equals(null)){
                        input_TaiKhoan.setEnabled(true);
                        input_TaiKhoan.setError("Cần nhập thông tin");
                        kiemTraTT = false;
                    }else {
                        input_TaiKhoan.setErrorEnabled(false);
                        input_TaiKhoan.setError("");
                        kiemTraTT = true;
                    }
                }
                break;
            case R.id.edNhapLaiMatKhauDK:
                if (!b){
                    String s = ((EditText)view).getText().toString();
                    String matKhau = edMatKhau.getText().toString();
                    if(!s.equals(matKhau)){

                        input_NhapLaiMK.setEnabled(true);
                        input_NhapLaiMK.setError("Mật khẩu không trùng khớp");
                        kiemTraTT = false;
                    }else {
                        input_NhapLaiMK.setErrorEnabled(false);
                        input_NhapLaiMK.setError("");
                        kiemTraTT = true;
                    }
                }
                break;
        }
    }
}
