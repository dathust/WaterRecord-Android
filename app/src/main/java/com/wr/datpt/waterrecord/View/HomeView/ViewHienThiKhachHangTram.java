package com.wr.datpt.waterrecord.View.HomeView;

import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;

import java.util.List;

/**
 * Created by DatPT on 18/04/2018.
 */

public interface ViewHienThiKhachHangTram {
    void HienThiDanhSachKhachHangTram(List<Customer> customerList);
    void LoiHienThiDanhSachKhachHangTram();
}
