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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    //creating items for Register Activity page
  //  EditText editRegisterTitle, editRegisterRoomNumber, ;
    EditText editRegisterFirstName, editRegisterPassword, editRegisterEmail, editRegisterLastName;
    Button buttonRegisterSubmit;

    private FirebaseAuth mAuth;
    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReference("CounselorID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    buttonRegisterSubmit = findViewById(R.id.buttonRegisterSubmit);
    buttonRegisterSubmit.setOnClickListener(this);

    editRegisterEmail = findViewById(R.id.editRegisterEmail);
    editRegisterFirstName = findViewById(R.id.editRegisterFirstName);
    editRegisterLastName = findViewById(R.id.editRegisterLastName);
   // editRegisterRoomNumber = findViewById(R.id.editRegisterRoomNumber);
  //  editRegisterTitle = findViewById(R.id.editRegisterTitle);
    editRegisterPassword = findViewById(R.id.editRegisterPassword);

    mAuth = FirebaseAuth.getInstance();

    }

    //Register function of Counselor
    //This page doesn't work, Need to be fixed.
    //Title should be chose from pull down if possible???
    @Override
    public void onClick(View view) {
        //validate(editRegisterEmail.getText(), editRegisterFirstName.getText(),
        //        editRegisterLastName.getText(), editRegisterRoomNumber.getText(),
        //        editRegisterTitle.getText());

        //Registration function of Counselor @Rohan
        mAuth.createUserWithEmailAndPassword(editRegisterEmail.getText().toString(), editRegisterPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //if login is successful
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            //creating a new intent to send you back to the main activity once registration is successful
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);



                        } else {
                            //if login is unsuccessful
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }

    //Inserting Dummy Navigation for Development Stages >>>> will be removed from this page later
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
