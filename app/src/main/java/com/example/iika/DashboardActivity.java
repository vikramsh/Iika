package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    CardView headphones,wireless,smartdevices,gadgets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        headphones = (CardView) findViewById(R.id.headphones);
        wireless = (CardView) findViewById(R.id.wireless);
        smartdevices = (CardView) findViewById(R.id.smartdevices);
        gadgets = (CardView) findViewById(R.id.gadgets);

        headphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Headphones", Toast.LENGTH_SHORT).show();
            }
        });

        wireless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Wireless", Toast.LENGTH_SHORT).show();
            }
        });

        smartdevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Smart Devices", Toast.LENGTH_SHORT).show();
            }
        });

        gadgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Gadgets", Toast.LENGTH_SHORT).show();
            }
        });
    }
}