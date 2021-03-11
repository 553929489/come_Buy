package com.example.comebuy.Order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.comebuy.LayOut.TimelineLayout;
import com.example.comebuy.R;

public class Get_Order_Activity extends AppCompatActivity implements View.OnClickListener{
    private Button addItemButton;
    private Button subItemButton;
    private Button addMarginButton;
    private Button subMarginButton;
    private TextView mCurrentMargin;
    private MapView mapView;
    private BaiduMap mBaiduMap;
    private TimelineLayout mTimelineLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        try {
            SDKInitializer.initialize(getApplicationContext());//初始化地图SDK
        } catch (Exception e) {
            Log.d(String.valueOf(e), "onCreate: ");
        }
            setContentView(R.layout.activity_get__order_);
            initView();
        }

        private void initView() {
            addItemButton = (Button) findViewById(R.id.add_item);
            subItemButton = (Button) findViewById(R.id.sub_item);
            addMarginButton= (Button) findViewById(R.id.add_margin);
            subMarginButton= (Button) findViewById(R.id.sub_margin);
            mCurrentMargin= (TextView) findViewById(R.id.current_margin);
            mTimelineLayout = (TimelineLayout) findViewById(R.id.timeline_layout);
            mapView = (MapView) findViewById(R.id.bmapview);
            mBaiduMap = mapView.getMap();

            addItemButton.setOnClickListener(this);
            subItemButton.setOnClickListener(this);
            addMarginButton.setOnClickListener(this);
            subMarginButton.setOnClickListener(this);
        }

        private int index = 0;
        private void addItem() {
            View view = LayoutInflater.from(this).inflate(R.layout.item_timeline, mTimelineLayout, false);
            ((TextView) view.findViewById(R.id.tv_action)).setText("步骤" + index);
            ((TextView) view.findViewById(R.id.tv_action_time)).setText("2017年3月8日16:55:04");
            ((TextView) view.findViewById(R.id.tv_action_status)).setText("完成");
            mTimelineLayout.addView(view);
            index++;
        }

        private void subItem() {
            if (mTimelineLayout.getChildCount() > 0) {
                mTimelineLayout.removeViews(mTimelineLayout.getChildCount() - 1, 1);
                index--;
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.add_item:
                    addItem();
                    break;
                case R.id.sub_item:
                    subItem();
                    break;
                case R.id.add_margin:
                    int currentMargin = UIHelper.pxToDip(this, mTimelineLayout.getLineMarginLeft());
                    mTimelineLayout.setLineMarginLeft(UIHelper.dipToPx(this, ++currentMargin));
                    mCurrentMargin.setText("current line margin left is " + currentMargin + "dp");
                    break;
                case R.id.sub_margin:
                    currentMargin = UIHelper.pxToDip(this, mTimelineLayout.getLineMarginLeft());
                    mTimelineLayout.setLineMarginLeft(UIHelper.dipToPx(this, --currentMargin));
                    mCurrentMargin.setText("current line margin left is " + currentMargin + "dp");
                    break;
                default:
                    break;
            }
        }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        mapView = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBaiduMap.setMyLocationEnabled(true);//开启定位图层
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBaiduMap.setMyLocationEnabled(false);//停止定位图层
    }
    }
