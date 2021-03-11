package com.example.comebuy.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.comebuy.R;

import java.util.ArrayList;
import java.util.List;

public class ChatListViewAdapter extends BaseAdapter {
    private Context context;
    private List<ChatInfo> datas = new ArrayList<>();
    private ViewHolder viewHolder;
    private View view;


    //给adapter添加数据
    public void addDataToAdapter(ChatInfo e) {
        datas.add(e);
    }

    public ChatListViewAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup partent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.chat_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //获取adapter中的数据
        String left = datas.get(position).getLeft_text();
        String right = datas.get(position).getRight_text();

        //如果数据为空，则将数据设置给右边，同时显示右边，隐藏左边
        if (left == null) {
            viewHolder.textright.setText(right);
            viewHolder.right.setVisibility(View.VISIBLE);
            viewHolder.left.setVisibility(View.INVISIBLE);
        }

        //与上一步相反
        if (right == null) {
            viewHolder.textleft.setText(left);
            viewHolder.left.setVisibility(View.VISIBLE);
            viewHolder.right.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }

    public  static class ViewHolder {
        public View rootView;
        LinearLayout left;
        LinearLayout right;
        TextView textleft;
        TextView textright;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.textleft = (TextView) rootView.findViewById(R.id.text_left);
            this.left = (LinearLayout) rootView.findViewById(R.id.left);
            this.textright = (TextView) rootView.findViewById(R.id.text_right);
            this.right = (LinearLayout) rootView.findViewById(R.id.right);
        }
    }
}
