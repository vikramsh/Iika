package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckOutGadgetActivity extends AppCompatActivity {

    Button final_confirm_checkoutGadget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_gadget);

        final_confirm_checkoutGadget = findViewById(R.id.final_confirm_checkoutGadget);
        final_confirm_checkoutGadget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckOutGadgetActivity.this,OrderConfermActivity.class);
                startActivity(i);
            }
        });
    }
}