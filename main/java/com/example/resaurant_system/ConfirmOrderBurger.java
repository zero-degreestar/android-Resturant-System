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


public class ConfirmOrderBurger extends AppCompatActivity {

    public static int num = 0;
    RadioButton rb1,rb2,rb3;
    RadioGroup rg;
    TextView tvResult;
    String Extra = "";
    String Burger_price = "";
    Boolean is_rb1 = false;
    Boolean is_rb2 = false;
    Boolean is_rb3 = false;

    private Button button_notify;
    private static final String PRIMARY_CHANNEL_ID =  "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order_burger);
        //>>>>>> Receive intent from OrderBurger
        Intent intent = getIntent();
        TextView tv = findViewById(R.id.Burger_you_are_ordering);
        String s = intent.getStringExtra("Order_a_Burger");
        tv.setText(s);
        TextView tv_1 = findViewById(R.id.Burger_Extras);
        String s_1 = intent.getStringExtra("Burger_Extra");
        Extra = s_1;
        tv_1.setText(s_1);
        Burger_price = intent.getStringExtra("Burger_Price");

        rb1 = findViewById(R.id.Burger_RB_1);
        rb2 = findViewById(R.id.Burger_RB_2);
        rb3 = findViewById(R.id.Burger_RB_3);
        rg = findViewById(R.id.BurgerRG);
        tvResult = findViewById(R.id.Burger_Place);
        //rb2.setChecked(true);
        //rg.check(R.id.Burger_RB_1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //Log.d("dd",Burger_price);
                if(R.id.Burger_RB_1 == checkedId){
                    //Log.d("TAG",Burger_price);
                    is_rb1 = true;
                    Double sc = Double.valueOf(Burger_price) + 4.99;
                    tvResult.setText("Place Order ($"+ String.format("%.2f", sc) +")");
                }else if(R.id.Burger_RB_2 == checkedId){
                    //Log.d("TAG","RB_2 is OK");
                    is_rb2 = true;
                    Double sc = Double.valueOf(Burger_price) + 2.49;
                    tvResult.setText("Place Order ($"+ String.format("%.2f", sc) +")");
                }else if(R.id.Burger_RB_3 == checkedId){
                    is_rb3 = true;
                    tvResult.setText("Place Order ($"+ Burger_price +")");
                }
            }
        });
        createNotificationchannel();
        button_notify =findViewById(R.id.Burger_Place);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sleep 10 seconds
                sleep(10000);
                //return MainActivity
                return_MA();
                //传入num.xml文本
                SharedPreferences.Editor editor = getSharedPreferences(String.valueOf(num++), MODE_PRIVATE).edit();
                editor.putString("food_category","Burger");
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

                .setContentTitle("Burger ready!")
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

    public void PlaceOrderOnclick(View view) {
    }
}