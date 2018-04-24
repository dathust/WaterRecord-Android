package com.wr.datpt.waterrecord.View.KhachHangTheoTram;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.wr.datpt.waterrecord.Adapter.CustomerAreaAdapter;
import com.wr.datpt.waterrecord.Adapter.TestCustomerAdapter;
import com.wr.datpt.waterrecord.Model.DangNhap_DangKy.ModelDangNhap;
import com.wr.datpt.waterrecord.Model.KhachHangTheoTram.ModelHienThiKhachHangTram;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.Presenter.KhachHangTheoTram.PresenterLogicHienThiKhachHangTram;
import com.wr.datpt.waterrecord.R;
import com.wr.datpt.waterrecord.View.HomeView.ViewHienThiKhachHangTram;

import java.util.List;

/**
 * Created by DatPT on 18/04/2018.
 */

public class HienThiKhachHangTheoTramActivity extends AppCompatActivity implements ViewHienThiKhachHangTram {

    ListView listView;
    Toolbar toolbar;
    Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hienthikhachhangtram);
        listView = findViewById(R.id.listcustomerarea);
        toolbar = findViewById(R.id.toolbar);
        Intent intent = getIntent();
        int  maTram = intent.getIntExtra("maTram",0);

        ModelHienThiKhachHangTram m = new ModelHienThiKhachHangTram();
        List<Customer> list = m.customerListArea(maTram);

        toolbar.setTitle("DS Khách hàng Trạm: " + maTram);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        PresenterLogicHienThiKhachHangTram khachHangTram = new PresenterLogicHienThiKhachHangTram(this);
        khachHangTram.LayDanhSachKhachHangTram(maTram);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuhome, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public void HienThiDanhSachKhachHangTram(List<Customer> customerList) {
        CustomerAreaAdapter customerAdapter = new CustomerAreaAdapter(HienThiKhachHangTheoTramActivity.this,customerList);
        listView.setAdapter(customerAdapter);
        customerAdapter.notifyDataSetChanged();
    }

    @Override
    public void LoiHienThiDanhSachKhachHangTram() {

    }
}
