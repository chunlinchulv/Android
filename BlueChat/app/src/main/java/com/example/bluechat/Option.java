package com.example.bluechat;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Option extends AppCompatActivity implements View.OnClickListener {
    private List<String> name = new ArrayList<>();              //保存用户名的集合
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //获取上个活动传递过来的数据
        data = intent.getStringExtra("str");
        name.add(data);                                //将新登陆的用户名称添加到集合
        setContentView(R.layout.my_option);                     //加载布局
        ActionBar actionBar = getSupportActionBar();             //去掉标题
        if (actionBar != null) {
            actionBar.hide();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Option.this,android.R.layout.simple_list_item_1,name);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Button we_chat = (Button)findViewById(R.id.we_chat);          //实例化按钮
        we_chat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.we_chat:
                Intent intent = new Intent(Option.this, Chat.class);             //转到聊天活动
                intent.putExtra("str",data);         //传给下一个活动
                startActivity(intent);                      //开启活动
                break;
                default:
                    break;
        }
    }
}
