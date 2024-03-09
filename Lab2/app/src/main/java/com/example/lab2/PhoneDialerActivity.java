package com.example.lab2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PhoneDialerActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bStar, bDiez;

    private class ButtonPushListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
           if (view.getId() == R.id.button1) {
               Log.d("BUTTON", "1");
           } else if (view.getId() == R.id.button2) {
               Log.d("BUTTON", "2");
           } else if (view.getId() == R.id.button3) {
               Log.d("BUTTON", "3");
           } else if (view.getId() == R.id.button4) {
               Log.d("BUTTON", "4");
           } else if (view.getId() == R.id.button5) {
               Log.d("BUTTON", "5");
           } else if (view.getId() == R.id.button6) {
               Log.d("BUTTON", "6");
           } else if (view.getId() == R.id.button7) {
               Log.d("BUTTON", "7");
           } else if (view.getId() == R.id.button8) {
               Log.d("BUTTON", "8");
           } else if (view.getId() == R.id.button9) {
               Log.d("BUTTON", "9");
           } else if (view.getId() == R.id.button0) {
               Log.d("BUTTON", "0");
           } else if (view.getId() == R.id.buttonStar) {
               Log.d("BUTTON", "*");
           } else if (view.getId() == R.id.buttonDiez) {
               Log.d("BUTTON", "#");
           }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phone_dialer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ButtonPushListener buttonPushListener = new ButtonPushListener();
        setButtons();
        setListenerToButtons(buttonPushListener);
    }

    private void setButtons() {
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        bStar = findViewById(R.id.buttonStar);
        bDiez = findViewById(R.id.buttonDiez);
    }

    private void setListenerToButtons(ButtonPushListener buttonPushListener) {
        b1.setOnClickListener(buttonPushListener);
        b2.setOnClickListener(buttonPushListener);
        b3.setOnClickListener(buttonPushListener);
        b4.setOnClickListener(buttonPushListener);
        b5.setOnClickListener(buttonPushListener);
        b6.setOnClickListener(buttonPushListener);
        b7.setOnClickListener(buttonPushListener);
        b8.setOnClickListener(buttonPushListener);
        b9.setOnClickListener(buttonPushListener);
        b0.setOnClickListener(buttonPushListener);
        bStar.setOnClickListener(buttonPushListener);
        bDiez.setOnClickListener(buttonPushListener);
    }
}