package com.wr.datpt.waterrecord.Model.DangNhap_DangKy;

import android.util.Log;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Staff;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 13/04/2018.
 */

public class ModelDangKy {
    public boolean DangKyThanhVien(Staff staff){
        boolean kiemtra = false;

        String duongdan = HomeView.SEVER_NAME;

        List<HashMap<String ,String >> attrs = new ArrayList<>();

        HashMap<String ,String > hsHam = new HashMap<>();
        hsHam.put("ham","DangKyThanhVien");

        HashMap<String ,String > hsTenNV = new HashMap<>();
        hsTenNV.put("tenNhanVien",staff.getTenNhanVien());
        HashMap<String ,String > hsSoDienThoai = new HashMap<>();
        hsSoDienThoai.put("soDienThoai",staff.getSoDienThoai());
        HashMap<String ,String > hsDiaChi = new HashMap<>();
        hsDiaChi.put("diaChi",staff.getDiaChi());
        HashMap<String ,String > hsTaiKhoan = new HashMap<>();
        hsTaiKhoan.put("taiKhoan",staff.getTaiKhoan());
        HashMap<String ,String > hsMatKhau = new HashMap<>();
        hsMatKhau.put("matKhau",staff.getMatKhau());

        attrs.add(hsHam);
        attrs.add(hsTenNV);
        attrs.add(hsSoDienThoai);
        attrs.add(hsDiaChi);
        attrs.add(hsTaiKhoan);
        attrs.add(hsMatKhau);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();
        try {

            String dulieuJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuJSON);
            String  ketqua= jsonObject.getString("ketqua");
            if (ketqua.equals("true")){
                kiemtra = true;
            }else{
                kiemtra = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return kiemtra;
    }
}
