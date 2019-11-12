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

public class StudentApptConfirmation extends AppCompatActivity implements View.OnClickListener{

    Button buttonStudentApptConfirmationExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_appt_confirmation);

        buttonStudentApptConfirmationExit = findViewById(R.id.buttonStudentApptConfirmationExit);

        buttonStudentApptConfirmationExit.setOnClickListener(this);

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
        if (buttonStudentApptConfirmationExit == view);
        //linking this back to the Student home page
        Intent StudentApptConfirmationExitIntent = new Intent(this, StudentHome.class);
        startActivity(StudentApptConfirmationExitIntent);

    }
}
