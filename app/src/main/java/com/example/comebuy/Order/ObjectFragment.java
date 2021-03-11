package com.example.comebuy.Order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.comebuy.R;

import java.util.ArrayList;

/**
 * Created by 张思远 on 2020/12/16.
 */

public class ObjectFragment extends Fragment {
    private RadioGroup Groupone;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.object_fragment,container,false);
        addFragment();
        Groupone = view.findViewById(R.id.Top_order_title);
        RadioGroupListener listener = new RadioGroupListener();
        Groupone.setOnCheckedChangeListener(listener);
        replaceFragment(fragments.get(0));
        return view;
    }

    public void addFragment(){
        fragments.add(new all_order_fragment());
        fragments.add(new ready_pay_Fragemt());
        fragments.add(new ready_get_fragment());
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.order_exchange_fragment,fragment);
        transaction.commit();
    }
    public class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checked) {
            if (group == Groupone){
                switch (checked){
                    case R.id.all_order:
                        replaceFragment(fragments.get(0));
                        break;
                    case R.id.ready_pay_order:
                       replaceFragment(fragments.get(1));
                        break;
                    case R.id.ready_get_order:
                        replaceFragment(fragments.get(2));
                        break;
                }
            }

        }
    }
}
