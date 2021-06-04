package com.example.firebasecloudtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity {

    Button btnPizza;
    Button btnHamburger;
    Button btnFries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Intent hamIntent = new Intent(this, HamburgersActivity.class);
        Intent friesIntent = new Intent(this, FriesActivity.class);
        Intent pizzaIntent = new Intent(this, PizzaActivity.class);

        btnPizza = findViewById(R.id.btnPizza);
        btnFries = findViewById(R.id.btnFrenchFries);
        btnHamburger = findViewById(R.id.btnHamburger);

        btnHamburger.setOnClickListener(v -> {
            startActivity(hamIntent);
        });
        btnFries.setOnClickListener(v -> {
            startActivity(friesIntent);
        });
        btnPizza.setOnClickListener(v -> {
            startActivity(pizzaIntent);
        });
    }
}