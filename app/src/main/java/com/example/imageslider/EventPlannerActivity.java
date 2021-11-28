package com.example.imageslider;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imageslider.model.Category;
import com.example.imageslider.model.EventC;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class EventPlannerActivity extends AppCompatActivity {
    int categoryIndex = 0;
    ProgressDialog progress;
    String creator;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_planner);
        FirebaseUser user = State.getUser();

        TextView userNameField = findViewById(R.id.userNameTextView);

        if( user!= null)
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
        LinearLayout categoryContainer = createEvents.findViewById(R.id.newCategoryContainer);

        View categoryLayout = inflater.inflate(R.layout.category_layout, null);
        categoryLayout.setId(categoryIndex++);
        categoryContainer.addView(categoryLayout);

        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View categoryLayout = inflater.inflate(R.layout.category_layout, null);
                categoryLayout.setId(categoryIndex++);
                categoryContainer.addView(categoryLayout);
            }
        });
        creator = user==null?"general":user.getDisplayName();

        Button publishB = createEvents.findViewById(R.id.publish);
        publishB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = new ProgressDialog(EventPlannerActivity.this);
                progress.setTitle("Loading");
                progress.setMessage("Wait while loading...");
                progress.setCanceledOnTouchOutside(false); // disable dismiss by tapping outside of the dialog
                progress.show();


                EditText eventName = createEvents.findViewById(R.id.eventName);
                EditText eventLocation = createEvents.findViewById(R.id.eventLocation);
                EditText eventDate = createEvents.findViewById(R.id.eventDate);


                EventC eventC = new EventC();
                eventC.setName(eventName.getText().toString());
                eventC.setDate(eventDate.getText().toString());
                eventC.setLocation(eventLocation.getText().toString());

                eventC.setCreatedAt(Timestamp.now());
                eventC.setUpdatedAt(Timestamp.now());

                for (int i = (categoryIndex - 1); i >= 0; --i) {
                    EditText categoryName = categoryContainer.findViewById(i).findViewById(R.id.categoryName);
                    EditText numberOfTickets = categoryContainer.findViewById(i).findViewById(R.id.numberOfTicket);
                    EditText categoryPrice = categoryContainer.findViewById(i).findViewById(R.id.categoryPrice);
                    Category category = new Category();
                    category.setName(categoryName.getText().toString());
                    category.setNumberOfTicket(Integer.parseInt(numberOfTickets.getText().toString()));
                    category.setPrice(Integer.parseInt(categoryPrice.getText().toString()));

                    eventC.addCategory(category);
                }
                eventC.print();


                int month = eventC.getCreatedAt().toDate().getMonth() + 1;
                db.collection("data").document(creator).collection("events").add(eventC)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("TAG", "DocumentSnapshot written with ID: " + documentReference.getId());
                                progress.dismiss();
                                createEventPopup.dismiss();
                                Toast.makeText(EventPlannerActivity.this, "success", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error adding document", e);
                                progress.dismiss();
                                Toast.makeText(EventPlannerActivity.this, "save data fail", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });




        // d
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
    }

}