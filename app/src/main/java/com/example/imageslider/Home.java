package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class Home extends AppCompatActivity {
    
               SliderView sliderView;
               int[] images = {
                       R.drawable.f1,
                       R.drawable.f2,
                       R.drawable.f3,
                       R.drawable.f4,
                       R.drawable.f5,
               };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.imageSlider);

        sliderAdapter sliderAdapter= new sliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.startAutoCycle();
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                       return true;
                    case R.id.concert:
                        startActivity(new Intent(getApplicationContext(),Concert.class));
                        overridePendingTransition(0,0);
                       return true;
                    case R.id.movie:
                        startActivity(new Intent(getApplicationContext(),Movie.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.match:
                        startActivity(new Intent(getApplicationContext(),Match.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}