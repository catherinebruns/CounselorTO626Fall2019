package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editRegisterTitle, editRegisterRoomNumber, editRegisterEmail, editRegisterLastName;
    EditText editRegisterFirstName;
    Button buttonRegisterSubmit;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("CounselorID");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    buttonRegisterSubmit = findViewById(R.id.buttonRegisterSubmit);
    buttonRegisterSubmit.setOnClickListener(this);

    editRegisterEmail = findViewById(R.id.editRegisterEmail);
    editRegisterFirstName = findViewById(R.id.editRegisterFirstName);
    editRegisterLastName = findViewById(R.id.editRegisterLastName);
    editRegisterRoomNumber = findViewById(R.id.editRegisterRoomNumber);
    editRegisterTitle = findViewById(R.id.editRegisterTitle);

    }

    @Override
    public void onClick(View view) {
        //validate(editRegisterEmail.getText(), editRegisterFirstName.getText(),
        //        editRegisterLastName.getText(), editRegisterRoomNumber.getText(),
        //        editRegisterTitle.getText());

        //)
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
}
