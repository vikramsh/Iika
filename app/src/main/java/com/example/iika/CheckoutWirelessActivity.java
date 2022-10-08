package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutWirelessActivity extends AppCompatActivity {

    Button final_confirm_wireless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_wireless);

        final_confirm_wireless = findViewById(R.id.final_confirm_wireless);
        final_confirm_wireless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckoutWirelessActivity.this,OrderConfermActivity.class);
                startActivity(i);
            }
        });
    }
}