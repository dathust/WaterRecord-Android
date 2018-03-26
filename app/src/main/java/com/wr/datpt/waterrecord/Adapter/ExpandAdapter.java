package com.wr.datpt.waterrecord.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wr.datpt.waterrecord.Model.ObjectClass.Area;
import com.wr.datpt.waterrecord.Presenter.TrangChu.LayKhachHang.LayKhachHangKhuVuc;
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
    HashMap<String,List<String>> listChild;
    ViewHolderMenu viewHolderMenu;

    public ExpandAdapter (Context context, List<String> listHeader,HashMap<String,List<String>> listChild) {
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
        return listChild.get(listHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition+1;
    }

    public class ViewHolderMenu{
        TextView txtMaTram;
        ImageView hinhMenu;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {

        if (convertView == null){
            viewHolderMenu = new ViewHolderMenu();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_group,null);
            viewHolderMenu.hinhMenu = convertView.findViewById(R.id.imMenu);
            viewHolderMenu.txtMaTram = convertView.findViewById(R.id.txtGroup);
            convertView.setTag(viewHolderMenu);
        } else {
            viewHolderMenu = (ViewHolderMenu) convertView.getTag();
        }
        String headrttitle = (String) getGroup(groupPosition);
        viewHolderMenu.txtMaTram.setText(headrttitle);
        if (isExpanded){
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
        }
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        String item = (String) getChild(groupPosition,childPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LayKhachHangKhuVuc layKhachHangKhuVuc = new LayKhachHangKhuVuc();
        convertView = layoutInflater.inflate(R.layout.layout_child,null);
        TextView textView = convertView.findViewById(R.id.txtChild);
        textView.setText(item);
        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("Textview:" , "Postion:" + getChildId(groupPosition,childPosition));
                //
                if("Trạm".equals(getGroup(groupPosition))){
                    layKhachHangKhuVuc.LayKhachHangKhuVuc((int)getChildId(groupPosition,childPosition));
                } else {
                    Log.d("Staff","Danh sách nhân viên");
                }

                //
                return false;
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
