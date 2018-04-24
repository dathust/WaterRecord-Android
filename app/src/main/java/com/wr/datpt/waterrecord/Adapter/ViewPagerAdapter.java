package com.wr.datpt.waterrecord.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wr.datpt.waterrecord.View.HomeView.Fragment.FragmentArea;
import com.wr.datpt.waterrecord.View.HomeView.Fragment.FragmentCustomer;
import com.wr.datpt.waterrecord.View.HomeView.Fragment.FragmentNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DatPT on 11/03/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> listFragment = new ArrayList<>();
    List<String> titleFragment = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new FragmentNews());
        listFragment.add(new FragmentArea());
        listFragment.add(new FragmentCustomer());

        titleFragment.add("Thông báo");
        titleFragment.add("Trạm");
        titleFragment.add("Khách hàng");
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
