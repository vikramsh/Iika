package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SmartDevicesDetailsActivity extends AppCompatActivity {

    CardView smartdevicedetails;
    Button btnAddToCartsmartdeviced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_devices_details);

        smartdevicedetails = findViewById(R.id.smartdevicedetails);
        btnAddToCartsmartdeviced = findViewById(R.id.btnAddToCartsmartdeviced);

        btnAddToCartsmartdeviced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SmartDevicesDetailsActivity.this, CheckOutSmartDevicesActivity.class);
                startActivity(i);
            }
        });
    }
}