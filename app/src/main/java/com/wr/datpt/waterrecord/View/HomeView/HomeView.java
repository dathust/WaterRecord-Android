package com.wr.datpt.waterrecord.View.HomeView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.wr.datpt.waterrecord.Adapter.ExpandAdapter;
import com.wr.datpt.waterrecord.Adapter.ViewPagerAdapter;
import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.Presenter.TrangChu.LayKhachHang.LayKhachHangKhuVuc;
import com.wr.datpt.waterrecord.Presenter.TrangChu.LayKhachHang.LayKhachHangKhuVucItf;
import com.wr.datpt.waterrecord.Presenter.TrangChu.XuLyMenu.PresenterLogicXuLyMenu;
import com.wr.datpt.waterrecord.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DatPT on 01/02/2018.
 */

public class HomeView extends AppCompatActivity implements ViewXuLyMenu{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ExpandableListView expandableListView;
    ListView listView;
    List<String> listHeader;
    HashMap<String,List<String>> listChild;
    ExpandAdapter expandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeview);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        expandableListView = findViewById(R.id.epMenu);
        listView = findViewById(R.id.listcustomer);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();


        PresenterLogicXuLyMenu presenterLogicXuLyMenu = new PresenterLogicXuLyMenu(this);
        presenterLogicXuLyMenu.LayDanhSachMenu();

        LayKhachHangKhuVuc layKhachHangKhuVuc = new LayKhachHangKhuVuc(this);
        layKhachHangKhuVuc.LayKhachHangKhuVuc();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    @Override
    public void HientThiDanhSachMenu(List<Area> areaList) {
        listHeader = new ArrayList<>();
        listHeader.add("Trạm");
        listHeader.add("Nhân Viên");
        listChild = new HashMap<String,List<String>>();

        List<String> listTram = new ArrayList<>();
        int countList = areaList.size();
        for (int i=0; i<countList;i++){
            listTram.add(areaList.get(i).getTenTram());
        }
        List<String> listNV = new ArrayList<>();
        listNV.add("Nhân viên ghi số");
        listNV.add("Nhân viên hệ thống");

        listChild.put(listHeader.get(0),listTram);
        listChild.put(listHeader.get(1), listNV);
        expandAdapter = new ExpandAdapter(this,listHeader,listChild);
        expandableListView.setAdapter(expandAdapter);
        expandAdapter.notifyDataSetChanged();

    }

    @Override
    public void HienThiDanhSachKhachHangKhuVuc(List<Customer> customerList) {
        //Log.d("check1",customerList.get(0).getDiaChi().toString());
    }
}

