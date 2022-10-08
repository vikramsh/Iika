package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HeadPhoneDetailsActivity extends AppCompatActivity {

    CardView headphonedetails;
    Button btnAddToCartheadphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headphone_details);

        headphonedetails = findViewById(R.id.headphonedetails);
        btnAddToCartheadphone = findViewById(R.id.btnAddToCartheadphone);

        btnAddToCartheadphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HeadPhoneDetailsActivity.this, CheckOutHeadphoneActivity.class);
                startActivity(i);
            }
        });
    }
}