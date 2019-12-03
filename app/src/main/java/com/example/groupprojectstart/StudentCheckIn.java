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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class StudentCheckIn extends AppCompatActivity implements View.OnClickListener{

    Button buttonImGood, buttonImOkay, buttonImSad;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("CheckInData");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_check_in);

        buttonImGood = findViewById(R.id.buttonStudentImGood);
        buttonImOkay = findViewById(R.id.buttonStudentImOkay);
        buttonImSad = findViewById(R.id.buttonStudentImSad);

        buttonImGood.setOnClickListener(this);
        buttonImOkay.setOnClickListener(this);
        buttonImSad.setOnClickListener(this);

    }

    //Inserting Dummy Navigation for Development Stages
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        //Defining the variable which will be added to firebase
        String CheckInButton = "";

        if (buttonImGood == view){
        CheckInButton = "ImGood";
        }
        else if (buttonImOkay == view){
         CheckInButton = "ImOkay";

        }
        else if (buttonImSad == view) {
           CheckInButton = "ImSad";
            //have students create an appointment
            Intent ImSadIntent = new Intent(this, StudentScheduler.class);
            startActivity(ImSadIntent);
        }
        //Adding the firebase data on the checkin
        ClassCheckIn createcheckinResponse = new ClassCheckIn("","teststudent",CheckInButton,"time1","time2");
        myRef.push().setValue(createcheckinResponse);
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

    }
}
