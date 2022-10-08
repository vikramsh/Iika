package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckOutHeadphoneActivity extends AppCompatActivity {

    Button final_confirm_hedphone;
    Button changeaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_headphone);

        changeaddress = findViewById(R.id.changeaddress);
        final_confirm_hedphone = findViewById(R.id.final_confirm_hedphone);
        final_confirm_hedphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckOutHeadphoneActivity.this,OrderConfermActivity.class);
                startActivity(i);
            }
        });
        changeaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckOutHeadphoneActivity.this, ChangeAddressHeadphoneActivity.class);
                startActivity(i);
            }
        });
    }
}