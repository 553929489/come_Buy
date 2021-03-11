package com.example.comebuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * Created by 张思远 on 2020/12/14.
 */

public class KindsAdapter extends ArrayAdapter<kinds> {
    private int resourceId;
    View view;
    ViewHolder viewHolder;



    class ViewHolder{
        ImageView ivKind;
        TextView tvKind;
    }
    public KindsAdapter(Context context, int resourceId,  List<kinds>kindsList){
        super(context,resourceId,kindsList);
        this.resourceId = resourceId;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        kinds Kind = getItem(position);
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.ivKind = (ImageView)view.findViewById(R.id.kinds_image);
            viewHolder.tvKind = (TextView)view.findViewById(R.id.kinds_name);
            view.setTag(viewHolder);
        }
        else {
            view = convertView;
            viewHolder =(ViewHolder)view.getTag();
        }
        viewHolder.tvKind.setText(Kind.getShopname());
        viewHolder.ivKind.setImageResource(Kind.getImage());
        return view;
    }
}
