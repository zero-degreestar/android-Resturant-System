package com.example.resaurant_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmOrderIceCream extends AppCompatActivity {

    String Extra = "";
    private Button button_notify;
    private static final String PRIMARY_CHANNEL_ID =  "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order_ice_cream);
        //>>>>>> Receive intent from OrderIceCream
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.Ice_you_are_ordering);
        String s = intent.getStringExtra("Order_a_Ice");
        tv.setText(s);
        TextView tv_1 = findViewById(R.id.Ice_Extras);
        String s_1 = intent.getStringExtra("Ice_Extra");
        Extra = s_1;
        tv_1.setText(s_1);
        TextView tv_2 = findViewById(R.id.Ice_Place);
        String s_2 = intent.getStringExtra("Ice_Price");
        tv_2.setText("Place Order ($" + s_2 + ")");

        createNotificationchannel();
        button_notify =findViewById(R.id.Ice_Place);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sleep 5 seconds
                sleep(5000);
                //return MainActivity
                return_MA();
                //弹窗
                SharedPreferences.Editor editor = getSharedPreferences(String.valueOf(ConfirmOrderBurger.num++), MODE_PRIVATE).edit();
                editor.putString("food_category","Ice cream");
                editor.putString("extra",Extra);
                editor.commit();
            }
        });
    }

    public void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());

    }


    public void createNotificationchannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID, "itech3106", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }

    }
    private NotificationCompat.Builder getNotificationBuilder(){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)

                .setContentTitle("Ice Cream ready!")
                .setContentText(Extra)
                .setSmallIcon(R.drawable.ic_launcher_foreground);
        return notifyBuilder;
    }
    public void sleep(int time){
        Handler handler = new Handler(); // 如果这个handler是在UI线程中创建的
        handler.postDelayed(new Runnable() {  // 开启的runnable也会在这个handler所依附线程中运行，即主线程
            @Override
            public void run() {
                sendNotification();
            }
        },time);
    }
    public void return_MA(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void PlaceOrderOnclick_Ice(View view) {
    }
}