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

import com.wr.datpt.waterrecord.Adapter.ExpandAdapter;
import com.wr.datpt.waterrecord.Adapter.ViewPagerAdapter;
import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
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
        //expandableListView = findViewById(R.id.epMenu);

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

        addControl();
        expandAdapter = new ExpandAdapter(HomeView.this,listHeader,listChild);
        expandableListView.setAdapter(expandAdapter);

        PresenterLogicXuLyMenu presenterLogicXuLyMenu = new PresenterLogicXuLyMenu(this);
        presenterLogicXuLyMenu.LayDanhSachMenu();

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
//        expandableListView = findViewById(R.id.epMenu);
//
//        List<String> listHeader = new ArrayList<>();
//        HashMap<String,List<String>> listChild = new HashMap<>();
//
//        listHeader.add("Trạm");
//        listHeader.add("Nhân Viên");
//
//        List<String> tram = new ArrayList<>();
//        tram.add("Trạm 1");
//        tram.add("Trạm 2");
//        tram.add("Trạm 3");
//
//        List<String> nhanVien = new ArrayList<>();
//        nhanVien.add("Nhân viên ghi số");
//        nhanVien.add("Nhân viên hệ thống");
//
//        listChild.put(listHeader.get(0),tram);
//        listChild.put(listHeader.get(1),nhanVien);
        Log.d("check1",areaList.get(0).getDiaChi().toString());
    }
    public void addControl(){
        expandableListView = findViewById(R.id.epMenu);

        listHeader = new ArrayList<>();
        listChild = new HashMap<String,List<String>>();

        listHeader.add("Trạm");
        listHeader.add("Nhân Viên");

        List<String> tram = new ArrayList<>();
        tram.add("Trạm 1");
        tram.add("Trạm 2");
        tram.add("Trạm 3");

        List<String> nhanVien = new ArrayList<>();
        nhanVien.add("Nhân viên ghi số");
        nhanVien.add("Nhân viên hệ thống");

        listChild.put(listHeader.get(0),tram);
        listChild.put(listHeader.get(1),nhanVien);
    }
}

