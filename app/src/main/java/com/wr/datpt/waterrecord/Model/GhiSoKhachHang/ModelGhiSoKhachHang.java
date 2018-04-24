package com.wr.datpt.waterrecord.Model.GhiSoKhachHang;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Indication;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 22/04/2018.
 */

public class ModelGhiSoKhachHang {

    public boolean GhiSoKhachHang(Indication indication){
        boolean kiemtra = false;

        String duongdan = HomeView.SEVER_NAME;

        List<HashMap<String ,String >> attrs = new ArrayList<>();

        HashMap<String ,String > hsHam = new HashMap<>();
        hsHam.put("ham","ThemSoGhiDongHo");

        HashMap<String ,String > hsMaKH = new HashMap<>();
        hsMaKH.put("maKhachHang",String.valueOf(indication.getMaKhachHang()));
        HashMap<String ,String > hsMaNV = new HashMap<>();
        hsMaNV.put("maNhanVien",String.valueOf(indication.getMaNhanVien()));
        HashMap<String ,String > hsChiSo = new HashMap<>();
        hsChiSo.put("chiSo",String.valueOf(indication.getChiSo()));
        HashMap<String ,String > hsGhiChu = new HashMap<>();
        hsGhiChu.put("ghiChu",indication.getGhiChu());

        attrs.add(hsHam);
        attrs.add(hsMaKH);
        attrs.add(hsMaNV);
        attrs.add(hsChiSo);
        attrs.add(hsGhiChu);
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
