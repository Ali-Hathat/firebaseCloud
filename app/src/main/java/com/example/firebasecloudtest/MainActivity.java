package com.example.firebasecloudtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnFood;
    Button btnLaptops;
    Button btnSmartphones;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle foodBundle = new Bundle();
        foodBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "foodBtn");
        foodBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Food");
        foodBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Bundle laptopsBundle = new Bundle();
        laptopsBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "laptopsBtn");
        laptopsBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Laptops");
        laptopsBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Bundle phoneBundle = new Bundle();
        phoneBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "laptopsBtn");
        phoneBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Smart Phones");
        phoneBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");


        Intent foodIntent = new Intent(this, FoodActivity.class);
        Intent laptopIntent = new Intent(this, LaptopsActivity.class);
        Intent smartphonesIntent = new Intent(this, SmartphonesActivity.class);

        btnFood = findViewById(R.id.foodBtn);
        btnLaptops = findViewById(R.id.laptopsBtn);
        btnSmartphones = findViewById(R.id.smartphonesBtn);

        btnFood.setOnClickListener(v -> {
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, foodBundle);
            startActivity(foodIntent);
        });
        btnLaptops.setOnClickListener(v -> {
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, laptopsBundle);
            startActivity(laptopIntent);
        });
        btnSmartphones.setOnClickListener(v -> {
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, phoneBundle);
            startActivity(smartphonesIntent);
        });




    }




}
