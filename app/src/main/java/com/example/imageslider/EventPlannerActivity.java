package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
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


        LayoutInflater inflater = (LayoutInflater) EventPlannerActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View  createEvents = inflater.inflate(R.layout.create_event_popup, null);
        PopupWindow createEventPopup = new PopupWindow(createEvents, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventPopup.showAsDropDown(createEvents,0,0);
                createEventPopup.setFocusable(true);

            }
        });
        Button closeButton = createEvents.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createEventPopup.dismiss();
            }
        });
        Button addCategoryButton = createEvents.findViewById(R.id.addNewCategory);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}