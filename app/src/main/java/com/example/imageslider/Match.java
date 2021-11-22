package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Match extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.match);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.match:
                        return true;
                    case R.id.concert:
                        startActivity(new Intent(getApplicationContext(),Concert.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(),Movie.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}