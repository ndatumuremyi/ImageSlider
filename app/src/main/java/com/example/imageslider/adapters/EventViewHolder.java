package com.example.imageslider.adapters;


import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageslider.R;
import com.example.imageslider.model.EventC;


public class EventViewHolder extends RecyclerView.ViewHolder {
    TextView name, location, date;
    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.eventName);
        location =(TextView)itemView.findViewById(R.id.eventLocation);
        date = itemView.findViewById(R.id.eventDate);
    }
    public void bind(final EventC Event){
        name.setText(Event.getName());
        location.setText(Event.getLocation());
        date.setText(Event.getDate());
    }
}
