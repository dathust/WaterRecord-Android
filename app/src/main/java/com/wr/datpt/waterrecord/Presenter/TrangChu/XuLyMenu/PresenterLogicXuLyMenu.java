package com.wr.datpt.waterrecord.Presenter.TrangChu.XuLyMenu;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.Model.TrangChu.Xulymenu.XulyJSONMenu;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;
import com.wr.datpt.waterrecord.View.HomeView.ViewXuLyMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by DatPT on 11/02/2018.
 */

public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    ViewXuLyMenu viewXuLyMenu;
    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu) {
        this.viewXuLyMenu = viewXuLyMenu;
    }

    @Override
    public void LayDanhSachMenu() {

        List<Area> areaList;
        String dataJSON="";
        List<HashMap<String,String>> attrs = new ArrayList<>();
        //phương phức Get
//        String duongdan = HomeView.SEVER_NAME;
//        DownloadJSON downloadJSON = new DownloadJSON(duongdan);
        //end Get
        //phương thức Post
        String duongdan = HomeView.SEVER_NAME;
        HashMap<String,String> hsParam = new HashMap<>();
        hsParam.put("ham","LayDanhSackTram");
        attrs.add(hsParam);
        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        //end Post
        downloadJSON.execute();
        try {
            dataJSON = downloadJSON.get();
            XulyJSONMenu xulyJSONMenu = new XulyJSONMenu();
            areaList = xulyJSONMenu.ParseJSONMenu(dataJSON);
            viewXuLyMenu.HientThiDanhSachMenu(areaList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
