package com.example.resaurant_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class OrderBurger extends AppCompatActivity {

    //>>>>>> set CheckBox
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;
    String Extstring = "";
    String burger_price;
    int num = 0;
    @Override
    //>>>>>>onCreate way:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_burger);
        checkBox1 = findViewById(R.id.cb_BBQ_Sauce);
        checkBox2 = findViewById(R.id.cb_Bacon);
        checkBox3 = findViewById(R.id.cb_Beetroot);
        checkBox4 = findViewById(R.id.cb_Cheese);
        checkBox5 = findViewById(R.id.cb_Egg);
        checkBox6 = findViewById(R.id.cb_Lettuce);
        checkBox7 = findViewById(R.id.cb_Mayo);
        checkBox8 = findViewById(R.id.cb_Onion);
        //>>>>>> 传入历史订单
        if (history.burger_tag == 1){
            Intent intent = getIntent();
            String st_ordered_burger = intent.getStringExtra("st_ordered_Burger");
            //Log.d("监视checkBox1的内容",checkBox1.getText().toString());
            //Log.d("监视st_ordered_burger的内容",st_ordered_burger);
            re_order_burger(st_ordered_burger);
        }
    }
    //>>>>>>set ... to Select All or Select Clear --first
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_burger, menu);
        //getMenuInflater().inflate(R.menu.activity_main, menu);// same in one line
        return true; // return true if there is a menu to inflate
    }


    // handling click event of a menu item
    @Override
    //>>>>>>set ... to Select All or Select Clear --Second
    public boolean onOptionsItemSelected(MenuItem item) {
        // Log.v(tag: "MainActivity" , item.toString()); // see in Logcat console which  menu-item is clicked
        switch (item.getItemId()) {
            // The "About" menu option starts a new activity
            case R.id.menu_select:
                Toast.makeText(this, "You Clicked About", Toast.LENGTH_LONG).show();
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox4.setChecked(true);
                checkBox5.setChecked(true);
                checkBox6.setChecked(true);
                checkBox7.setChecked(true);
                checkBox8.setChecked(true);
                return true;
            // The "Help" menu option just displays a toast
            case R.id.clear:
                Toast.makeText(this, "You Clicked Help", Toast.LENGTH_LONG).show();
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
                checkBox6.setChecked(false);
                checkBox7.setChecked(false);
                checkBox8.setChecked(false);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void Next_burger_onclick(View view) {
        Intent intent = new Intent(this, ConfirmOrderBurger.class);
        intent.putExtra("Order_a_Burger","You are ordering a Burger");
        Extras();
        Log.d("TAG",Extstring);
        intent.putExtra("Burger_Extra",Extstring);
        intent.putExtra("Burger_Price",String.valueOf(burger_price));
        startActivity(intent);
    }
    public void Extras(){
        String string = "Extras:";
        int tempnum = 0;
        double tempprice = 36.99;
        if(checkBox1.isChecked()) {
            string += " BBQ Sauce,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox2.isChecked()) {
            string += " Bacon,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox3.isChecked()) {
            string += " Beetroot,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox4.isChecked()) {
            string += " Cheese,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox5.isChecked()) {
            string += " Egg,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox6.isChecked()) {
            string += " Lettuce,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox7.isChecked()) {
            string += " Mayo,";
            tempnum++;
            tempprice += 0.36;
        }
        if(checkBox8.isChecked()) {
            string += " Onion,";
            tempnum++;
            tempprice += 0.36;
        }
        string = string.substring(0,string.length()-1) + " (" + tempnum + " total " + ")";
        Extstring = string;
        burger_price = String.format("%.2f",tempprice);
        num = tempnum;
    }
    //st_ordered 传送
    public void re_order_burger(String string){
        if (string.contains(checkBox1.getText().toString()))
            checkBox1.setChecked(true);
        if (string.contains(checkBox2.getText().toString()))
            checkBox2.setChecked(true);
        if (string.contains(checkBox3.getText().toString()))
            checkBox3.setChecked(true);
        if (string.contains(checkBox4.getText().toString()))
            checkBox4.setChecked(true);
        if (string.contains(checkBox5.getText().toString()))
            checkBox5.setChecked(true);
        if (string.contains(checkBox6.getText().toString()))
            checkBox6.setChecked(true);
        if (string.contains(checkBox7.getText().toString()))
            checkBox7.setChecked(true);
        if (string.contains(checkBox8.getText().toString()))
            checkBox8.setChecked(true);
    }


















}