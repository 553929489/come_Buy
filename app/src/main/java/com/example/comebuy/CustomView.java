package com.example.comebuy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CustomView extends LinearLayout {
    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public void initView() {
        View view = View.inflate(getContext(), R.layout.shopping_car, null);
        addView(view);
    }

}
