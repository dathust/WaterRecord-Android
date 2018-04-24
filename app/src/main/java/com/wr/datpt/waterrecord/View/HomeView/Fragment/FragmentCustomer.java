package com.wr.datpt.waterrecord.View.HomeView.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wr.datpt.waterrecord.Adapter.TestCustomerAdapter;
import com.wr.datpt.waterrecord.Model.ObjectClass.Customer;
import com.wr.datpt.waterrecord.Presenter.TrangChu.XuLyMenu.TestCustomer.TestCustomer;
import com.wr.datpt.waterrecord.R;

import java.util.List;

/**
 * Created by DatPT on 11/03/2018.
 */

public class FragmentCustomer extends Fragment {
    TestCustomerAdapter testCustomerAdapter;
    ListView listViewCustomer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_customer,container,false);
        listViewCustomer = view.findViewById(R.id.listcustomer);
        TestCustomer testCustomer = new TestCustomer();
        List<Customer> customerList = testCustomer.customerList();
        Log.d("Khách: ", customerList.get(1).getTenKhachHang());
        testCustomerAdapter = new TestCustomerAdapter(getActivity(),customerList);

        listViewCustomer.setAdapter(testCustomerAdapter);
        testCustomerAdapter.notifyDataSetChanged();
        return view;
    }
}