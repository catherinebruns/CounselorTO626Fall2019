package com.example.groupprojectstart;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassCounselorAvailability extends RecyclerView.Adapter<ClassCounselorAvailability.ViewHolder>{
    private ArrayList<ClassAppointmentAvailability> ClassAppointmentAvailability;
    private Context mContext;

    ClassCounselorAvailability(ArrayList<ClassAppointmentAvailability> availabilities, Context mContext){
        this.ClassAppointmentAvailability = availabilities;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_calendaravailability, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textViewDate.setText(ClassAppointmentAvailability.get(position).date);
        holder.textViewTime.setText(ClassAppointmentAvailability.get(position).time);
        holder.ParentLayout.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, ClassAppointmentAvailability.get(position).date, Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, ClassAppointmentAvailability.get(position).time, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return ClassAppointmentAvailability.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDate, textViewTime;
        ImageView ImageView;
        RelativeLayout ParentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            ImageView = itemView.findViewById(R.id.imageView);
            ParentLayout = itemView.findViewById(R.id.parent_layout);

        }


        }
    }
