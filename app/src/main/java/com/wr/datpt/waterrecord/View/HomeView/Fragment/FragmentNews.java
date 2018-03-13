package com.wr.datpt.waterrecord.View.HomeView.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wr.datpt.waterrecord.R;

/**
 * Created by DatPT on 11/03/2018.
 */

public class FragmentNews extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_news,container,false);
        return view;
    }
}
