package com.wr.datpt.waterrecord.Presenter.TrangChu.XuLyMenu.TestCustomer;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.Model.TestCustomer.TestXuLyJsonCustomer;
import com.wr.datpt.waterrecord.Model.TrangChu.Xulymenu.XulyJSONMenu;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 17/04/2018.
 */

public class TestCustomer {
    public List<Customer> customerList(){
        List<Customer> list = new ArrayList<>();
        String dataJSON="";
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String duongdan = HomeView.SEVER_NAME;
        HashMap<String,String> hsParam = new HashMap<>();
        hsParam.put("ham","LayDanhSachKhachHang");
        attrs.add(hsParam);
        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        //end Post
        downloadJSON.execute();
        try {
            dataJSON = downloadJSON.get();
            TestXuLyJsonCustomer xulyJSON = new TestXuLyJsonCustomer();
            list = xulyJSON.customerList(dataJSON);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return list;
    }
}
