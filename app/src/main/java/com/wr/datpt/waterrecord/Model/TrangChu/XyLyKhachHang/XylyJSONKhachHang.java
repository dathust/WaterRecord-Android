package com.wr.datpt.waterrecord.Model.TrangChu.XyLyKhachHang;

import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DatPT on 25/03/2018.
 */

public class XylyJSONKhachHang {
    public List<Customer> ParseJSONKhachHang(String dulieujson) {
        List<Customer> customerList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(dulieujson);
            JSONArray listCustomer = jsonObject.getJSONArray("Customer");
            int count = listCustomer.length();
            for (int i = 0; i < count; i++) {
                JSONObject value = listCustomer.getJSONObject(i);

                Customer customer = new Customer();

                customer.setMaKhachHang(value.getInt("maKhachHang"));
                customer.setTenKhachHang(value.getString("tenKhachHang"));
                customer.setTenKhac(value.getString("tenKhac"));
                customer.setDiaChi(value.getString("diaChi"));
                customer.setDienThoai(value.getInt("dienThoai"));
                customer.setMaSoThue(value.getString("maSoThue"));
                customer.setMaSoDongHo(value.getInt("maSoDongHo"));
                customer.setMaBangGia(value.getInt("maBangGia"));
                customer.setMaTram(value.getInt("maTram"));
                customer.setTongChiSo(value.getInt("tongChiSo"));
                customer.setToaDoX((float) value.getDouble("toaDoX"));
                customer.setGetToaDoY((float) value.getDouble("toaDoY"));
                customer.setGhiChu(value.getString("ghiChu"));
                customerList.add(customer);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Log.d("area",areaList.get(0).getTinh().toString());
        return customerList;
    }
}