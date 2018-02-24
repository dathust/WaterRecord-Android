package com.wr.datpt.waterrecord.Model.TrangChu.Xulymenu;

import android.util.Log;

import com.wr.datpt.waterrecord.Model.ObjectClass.Area;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DatPT on 11/02/2018.
 */

public class XulyJSONMenu {

    public List<Area> ParseJSONMenu(String dulieujson) {
        List<Area> areaList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(dulieujson);
            JSONArray listArea = jsonObject.getJSONArray("Area");
            int count = listArea.length();
            for (int i =0; i<count; i++){
                JSONObject value = listArea.getJSONObject(i);

                Area area = new Area();

                area.setMaKhuVuc(value.getInt("maKhuVuc"));
                area.setNguoiTao(value.getString("nguoiTao").toString());

                area.setXoa(Byte.parseByte(value.getString("xoa")));
                area.setDoi(value.getString("doi"));
                area.setThon(value.getString("thon"));
                area.setXa(value.getString("xa"));
                area.setHuyen(value.getString("huyen"));
                area.setTinh(value.getString("tinh"));
                area.setChiTiet(value.getString("chiTiet"));
                area.setGhiChu(value.getString("ghiChu"));

                areaList.add(area);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Log.d("area",areaList.get(0).getTinh().toString());
        return areaList;
    }
}
