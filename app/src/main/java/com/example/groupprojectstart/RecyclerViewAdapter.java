package com.example.groupprojectstart;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<ClassAppointmentSlots> appointmentSlots;
    private Context mContext;

    RecyclerViewAdapter(ArrayList<ClassAppointmentSlots> appointmentSlots, Context mContext){
        this.appointmentSlots = appointmentSlots;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_calendaravailability, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textViewApptStart.setText(appointmentSlots.get(position).AppointmentStart);
        holder.textViewCounselorEmail.setText(appointmentSlots.get(position).AppointmentCounselorUserID);
    }


    @Override
    public int getItemCount() {

        return appointmentSlots.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewApptStart, textViewCounselorEmail;
        RelativeLayout ParentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewApptStart = itemView.findViewById(R.id.textViewApptStart);
            textViewCounselorEmail = itemView.findViewById(R.id.textViewCounselorEmail);
            ParentLayout = itemView.findViewById(R.id.parent_layout);

        }


        }
    }
