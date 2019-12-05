package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StudentScheduler extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ArrayList<ClassAppointmentAvailability> availabilities;


    //creating items for StudentScheduler activity page

    Button buttonStudentApptOk;
    Spinner spinnerReason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_scheduler);

        buttonStudentApptOk = findViewById(R.id.buttonStudentApptOk);
        buttonStudentApptOk.setOnClickListener(this);
        spinnerReason = findViewById(R.id.spinnerReason);
        spinnerReason.setOnItemSelectedListener(this);

        List<String> reasonCodes = new ArrayList<String>();
        reasonCodes.add("School Work");
        reasonCodes.add("Relationships");
        reasonCodes.add("Mental Wellness");

        ArrayAdapter dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, reasonCodes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); spinnerReason.setAdapter(dataAdapter);
    }

    @Override
    //Connecting button navigation for OK button
    public void onClick(View view) {
        if (buttonStudentApptOk == view){
            Intent StudentApptOkIntent = new Intent(this, StudentApptConfirmation.class);
            startActivity(StudentApptOkIntent);
        }
    }

    //Inserting Dummy Navigation for Development Stages
    // Later replaced with Student Menu @Amy
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
            //I linked it back to home since we don't have a settings page
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String reasonSelection = adapterView.getItemAtPosition(i).toString();

        //need to assign Appointment reason variable the value selected
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
