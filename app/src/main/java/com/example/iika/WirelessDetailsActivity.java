package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WirelessDetailsActivity extends AppCompatActivity {

    CardView wirelessDetails;
    Button btnAddToCartWireless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wireless_details);

        wirelessDetails = findViewById(R.id.wirelessDetails);
        btnAddToCartWireless = findViewById(R.id.btnAddToCartWireless);

        btnAddToCartWireless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WirelessDetailsActivity.this, CheckoutWirelessActivity.class);
                startActivity(i);
            }
        });



    }
}