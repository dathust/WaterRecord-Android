package com.wr.datpt.waterrecord.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.R;

import java.util.List;

/**
 * Created by DatPT on 17/04/2018.
 */

public class TestCustomerAdapter extends BaseAdapter {


    LayoutInflater inflater;
    List<Customer> customerList;

    public TestCustomerAdapter(Context context, List<Customer> customerList) {
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        Customer customer = customerList.get(position);
        TextView txtName, txtPhone, txtAddress;
        if (view == null) {
            view = inflater.inflate(R.layout.custom_layout_customer, viewGroup, false);
        }
        txtName = view.findViewById(R.id.txtName);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtAddress = view.findViewById(R.id.txtAddress);

        txtName.setText(customer.getTenKhachHang().toString());
        txtPhone.setText(customer.getDienThoai().toString());
        txtAddress.setText(customer.getDiaChi().toString());

        return view;
    }
}
