package com.example.comebuy.Order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.comebuy.R;

import java.util.List;

public class PayOrder_adapter extends ArrayAdapter<PayOrder> {
    private int resourceId;
    View view;
    ViewHolder viewHolder;

    public PayOrder_adapter(@NonNull Context context, int resourceId, @NonNull List<PayOrder> objects) {
        super(context, resourceId, objects);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PayOrder payOrder = getItem(position);
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.shop_image = view.findViewById(R.id.shop_image);
            viewHolder.order_state = view.findViewById(R.id.order_state);
            viewHolder.food_total = view.findViewById(R.id.food_total);
            viewHolder.food_all = view.findViewById(R.id.food_all);
            viewHolder.food_image = view.findViewById(R.id.food_image);
            viewHolder.price_text = view.findViewById(R.id.price_text);
            viewHolder.RMB_image = view.findViewById(R.id.RMB_image);
            viewHolder.price = view.findViewById(R.id.Price);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }
        viewHolder.order_state.setText(payOrder.getOrder_state());
        viewHolder.shop_image.setImageResource(payOrder.getShop_image());
        viewHolder.food_total.setText(payOrder.getFood_total());
        viewHolder.food_all.setText(payOrder.getFood_all());
        viewHolder.price_text.setText(payOrder.getPrice_text());
        viewHolder.food_image.setImageResource(payOrder.getFood_image());
        viewHolder.RMB_image.setText(payOrder.getRMB_image());
        viewHolder.price_text.setText(payOrder.getPrice_text());
        viewHolder.price.setText(payOrder.getPrice());
        return view;
    }
    public class ViewHolder{
        ImageView shop_image;
        TextView order_state;
        ImageView food_image;
        TextView food_all;
        TextView food_total;
        TextView price_text;
        TextView RMB_image;
        TextView price;
        RadioButton
    }
}
