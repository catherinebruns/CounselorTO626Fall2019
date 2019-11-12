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

public class StudentHome extends AppCompatActivity implements View.OnClickListener {

    Button buttonStudentCheckIn, buttonStudentScheduleAppt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        buttonStudentCheckIn = findViewById(R.id.buttonStudentCheckIn);
        buttonStudentScheduleAppt = findViewById(R.id.buttonStudentScheduleAppt);

        buttonStudentCheckIn.setOnClickListener(this);
        buttonStudentScheduleAppt.setOnClickListener(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.studentmenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemHome) {
            Intent HomeIntent = new Intent(this, StudentHome.class);
            startActivity(HomeIntent);
        } else if (item.getItemId() == R.id.itemSettings){
            //I linked it back to home since we don't have a settings page
            Intent SettingsIntent = new Intent(this, StudentHome.class);
            startActivity(SettingsIntent);
        }
        return super.onOptionsItemSelected(item);
    }


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
}
