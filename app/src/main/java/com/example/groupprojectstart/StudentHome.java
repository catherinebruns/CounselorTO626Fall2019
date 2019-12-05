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

public class StudentHome extends AppCompatActivity implements View.OnClickListener {

    //creating items for StudentHome Activity page
    //student's name will be showed in textViswStudentWelcome2
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

    //moving to studentCheckin or studentSchedule Appointment
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

    //Inserting Dummy Navigation for Development Stages >>> replaces with counselor menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dummymenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.CounselorAvailability) {
            Intent HomeIntent = new Intent(this, CounselorAvailability.class);
            startActivity(HomeIntent);
        }
        else if (item.getItemId() == R.id.CounselorCheckInManager){
            Intent SettingsIntent = new Intent(this, CounselorCheckInManager.class);
            startActivity(SettingsIntent);
        }
        else if (item.getItemId() == R.id.CounselorHome){
            Intent CheckInManagerIntent = new Intent(this,CounselorHome.class);
            startActivity(CheckInManagerIntent);
        }
        else if (item.getItemId() == R.id.MainActivity){
            Intent MyAvailabilityIntent = new Intent(this, MainActivity.class);
            startActivity(MyAvailabilityIntent);
        }
        else if (item.getItemId() == R.id.StudentApptConfirmation){
            Intent MyAvailabilityIntent = new Intent(this, StudentApptConfirmation.class);
            startActivity(MyAvailabilityIntent);
        }

        else if (item.getItemId() == R.id.StudentCheckIn){
            Intent MyAvailabilityIntent = new Intent(this, StudentCheckIn.class);
            startActivity(MyAvailabilityIntent);
        }

        else if (item.getItemId() == R.id.StudentHome){
            Intent MyAvailabilityIntent = new Intent(this, StudentHome.class);
            startActivity(MyAvailabilityIntent);
        }

        else if (item.getItemId() == R.id.StudentScheduler){
            Intent MyAvailabilityIntent = new Intent(this, StudentScheduler.class);
            startActivity(MyAvailabilityIntent);
        }
        else if (item.getItemId() == R.id.Register){
            Intent RegisterIntent = new Intent(this, RegisterActivity.class);
            startActivity(RegisterIntent);
        }
        else if (item.getItemId() == R.id.RegisterStudent){
            Intent RegisterStudentIntent = new Intent(this, RegisterStudentActivity.class);
            startActivity(RegisterStudentIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
