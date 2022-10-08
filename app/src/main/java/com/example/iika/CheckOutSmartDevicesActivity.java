package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckOutSmartDevicesActivity extends AppCompatActivity {

    Button final_confirm_smartdevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_smart_devices);

        final_confirm_smartdevice = findViewById(R.id.final_confirm_smartdevice);
        final_confirm_smartdevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckOutSmartDevicesActivity.this,OrderConfermActivity.class);
                startActivity(i);
            }
        });
    }
}