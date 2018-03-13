package com.wr.datpt.waterrecord.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DatPT on 12/02/2018.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {

    Context context;
    List<Area> areaList;

    List<String> listHeader;
    HashMap<String,List<Area>> listChild;

    public ExpandAdapter (Context context, List<String> listHeader,HashMap<String,List<Area>> listChild) {
        this.context = context;
        this.listHeader = listHeader;
        this.listChild = listChild;

    }
    @Override
    public int getGroupCount() {
        return listHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listChild.get(listHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listHeader.get(groupPosition)).get(childPosition).getTenTram();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        String headrttitle = (String) getGroup(groupPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.layout_group,null);
        TextView textView = convertView.findViewById(R.id.txtGroup);
        textView.setText(headrttitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        String item = (String) getChild(groupPosition,childPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.layout_child,null);
        TextView textView = convertView.findViewById(R.id.txtChild);
        textView.setText(item);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
