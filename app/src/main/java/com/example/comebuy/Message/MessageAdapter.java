package com.example.comebuy.Message;

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

public class MessageAdapter extends ArrayAdapter<Message> {
    private int resourceId;
    ViewHolder viewHolder;
    View view;
    public MessageAdapter(@NonNull Context context, int resourceId, @NonNull List<Message> messageList) {
        super(context, resourceId, messageList);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Message message = getItem(position);
        if (convertView == null){
            view =  LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.shopimage = view.findViewById(R.id.photo);
            viewHolder.shopname = view.findViewById(R.id.shopname);
            viewHolder.time = view.findViewById(R.id.time);
            viewHolder.final_message = view.findViewById(R.id.final_message);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.shopimage.setImageResource(message.getImage());
        viewHolder.shopname.setText(message.getTitle());
        viewHolder.time.setText(message.getTime());
        viewHolder.final_message.setText(message.getEnd_message());
        return view;
    }
    class ViewHolder{
        ImageView shopimage;
        TextView shopname;
        TextView time;
        TextView final_message;

    }
}
