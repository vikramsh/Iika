package com.example.iika;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    CardView headphones,wireless,smartdevices,gadgets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {

                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Home is Clicked", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_my_account:
                        Toast.makeText(MainActivity.this, "Account is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_my_order:
                        Toast.makeText(MainActivity.this, "Order is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_address:
                        Toast.makeText(MainActivity.this, "Address is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_about_us:
                        Toast.makeText(MainActivity.this, "About is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_login:
                        Toast.makeText(MainActivity.this, "Login is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_contact_us:
                        Toast.makeText(MainActivity.this, "Contact is clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_privacy_policy:
                    Toast.makeText(MainActivity.this, "Privacy Policy us is Clicked",Toast.LENGTH_SHORT).show();break;
                    default:
                    return true;

                }
                return true;
            }
        });

        headphones = (CardView) findViewById(R.id.headphones);
        wireless = (CardView) findViewById(R.id.wireless);
        smartdevices = (CardView) findViewById(R.id.smartdevices);
        gadgets = (CardView) findViewById(R.id.gadgets);

        headphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Headphones", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, HeadPhoneDetailsActivity.class);
                startActivity(i);
            }
        });

        wireless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wireless", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, WirelessDetailsActivity.class);
                startActivity(i);
            }
        });

        smartdevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Smart Devices", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SmartDevicesDetailsActivity.class);
                startActivity(i);
            }
        });

        gadgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Gadgets", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, GadgetsDetailsActivity.class);
                startActivity(i);
            }
        });


    }
}