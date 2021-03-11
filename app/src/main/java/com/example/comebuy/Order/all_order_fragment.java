package com.example.comebuy.Order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.comebuy.R;

import java.util.ArrayList;
import java.util.List;

public class all_order_fragment extends Fragment {
    private ListView listView;
    private List<AllOrder> AllorderList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_order,container,false);
        intit();
        listView = view.findViewById(R.id.all_order_ListView);
        AllOrder_adapter adapter = new AllOrder_adapter(getActivity(),R.layout.all_order_item,AllorderList);
        listView.setAdapter(adapter);
        return view;
    }

    public void intit(){
        AllOrder one = new AllOrder(R.drawable.hotle,"待付款",R.drawable.qianjue,"千珏饺子一份+蛇女面一份","共2件",
                "合计","￥","1300"
                );
        AllorderList.add(one);
        AllOrder tow = new AllOrder(R.drawable.ktv,"待收货",R.drawable.shenv,"千珏饺子一份+蛇女面一份","共2件",
                "合计","￥","1300"

        );
        AllorderList.add(tow);
    }
}
