package com.example.resaurant_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class history extends AppCompatActivity {
    public static int num_of_order;
    RadioGroup rg;
    RadioButton[] rbArray;
    String st_ordered = "";
    public static int burger_tag = 0;
    public static int pizza_tag = 0;
    public static int icecream_tag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        num_of_order = ConfirmOrderBurger.num;
        rg = findViewById(R.id.his_RadioGroup);
        rbArray = new RadioButton[num_of_order];
        Button hs = findViewById(R.id.his_button);
        hs.setEnabled(false);
        //设置监听器用来监听按钮是否被点击，以及点击后的一些操作
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                    RadioButton tempRadioButton = findViewById(checkedId);
                    if(tempRadioButton.isChecked()) {
                        //设置监听器，如果有radiobutton被点击则hs按钮生效
                        hs.setEnabled(true);
                        st_ordered = tempRadioButton.getText().toString();
                    }
            }
        });
        txt();
        for (int loop = 0; loop < num_of_order; loop++)
        {
            rbArray[loop] = new RadioButton(this);
            SharedPreferences sp = getSharedPreferences(String.valueOf(loop), Context.MODE_PRIVATE);
            Log.d("dd","dd");
            String temp=sp.getString("food_category","")+"\n"+sp.getString("extra","");
            rbArray[loop].setText(temp);
            rg.addView(rbArray[loop]);
        }
    }
    public void txt(){
        TextView tv = findViewById(R.id.his_TextView);
        if (num_of_order == 0){
            Log.d("dd","dd");
            tv.setText("There is no order.");
        }else {
            tv.setText("There are all of your orders.");
        }
    }

    public void his_bt(View view) {
        if(st_ordered.contains("Burger")) {
            burger_tag = 1;
            Intent intent = new Intent(this, OrderBurger.class);
            intent.putExtra("st_ordered_Burger",st_ordered);
            startActivity(intent);
        }else if(st_ordered.contains("Pizza")){
            pizza_tag = 1;
            Intent intent = new Intent(this, OrderPizza.class);
            intent.putExtra("st_ordered_Pizza",st_ordered);
            startActivity(intent);
        }else if(st_ordered.contains("Ice cream")){
            icecream_tag = 1;
            Intent intent = new Intent(this, OrderIcecream.class);
            intent.putExtra("st_ordered_Ice",st_ordered);
            startActivity(intent);
        }
    }
}