package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Concert extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert);
        bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.concert);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.concert:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(), Movie.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.match:
                        startActivity(new Intent(getApplicationContext(), Match.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
        }
    }

