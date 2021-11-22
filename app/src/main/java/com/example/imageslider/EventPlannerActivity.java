package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseUser;

public class EventPlannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_planner);
        FirebaseUser user = State.getUser();

        TextView userNameField = findViewById(R.id.userNameTextView);

        userNameField.setText(user.getDisplayName());

        FloatingActionButton addEvent = findViewById(R.id.addMenuItem);


        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}