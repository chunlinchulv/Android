package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_notice:
                Intent intent =new Intent(this,NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                final String CHANNEL_ID = "channel_id_1";
                final String CHANNEL_NAME = "channel_name_1";

                NotificationManager mNotificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    //只在Android O之上需要渠道
                    NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                            CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
                    //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，
                    //通知才能正常弹出
                    mNotificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder= new NotificationCompat.Builder(this,CHANNEL_ID);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("通知标题")
                        .setContentText("通知内容")
                        .setContentIntent(pi)
                        .setAutoCancel(true);                   //取消通知栏
                mNotificationManager.notify(1, builder.build());
                break;
                default:
                    break;
        }
    }
}
