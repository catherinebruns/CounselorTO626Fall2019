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

    Button buttonSignIn, buttonSignUp, buttonForgotPassword;
    Button buttonStudentSignIn,buttonStudentSignUp;
    Button buttonCounselorSignIn,buttonCouselorSignUp;
    EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignIn = findViewById(R.id.buttonStudentSignIn);
        buttonSignUp = findViewById(R.id.buttonStudentSignUp);
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUsername = findViewById(R.id.editTextUsername);

        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
        buttonForgotPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //need if statements for determining student or counselor account
        // need to connect the register page after creating register page

        if(view == buttonStudentSignIn){
            Intent StudentSignInIntent = new Intent(this,StudentHome.class);
            startActivity(StudentSignInIntent);

        }else if(view == buttonStudentSignUp) {
            Intent StudentSignUpIntent = new Intent(this, StudentHome.class);
            startActivity(StudentSignUpIntent);

        }else if(view == buttonCounselorSignIn) {
            Intent CounselorSignInIntent = new Intent(this, CounselorHome.class);
            startActivity(CounselorSignInIntent);

        }else if(view == buttonCouselorSignUp) {
            Intent CounselorSignUpIntent = new Intent(this, CounselorHome.class);
            startActivity(CounselorSignUpIntent);

        }else if(view == buttonForgotPassword) {
            Intent ForgotPasswordIntent = new Intent(this, MainActivity.class);
            startActivity(ForgotPasswordIntent);
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
