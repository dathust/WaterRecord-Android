package com.wr.datpt.waterrecord.Presenter.KhachHangTheoTram;

import com.wr.datpt.waterrecord.Model.KhachHangTheoTram.ModelHienThiKhachHangTram;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.View.HomeView.ViewHienThiKhachHangTram;

import java.util.List;

/**
 * Created by DatPT on 18/04/2018.
 */

public class PresenterLogicHienThiKhachHangTram implements IPresenterHienThiKhachHangTram {

    ViewHienThiKhachHangTram viewHienThiKhachHangTram;
    ModelHienThiKhachHangTram modelHienThiKhachHangTram;

    public PresenterLogicHienThiKhachHangTram(ViewHienThiKhachHangTram viewHienThiKhachHangTram){
        this.viewHienThiKhachHangTram = viewHienThiKhachHangTram;
        modelHienThiKhachHangTram = new ModelHienThiKhachHangTram();
    }
    @Override
    public void LayDanhSachKhachHangTram(int maTram) {
       List<Customer> customerList = modelHienThiKhachHangTram.customerListArea(maTram);
       if (customerList.size() > 0){
           viewHienThiKhachHangTram.HienThiDanhSachKhachHangTram(customerList);
       } else {
           viewHienThiKhachHangTram.LoiHienThiDanhSachKhachHangTram();
       }
    }
}
