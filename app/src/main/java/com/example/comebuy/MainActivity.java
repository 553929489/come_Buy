package com.example.comebuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.comebuy.Message.MessageFragment;
import com.example.comebuy.Order.ObjectFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button_position;
    ArrayList<Fragment>fragments = new ArrayList<>();
    RadioGroup Group_one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addfragment();
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(0xffFFE4C4);          //设置状态栏颜色和标题栏颜色一致
//        button_position = (Button)findViewById(R.id.button_position);
        Group_one = findViewById(R.id.bottom_button);
//        Drawable position = getResources().getDrawable(R.drawable.position);
//        position.setBounds(15,0,45,30);
//        button_position.setCompoundDrawables(position,null,null,null);
        RadioGroupListener rl = new RadioGroupListener();
        Group_one.setOnCheckedChangeListener(rl);
        replaceFragemt(fragments.get(0));
    }


//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        addfragment();
//        RadioGroupListener rl = new RadioGroupListener();
//        Group_one.setOnCheckedChangeListener(rl);
//        replaceFragemt(fragments.get(0));
//    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        addfragment();
//        RadioGroupListener rl = new RadioGroupListener();
//        Group_one.setOnCheckedChangeListener(rl);
//        replaceFragemt(fragments.get(0));
//    }

    private void  replaceFragemt(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.exchange,fragment);
        transaction.commit();
    }

    public void addfragment(){
        fragments.add(new MainFragment());
        fragments.add(new MessageFragment());
        fragments.add(new ObjectFragment());
        fragments.add(new MyFragment());
    }
    public class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (group == Group_one){
                switch (checkedId){
                    case R.id.homepage:
                        replaceFragemt(fragments.get(0));
                        break;
                    case R.id.message:
                        replaceFragemt(fragments.get(1));
                        break;
                    case R.id.homepage_tow:
                        replaceFragemt(fragments.get(2));
                        break;
                    case R.id.me_tree:
                        replaceFragemt(fragments.get(3));
                        break;
                }
            }
        }
    }
}