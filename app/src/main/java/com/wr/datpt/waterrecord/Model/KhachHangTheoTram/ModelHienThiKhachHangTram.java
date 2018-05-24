package com.wr.datpt.waterrecord.Model.KhachHangTheoTram;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 18/04/2018.
 */

public class ModelHienThiKhachHangTram {
    public List<Customer> customerListArea(int maTram){

        List<Customer> customerList = new ArrayList<>();
        List<HashMap<String ,String >> attrs = new ArrayList<>();
        String dataJSON="";
        String duongdan = HomeView.SEVER_NAME;
        HashMap<String ,String > hsHam = new HashMap<>();
        hsHam.put("ham","LayKhachHangTheoTram");
        HashMap<String ,String > hsMaTram = new HashMap<>();
        hsMaTram.put("maTram",String.valueOf(maTram));
        attrs.add(hsHam);
        attrs.add(hsMaTram);
        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();
        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray listCustomerArea = jsonObject.getJSONArray("Customer");
            int count = listCustomerArea.length();
            for (int i =0; i<count; i++){
                JSONObject value = listCustomerArea.getJSONObject(i);
                Customer customer = new Customer();
                customer.setMaKhachHang(value.getInt("maKhachHang"));
                customer.setTenKhachHang(value.getString("tenKhachHang"));
                customer.setTenKhac(value.getString("tenKhac"));
                customer.setDiaChi(value.getString("diaChi"));
                customer.setDienThoai(value.getString("dienThoai"));
                customer.setMaSoThue(value.getString("maSoThue"));
                customer.setMaSoDongHo(value.getInt("maSoDongHo"));
                customer.setMaBangGia(value.getInt("maBangGia"));
                customer.setMaTram(value.getInt("maTram"));
                customer.setTongChiSo(value.getInt("tongChiSo"));
                customer.setToaDoX( value.getDouble("toaDoX1"));
                customer.setGetToaDoY(value.getDouble("toaDoY1"));
                customer.setTrangThai(value.getInt("trangThai"));
                customer.setGhiChu(value.getString("ghiChu"));
                customer.setChiSoThangNay(value.getInt("chiSoThangNay"));
                customer.setChiSoThangTruoc(value.getInt("chiSoThangTruoc"));
                customerList.add(customer);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
