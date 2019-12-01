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
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //why do we have two separate options for button sign in/up here?
    Button buttonStudentSignIn,buttonStudentSignUp;
    Button buttonCounselorSignIn,buttonCounselorSignUp;
    EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStudentSignIn = findViewById(R.id.buttonStudentSignIn);
        buttonCounselorSignIn = findViewById(R.id.buttonCounselorSignIn);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUsername = findViewById(R.id.editTextUsername);

        buttonStudentSignIn.setOnClickListener(this);
        buttonCounselorSignIn.setOnClickListener(this);
        buttonCounselorSignUp.setOnClickListener(this);
        buttonStudentSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
//need to connect these to firebase

        //Connecting 4 buttons on Main Activity Page to log in or sign up
        if(buttonStudentSignIn == view){
            Intent StudentSignInIntent = new Intent(this,StudentHome.class);
            startActivity(StudentSignInIntent);

        }else if(buttonStudentSignUp == view) {
            Intent StudentSignUpIntent = new Intent(this, RegisterStudentActivity.class);
            startActivity(StudentSignUpIntent);

        }else if(buttonCounselorSignIn == view) {
            Intent CounselorSignInIntent = new Intent(this, CounselorHome.class);
            startActivity(CounselorSignInIntent);

        }else if(buttonCounselorSignUp == view) {
            Intent CounselorSignUpIntent = new Intent(this, RegisterActivity.class);
            startActivity(CounselorSignUpIntent);
        }
        if (editTextUsername.getText().toString().trim().equalsIgnoreCase("")) {
            editTextUsername.setError("This field can not be blank");
        }

        if (editTextPassword.getText().toString().trim().equalsIgnoreCase("")) {
            editTextPassword.setError("This field can not be blank");
        }

    }



//Inserting Dummy Navigation for Development Stages  <<< Menu is not necessary in main page
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



}
