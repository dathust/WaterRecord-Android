package com.wr.datpt.waterrecord.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.R;
import com.wr.datpt.waterrecord.View.GhiSoKhachHang.GhiSoKhachHangActivity;

import java.util.List;

/**
 * Created by DatPT on 19/04/2018.
 */

public class CustomerAreaAdapter extends BaseAdapter{

    Context context;
    LayoutInflater inflater;
    List<Customer> customerList;


    public CustomerAreaAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.customerList = customerList;

    }

    @Override
    public int getCount() {
        return customerList.size();
    }

    @Override
    public Object getItem(int position) {
        return customerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup viewGroup) {
        Customer customer = customerList.get(position);
        Customer customerView1 = (Customer) getItem(position);
        int status = customerView1.getTrangThai();
        Log.d("status",String.valueOf(status));
        TextView txtName, txtPhone, txtAddress;
        LinearLayout linearLayout;
        if (view == null) {
            view = inflater.inflate(R.layout.custom_layout_customer, viewGroup, false);
        }
        txtName = view.findViewById(R.id.txtName);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtAddress = view.findViewById(R.id.txtAddress);
        linearLayout = view.findViewById(R.id.idCustomer);

        txtName.setText(customer.getTenKhachHang().toString());
        txtPhone.setText(customer.getDienThoai().toString());
        txtAddress.setText(customer.getDiaChi().toString());

        if (status==1){
            linearLayout.setBackgroundColor(-5192482);
        } else {
            if (status==2){
                linearLayout.setBackgroundColor(-989556);
            } else {
                linearLayout.setBackgroundColor(Color.WHITE);
            }
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewChild) {
                Customer customerView = (Customer) getItem(position);
                Log.d("click:", String.valueOf(customerView.getMaKhachHang()));
                Log.d("chiso: " ,String.valueOf(customerView.getChiSoThangNay()));
                Intent iGhiSoKhachHang = new Intent(context,GhiSoKhachHangActivity.class);
                iGhiSoKhachHang.putExtra("maTram",customerView.getMaTram());
                iGhiSoKhachHang.putExtra("maKhachHang",customerView.getMaKhachHang());
                iGhiSoKhachHang.putExtra("tenKhachHang", customerView.getTenKhachHang());
                iGhiSoKhachHang.putExtra("soDienThoai", customerView.getDienThoai());
                iGhiSoKhachHang.putExtra("diaChi", customerView.getDiaChi());
                iGhiSoKhachHang.putExtra("tongChiSo", customerView.getTongChiSo());
                iGhiSoKhachHang.putExtra("toaDoX", customerView.getToaDoX());
                iGhiSoKhachHang.putExtra("toaDoY", customerView.getGetToaDoY());
                iGhiSoKhachHang.putExtra("trangThai", customerView.getTrangThai());
                iGhiSoKhachHang.putExtra("chiSoThangNay", customerView.getChiSoThangNay());
                iGhiSoKhachHang.putExtra("chiSoThangTruoc", customerView.getChiSoThangTruoc());
                context.startActivity(iGhiSoKhachHang);
            }
        });

        return view;
    }

}
