package com.example.iika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GadgetsDetailsActivity extends AppCompatActivity {

    CardView gadgets;
    Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets_details);

        gadgets = findViewById(R.id.gadgets);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GadgetsDetailsActivity.this, CheckOutGadgetActivity.class);
                startActivity(i);
            }
        });
    }
}