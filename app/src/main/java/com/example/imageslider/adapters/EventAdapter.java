package com.example.imageslider.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageslider.R;
import com.example.imageslider.model.EventC;

import java.util.List;


public class EventAdapter  extends RecyclerView.Adapter<EventViewHolder> {
    List<EventC> Events;
    EventViewHolder EventViewHolder;

    public EventAdapter(List<EventC> Events) {
        this.Events = Events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_of_event,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        final EventC Event=Events.get(position);
        holder.bind(Event);
        EventViewHolder=holder;
    }

    @Override
    public int getItemCount() {
        return Events.size();
    }
}
