package com.wr.datpt.waterrecord.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.R;

import java.util.List;

/**
 * Created by DatPT on 25/03/2018.
 */

public class CustomerAdapter extends BaseAdapter {

    List<Customer> customerList;
    Context context;
    ViewHolderCustomer viewHolderCustomer;

    public CustomerAdapter(Context context, List<Customer> customerList){
        this.context = context;
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

    public class ViewHolderCustomer{
        TextView txtTenKH;
        TextView txtDiaChi;
        TextView txtChiSo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        RecyclerView.ViewHolder viewHolder;
        if (convertView == null){
            viewHolderCustomer = new ViewHolderCustomer();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customer_item,null);
            viewHolderCustomer.txtTenKH = convertView.findViewById(R.id.txtTenKH);
            viewHolderCustomer.txtDiaChi = convertView.findViewById(R.id.txtDiaChi);
            viewHolderCustomer.txtChiSo = convertView.findViewById(R.id.txtChiSo);
            convertView.setTag(viewHolderCustomer);
        }else {
            viewHolderCustomer = (ViewHolderCustomer) convertView.getTag();
        }
        Customer customer = this.customerList.get(position);
        viewHolderCustomer.txtTenKH.setText(customer.getTenKhachHang());
        viewHolderCustomer.txtDiaChi.setText(customer.getDiaChi());
        viewHolderCustomer.txtChiSo.setText(customer.getTongChiSo());
        return convertView;
    }
}
