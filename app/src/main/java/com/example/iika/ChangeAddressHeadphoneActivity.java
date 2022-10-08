package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangeAddressHeadphoneActivity extends AppCompatActivity {

    Button changeaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address_headphone);

        changeaddress = findViewById(R.id.changeaddress);

        changeaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeAddressHeadphoneActivity.this,CheckOutHeadphoneActivity.class);
                startActivity(intent);

            }
        });

    }
}