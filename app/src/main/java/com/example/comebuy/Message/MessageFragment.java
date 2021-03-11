package com.example.comebuy.Message;

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

import com.example.comebuy.R;

import java.util.ArrayList;

/**
 * Created by 张思远 on 2020/12/16.
 */

public class MessageFragment extends Fragment {
    private ArrayList<Message> messageList = new ArrayList<>();
    private ListView ListView_message;
    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        intit();
        View view = inflater.inflate(R.layout.message_fragment,container,false);
        ListView_message = view.findViewById(R.id.messages);
        MessageAdapter messageAdapter = new MessageAdapter(getActivity(),R.layout.messagesitem,messageList);
        ListView_message.setAdapter(messageAdapter);
        ListView_message.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    Intent intent = new Intent(getActivity(), Chat_Activity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
    public void intit(){
        Message one = new Message(R.drawable.qianjue,"彪哥饺子馆","2020/12/31","欢迎下次光临哦");
        messageList.add(one);
        Message tow = new Message(R.drawable.shenv,"彪哥面馆","2020/1/31","欢迎下次光临哦");
        messageList.add(tow);
        Message tree = new Message(R.drawable.hotle,"彪哥大酒店","2020/6/31","欢迎下次光临哦");
        messageList.add(tree);
    }
}
