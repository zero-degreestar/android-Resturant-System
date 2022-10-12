package com.example.resaurant_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Burger(View view) {
        Intent intent = new Intent(this,OrderBurger.class);
        startActivity(intent);
    }

    public void Pizza(View view) {
        Intent intent = new Intent(this,OrderPizza.class);
        startActivity(intent);
    }

    public void IceCream(View view) {
        Intent intent = new Intent(this,OrderIcecream.class);
        startActivity(intent);
    }

    public void history(View view) {
        Intent intent = new Intent(this,history.class);
        startActivity(intent);
    }
}