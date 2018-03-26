package com.wr.datpt.waterrecord.Presenter.TrangChu.LayKhachHang;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.Model.TrangChu.Xulymenu.XulyJSONMenu;
import com.wr.datpt.waterrecord.Model.TrangChu.XyLyKhachHang.XylyJSONKhachHang;
import com.wr.datpt.waterrecord.View.HomeView.ViewXuLyMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 25/03/2018.
 */

public class LayKhachHangKhuVuc implements LayKhachHangKhuVucItf {

    ViewXuLyMenu viewXuLyMenu;
    public LayKhachHangKhuVuc(ViewXuLyMenu viewXuLyMenu) {
        this.viewXuLyMenu = viewXuLyMenu;
    }
    public LayKhachHangKhuVuc() {
    }
    @Override
    public void LayKhachHangKhuVuc() {
        List<Customer> customerList;
        String dataJSON="";
        //String stMaTram = String.valueOf(maTram);
        List<HashMap<String,String>> attrs = new ArrayList<>();
        //phương phức Get
//        String duongdan = "http://192.168.1.6:8084/WaterRecord/CustomerArea?maTram=1";
//        DownloadJSON downloadJSON = new DownloadJSON(duongdan);
        //end Get
        //phương thức Post
        String duongdan = "http://192.168.1.4:8084/WaterRecord/CustomerArea";
        HashMap<String,String> hsParam = new HashMap<>();
        hsParam.put("maTram","3");
        attrs.add(hsParam);
        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        //end Post
        downloadJSON.execute();
        try {
            dataJSON = downloadJSON.get();

            XylyJSONKhachHang xulyJSONKhachHang = new XylyJSONKhachHang();
            customerList = xulyJSONKhachHang.ParseJSONKhachHang(dataJSON);

            viewXuLyMenu.HienThiDanhSachKhachHangKhuVuc(customerList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LayKhachHangKhuVuc(int maTram) {
        List<Customer> customerList;
        String dataJSON="";
        String stMaTram = String.valueOf(maTram);
        List<HashMap<String,String>> attrs = new ArrayList<>();
        //phương phức Get
//        String duongdan = "http://192.168.1.6:8084/WaterRecord/CustomerArea?maTram=1";
//        DownloadJSON downloadJSON = new DownloadJSON(duongdan);
        //end Get
        //phương thức Post
        String duongdan = "http://192.168.43.119:8084/WaterRecord/CustomerArea";
        HashMap<String,String> hsParam = new HashMap<>();
        hsParam.put("maTram",stMaTram);
        attrs.add(hsParam);
        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        //end Post
        downloadJSON.execute();
        try {
            dataJSON = downloadJSON.get();

            XylyJSONKhachHang xulyJSONKhachHang = new XylyJSONKhachHang();
            customerList = xulyJSONKhachHang.ParseJSONKhachHang(dataJSON);

            //viewXuLyMenu.HienThiDanhSachKhachHangKhuVuc(customerList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
