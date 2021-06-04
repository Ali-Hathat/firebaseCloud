package com.example.firebasecloudtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class LaptopsActivity extends AppCompatActivity {
    Button btnHP;
    Button btnMsi;
    Button btnDELL;
    private FirebaseAnalytics lFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptops);
        lFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle hpBundle = new Bundle();
        hpBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btnHp");
        hpBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "HP Laptop");
        hpBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Bundle dellBundle = new Bundle();
        dellBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btnDell");
        dellBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "DELL Laptop");
        dellBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Bundle msiBundle = new Bundle();
        msiBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btnMsi");
        msiBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "MSI Laptop");
        msiBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Intent HpIntent = new Intent(this, HpLaptop.class);
        Intent MsiIntent = new Intent(this, MsiLaptop.class);
        Intent DellIntent = new Intent(this, DellLaptop.class);

        btnHP = findViewById(R.id.btnHp);
        btnMsi = findViewById(R.id.btnMsi);
        btnDELL = findViewById(R.id.btnDell);

        btnHP.setOnClickListener(v -> {
            lFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, hpBundle);
            startActivity(HpIntent);
        });
        btnMsi.setOnClickListener(v -> {
            lFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, msiBundle);
            startActivity(MsiIntent);
        });
        btnDELL.setOnClickListener(v -> {
            lFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, dellBundle);
            startActivity(DellIntent);
        });
    }
}