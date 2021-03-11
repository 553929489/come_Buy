package com.example.comebuy.Order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.comebuy.R;

import java.util.List;

public class AllOrder_adapter extends ArrayAdapter<AllOrder> {
    private int resourceId;
    View view;
    ViewHolder viewHolder;

    public AllOrder_adapter(@NonNull Context context, int resource, @NonNull List<AllOrder> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AllOrder allOrder = getItem(position);
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
        viewHolder.shop_image.setImageResource(allOrder.getShop_image());
        viewHolder.order_state.setText(allOrder.getOrder_state());
        viewHolder.food_total.setText(allOrder.getFood_total());
        viewHolder.food_all.setText(allOrder.getFood_all());
        viewHolder.price_text.setText(allOrder.getPrice_text());
        viewHolder.food_image.setImageResource(allOrder.getFood_image());
        viewHolder.RMB_image.setText(allOrder.getRMB_image());
        viewHolder.price_text.setText(allOrder.getPrice_text());
        viewHolder.price.setText(allOrder.getPrice());
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
    }
}

