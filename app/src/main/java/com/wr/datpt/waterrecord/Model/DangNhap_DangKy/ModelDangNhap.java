package com.wr.datpt.waterrecord.Model.DangNhap_DangKy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 15/04/2018.
 */

public class ModelDangNhap {

    public String LayCachedDangNhap(Context context){
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        String tennv = cachedDangNhap.getString("tennv","");
        Log.d("123",tennv);
        return tennv;
    }

    public String LayMaNhanVien(Context context){
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        String maNV = cachedDangNhap.getString("maNV","");
        return maNV;
    }

    public void CapNhatCachedDangNhap(Context context,String tenv, String maNV){
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = cachedDangNhap.edit();
        editor.putString("tennv",tenv);
        editor.putString("maNV", maNV);
        editor.commit();
    }
    public boolean KiemTraDangNhap(Context context, String taiKhoan, String matKhau){
        String duongdan = HomeView.SEVER_NAME;
        List<HashMap<String,String>> attrs = new ArrayList<>();
        boolean kiemtra = false;

        HashMap<String,String> hsHam= new HashMap<>();
        hsHam.put("ham","KiemTraDangNhap");

        HashMap<String ,String > hsTaiKhoan = new HashMap<>();
        hsTaiKhoan.put("taiKhoan",taiKhoan);

        HashMap<String ,String > hsMatKhau = new HashMap<>();
        hsMatKhau.put("matKhau",matKhau);

        attrs.add(hsHam);
        attrs.add(hsTaiKhoan);
        attrs.add(hsMatKhau);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();
        try {
            String dulieu = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieu);
            String jsonKetQua = jsonObject.getString("ketqua");
            if(jsonKetQua.equals("true")){
                kiemtra = true;
                String tennv = jsonObject.getString("tenNV");
                String maNV = jsonObject.getString("maNV");
                CapNhatCachedDangNhap(context,tennv, maNV);
            } else{
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
