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

public class OrderPizza extends AppCompatActivity {

    //>>>>>> set CheckBox
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;
    String Extstring = "";
    String pizza_price;
    int num = 0;
    @Override
    //>>>>>>onCreate way:
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);
        checkBox1 = findViewById(R.id.cb_Anchovies);
        checkBox2 = findViewById(R.id.cb_BBQ_Sauce_piz);
        checkBox3 = findViewById(R.id.cb_Basil);
        checkBox4 = findViewById(R.id.cb_Cheese_piz);
        checkBox5 = findViewById(R.id.cb_Chicken);
        checkBox6 = findViewById(R.id.cb_Garlic);
        checkBox7 = findViewById(R.id.cb_Ham);
        checkBox8 = findViewById(R.id.cb_Mushroom);
        if(history.pizza_tag == 1){
            Intent intent = getIntent();
            String st_order_pizza = intent.getStringExtra("st_ordered_Pizza");
            re_ordered_pizza(st_order_pizza);
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
                checkBox8.setChecked(false);
                //burger_price=76.99;
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    //set Next_pizza_onclick button
    public void Next_pizza_onclick(View view) {
        Intent intent = new Intent(this, ConfirmOrderPizza.class);
        intent.putExtra("Order_a_Pizza","You are ordering a Pizza");
        Extras();
        Log.d("TAG",Extstring);
        intent.putExtra("Pizza_Extra",Extstring);
        intent.putExtra("Pizza_Price",String.valueOf(pizza_price));
        startActivity(intent);
    }
    //set Extras Text
    public void Extras(){
        int tempnum = 0;
        double tempprice = 37.99;
        String string = "Extras:";
        if(checkBox1.isChecked()) {
            string += " Anchovies,";
            tempnum++;
            tempprice += 0.37;
        }
        if(checkBox2.isChecked()) {
            string += " BBQ Sauce,";
            tempnum++;
            tempprice += 0.37;

        }
        if(checkBox3.isChecked()) {
            string += " Basil,";
            tempnum++;
            tempprice += 0.37;
        }
        if(checkBox4.isChecked()) {
            string += " Cheese,";
            tempnum++;
            tempprice += 0.37;
        }
        if(checkBox5.isChecked()) {
            string += " Chicken,";
            tempnum++;
            tempprice += 0.37;
        }
        if(checkBox6.isChecked()) {
            string += " Garlic,";
            tempnum++;
            tempprice += 0.37;
        }
        if(checkBox7.isChecked()) {
            string += " Ham,";
            tempnum++;
            tempprice += 0.37;
        }
        if(checkBox8.isChecked()) {
            string += " Mushroom,";
            tempnum++;
            tempprice += 0.37;
        }
        string = string.substring(0,string.length()-1) + " (" + tempnum + " total " + ")";
        Extstring = string;
        pizza_price = String.format("%.2f", tempprice);
        num = tempnum;
    }
    public void re_ordered_pizza(String string){
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