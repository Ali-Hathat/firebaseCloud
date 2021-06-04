package com.example.firebasecloudtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class SmartphonesActivity extends AppCompatActivity {
    Button btnSamsung;
    Button btnApple;
    Button btnWindows;
    private FirebaseAnalytics sFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphones);
        sFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle samsungBundle = new Bundle();
        samsungBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btnSamsung");
        samsungBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Samsung Phone");
        samsungBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Bundle appleBundle = new Bundle();
        appleBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btnApple");
        appleBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Apple Phone");
        appleBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        Bundle windowsBundle = new Bundle();
        windowsBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "btnWindows");
        windowsBundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Windows Phone");
        windowsBundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");


        Intent samsungIntent = new Intent(this, SamsungActivity.class);
        Intent appleIntent = new Intent(this, AppleActivity.class);
        Intent windowsIntent = new Intent(this, WindowsActivity.class);

        btnSamsung = findViewById(R.id.btnSamsung);
        btnApple = findViewById(R.id.btnApple);
        btnWindows = findViewById(R.id.btnWindows);

        btnSamsung.setOnClickListener(v -> {
            sFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, samsungBundle);
            startActivity(samsungIntent);
        });
        btnApple.setOnClickListener(v -> {
            sFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, appleBundle);
            startActivity(appleIntent);
        });
        btnWindows.setOnClickListener(v -> {
            sFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, windowsBundle);
            startActivity(windowsIntent);
        });
    }
}