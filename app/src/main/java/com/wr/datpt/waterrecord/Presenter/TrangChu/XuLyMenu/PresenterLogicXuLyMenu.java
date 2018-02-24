package com.wr.datpt.waterrecord.Presenter.TrangChu.XuLyMenu;

import com.wr.datpt.waterrecord.ConnectInternet.DownloadJSON;
import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.Model.TrangChu.Xulymenu.XulyJSONMenu;
import com.wr.datpt.waterrecord.View.HomeView.ViewXuLyMenu;

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
        String duongdan = "http://192.168.0.103:8084/WaterRecord/AreaServlet";
        DownloadJSON downloadJSON = new DownloadJSON(duongdan);
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
