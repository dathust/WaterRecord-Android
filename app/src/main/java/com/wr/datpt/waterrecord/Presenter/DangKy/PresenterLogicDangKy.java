package com.wr.datpt.waterrecord.Presenter.DangKy;

import com.wr.datpt.waterrecord.Model.DangNhap_DangKy.ModelDangKy;
import com.wr.datpt.waterrecord.Model.ObjectClass.Staff;
import com.wr.datpt.waterrecord.View.DangNhap_DangKy.ViewDangKy;

/**
 * Created by DatPT on 13/04/2018.
 */

public class PresenterLogicDangKy implements IPresenterDangKy{
    ViewDangKy viewDangKy;
    ModelDangKy modelDangKy;

    public PresenterLogicDangKy(ViewDangKy viewDangKy){
        this.viewDangKy = viewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void ThucHienDangKy(Staff staff) {
        boolean kiemtra = modelDangKy.DangKyThanhVien(staff);
        if (kiemtra){
            viewDangKy.DangKyThanhCong();
        } else {
            viewDangKy.DangKyThatBai();
        }
    }
}
