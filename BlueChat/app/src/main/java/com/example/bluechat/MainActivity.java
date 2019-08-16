package com.example.bluechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String name;
    private Button button_land;
    private EditText client_name;
    private EditText ip_input;
    private EditText port_input;
    private String ip;
    private String port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();                    //去掉标题
        if (actionBar != null) {
            actionBar.hide();
        }
        button_land = (Button) findViewById(R.id.button_land);
        button_land.setOnClickListener(this);
        client_name = (EditText) findViewById(R.id.client_name);
        ip_input = findViewById(R.id.client_ip);
        port_input = findViewById(R.id.client_port);
        ip_input.setText("192.168.1.169");
        port_input.setText("11111");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_land:
                //获取姓名
                name = client_name.getText().toString();
                ip = ip_input.getText().toString();
                port = port_input.getText().toString();
                Intent intent = new Intent(MainActivity.this, Chat.class);
                intent.putExtra("name", name);
                intent.putExtra("ip", ip);
                intent.putExtra("port", port);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
