package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StudentHome extends AppCompatActivity implements View.OnClickListener {

    //creating items for StudentHome Activity page
    //student's name will be showed in textViewStudentWelcome2
    Button buttonStudentCheckIn, buttonStudentScheduleAppt;
    TextView textViewStudentWelcome,textViewStudentWelcome2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        buttonStudentCheckIn = findViewById(R.id.buttonStudentCheckIn);
        buttonStudentScheduleAppt = findViewById(R.id.buttonStudentScheduleAppt);

        buttonStudentCheckIn.setOnClickListener(this);
        buttonStudentScheduleAppt.setOnClickListener(this);

    }

    //home page prompts studentCheckin or studentSchedule Appointment
    @Override
    public void onClick(View view) {
        if (buttonStudentCheckIn == view){
            Intent StudentCheckInIntent = new Intent(this, StudentCheckIn.class);
            startActivity(StudentCheckInIntent);
        }
        else if (buttonStudentScheduleAppt == view){
            Intent StudentScheduleApptIntent = new Intent(this, StudentScheduler.class);
            startActivity(StudentScheduleApptIntent);
        }
    }

    //student specific menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.studentmenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemHome) {
            Toast.makeText(this, "You are on the home page", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.itemScheduleAppt) {
            Intent ScheduleIntent = new Intent(this, StudentScheduler.class);
            startActivity(ScheduleIntent);
        }
        else if (item.getItemId() == R.id.itemCheckin) {
            Intent CheckinIntent = new Intent(this, StudentCheckIn.class);
            startActivity(CheckinIntent);
        }
        else if (item.getItemId() == R.id.itemStudentLogout){
            Intent LogoutIntent = new Intent(this, MainActivity.class);
            startActivity(LogoutIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
