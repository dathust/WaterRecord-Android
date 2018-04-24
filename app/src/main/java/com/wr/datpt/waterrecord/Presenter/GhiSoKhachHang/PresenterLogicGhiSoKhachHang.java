package com.wr.datpt.waterrecord.Presenter.GhiSoKhachHang;

import com.wr.datpt.waterrecord.Model.GhiSoKhachHang.ModelGhiSoKhachHang;
import com.wr.datpt.waterrecord.Model.ObjectClass.Indication;
import com.wr.datpt.waterrecord.View.GhiSoKhachHang.ViewGhiSoKhachHang;

/**
 * Created by DatPT on 22/04/2018.
 */

public class PresenterLogicGhiSoKhachHang {
    ViewGhiSoKhachHang viewGhiSoKhachHang;
    ModelGhiSoKhachHang modelGhiSoKhachHang;

    public PresenterLogicGhiSoKhachHang(ViewGhiSoKhachHang viewGhiSoKhachHang){
        this.viewGhiSoKhachHang = viewGhiSoKhachHang;
        modelGhiSoKhachHang = new ModelGhiSoKhachHang();
    }

    public void ThucHienGhiSo(Indication indication){
        boolean kiemtra = modelGhiSoKhachHang.GhiSoKhachHang(indication);
        if (kiemtra){
            viewGhiSoKhachHang.GhiSoThanhCong();
        } else {
            viewGhiSoKhachHang.GhiSoThatBai();
        }
    }
}
