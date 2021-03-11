package com.example.comebuy.Order;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.comebuy.Message.Chat_Activity;
import com.example.comebuy.R;

import java.util.ArrayList;
import java.util.List;

public class ready_get_fragment extends Fragment {
    private ListView listView;
    private List<GetOrder> GetorderList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ready_get_order, container, false);
        intit();
        listView = view.findViewById(R.id.ready_get_ListView);
        GetOrder_adapter adapter = new GetOrder_adapter(getActivity(), R.layout.ready_get_item,GetorderList );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    Intent intent = new Intent(getActivity(), Get_Order_Activity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    public void intit () {
        GetOrder one = new GetOrder(R.drawable.hotle, "待收货", R.drawable.qianjue, "千珏饺子一份+蛇女面一份", "共2件",
                "合计", "￥", "1300"

        );
        GetorderList.add(one);
    }
}
