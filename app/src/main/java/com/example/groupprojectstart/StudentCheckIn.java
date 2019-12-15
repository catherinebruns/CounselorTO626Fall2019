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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class StudentCheckIn extends AppCompatActivity implements View.OnClickListener{

    //creating items for Student CheckIn Activity page

    Button buttonImGood, buttonImOkay, buttonImSad;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("CheckInData");
    private FirebaseAuth mAuth;

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
        mAuth = FirebaseAuth.getInstance();

    }

    // Adding the student feedback >>> will be showed in Counselor home Activity
    @Override
    public void onClick(View view) {
        //Defining the variable which will be added to firebase
        String CheckInButton = "";

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();

        if (buttonImGood == view){
            CheckInButton = "ImGood";
            Intent StudentHome = new Intent(this, StudentHome.class);
            startActivity(StudentHome);
        }
        else if (buttonImOkay == view){
            CheckInButton = "ImOkay";
            Intent StudentHome = new Intent(this, StudentHome.class);
            startActivity(StudentHome);

        }
        else if (buttonImSad == view) {
            CheckInButton = "ImSad";
            //have students create an appointment
            Intent ImSadIntent = new Intent(this, StudentScheduler.class);
            startActivity(ImSadIntent);
        }
        //Adding the firebase data on the checkin

        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        ClassCheckIn createcheckinResponse = new ClassCheckIn("",email,CheckInButton,"",currentHour+":"+currentMinute);
        myRef.push().setValue(createcheckinResponse);
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

    }

    //student specific menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.studentmenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemCheckin) {
            Toast.makeText(this, "You are on the check in page", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.itemScheduleAppt) {
            Intent ScheduleIntent = new Intent(this, StudentScheduler.class);
            startActivity(ScheduleIntent);
        }
        else if (item.getItemId() == R.id.itemHome) {
            Intent HomeIntent = new Intent(this, StudentHome.class);
            startActivity(HomeIntent);
        }
        else if (item.getItemId() == R.id.itemStudentLogout){
            Intent LogoutIntent = new Intent(this, MainActivity.class);
            startActivity(LogoutIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
