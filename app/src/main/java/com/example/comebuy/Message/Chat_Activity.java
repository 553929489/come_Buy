package com.example.comebuy.Message;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.comebuy.R;

public class
Chat_Activity extends AppCompatActivity implements View.OnClickListener {
    private String msg;
    private Button button_right,button_left;
    private EditText ed_message;
    private ChatListViewAdapter adapter;
    private ListView chat_Listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_);
        ed_message = findViewById(R.id.et_meg);
        button_right = findViewById(R.id.btn_right);
        button_left =findViewById(R.id.btn_left);
        chat_Listview = findViewById(R.id.chat_ListView);
        button_left.setOnClickListener(this);
        button_right.setOnClickListener(this);
        adapter = new ChatListViewAdapter(this);
        chat_Listview.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        msg = ed_message.getText().toString().trim();
        switch (view.getId()){
            case R.id.btn_right:
                adapter.addDataToAdapter(new ChatInfo(null,msg));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_left:
                adapter.addDataToAdapter(new ChatInfo(msg,null));
                adapter.notifyDataSetChanged();
                break;
        }
        chat_Listview.smoothScrollToPosition(chat_Listview.getCount() - 1);
        ed_message.setText("");
    }
}