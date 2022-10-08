package com.example.iika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeAddressWirelessActivity extends AppCompatActivity {

    Button changeaddresswireless;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address_headphone);

        changeaddresswireless = findViewById(R.id.changeaddresswireless);

        changeaddresswireless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeAddressWirelessActivity.this,CheckoutWirelessActivity.class);
                startActivity(intent);

            }
        });

    }
}