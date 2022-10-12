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

public class OrderIcecream extends AppCompatActivity {

    //>>>>>> set CheckBox
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;
    String Extstring = "";
    int num = 0;
    String ice_cream_price = "";
    @Override
    //>>>>>>onCreate way:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_icecream);
        checkBox1 = findViewById(R.id.cb_Banana);
        checkBox2 = findViewById(R.id.cb_Caramel_Sauce);
        checkBox3 = findViewById(R.id.cb_Chocolate_Topping);
        checkBox4 = findViewById(R.id.cb_Chopped_Nuts);
        checkBox5 = findViewById(R.id.cb_Maple_Syrup);
        checkBox6 = findViewById(R.id.cb_Sherbet);
        checkBox7 = findViewById(R.id.cb_Sprinkles);
        //>>>>>> 传入历史订单
        if(history.icecream_tag == 1){
            Intent intent = getIntent();
            String st_ordered_ice = intent.getStringExtra("st_ordered_Ice");
            Log.d("监视checkBox1的内容",checkBox4.getText().toString());
            Log.d("监视st_ordered_burger的内容",st_ordered_ice);
            re_order_icecream(st_ordered_ice);
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
                //burger_price=83.15;
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
                //burger_price=76.99;
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
    //set Next_icecream_onclick button
    public void Next_icecream_onclick(View view) {
        Intent intent = new Intent(this, ConfirmOrderIceCream.class);
        intent.putExtra("Order_a_Ice","You are ordering a Ice Cream");
        Extras();
        Log.d("TAG",Extstring);
        intent.putExtra("Ice_Extra",Extstring);
        intent.putExtra("Ice_Price",ice_cream_price);
        startActivity(intent);
    }
    //set Extras Text
    public void Extras(){
        int tempnum = 0;
        double tempprice = 35.99;
        String string = "Extras:";
        if(checkBox1.isChecked()) {
            string += " Banana,";
            tempnum++;
            tempprice += 0.35;
        }
        if(checkBox2.isChecked()) {
            string += " Caramel Sauce,";
            tempnum++;
            tempprice += 0.35;
        }
        if(checkBox3.isChecked()) {
            string += " Chocolate Topping,";
            tempnum++;
            tempprice += 0.35;
        }
        if(checkBox4.isChecked()) {
            string += " Chopped Nuts,";
            tempnum++;
            tempprice += 0.35;
        }
        if(checkBox5.isChecked()) {
            string += " Maple Syrup,";
            tempnum++;
            tempprice += 0.35;
        }
        if(checkBox6.isChecked()) {
            string += " Sherbet,";
            tempnum++;
            tempprice += 0.35;
        }
        if(checkBox7.isChecked()) {
            string += " Sprinkles,";
            tempnum++;
            tempprice += 0.35;
        }
        string = string.substring(0,string.length()-1) + " (" + tempnum + " total " + ")";
        Extstring = string;
        ice_cream_price = String.format("%.2f",tempprice);
        num = tempnum;
    }
    public void re_order_icecream(String string) {
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
    }
}








