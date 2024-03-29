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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterStudentActivity extends AppCompatActivity implements View.OnClickListener {

    //creating items for RegisterStudent Activity page
    //This activity is not currently being used.
    // We are using the Register Activity for both Students and counselors

    Button buttonStudentRegisterSubmit;
    EditText editStudentRegisterFirstName, editStudentRegisterLastName;
    EditText editStudentRegisterPassword, editStudentRegisterEmail;

    //CEB synced to firebase
    FirebaseAuth mAuth;
    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myref = database.getReference("StudentID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        buttonStudentRegisterSubmit = findViewById(R.id.buttonStudentRegisterSubmit);
        editStudentRegisterFirstName = findViewById(R.id.editRegisterFirstName);
        editStudentRegisterLastName = findViewById(R.id.editRegisterLastName);
        editStudentRegisterPassword = findViewById(R.id.editRegisterPassword);
        editStudentRegisterEmail = findViewById(R.id.editStudentRegisterEmail);

        buttonStudentRegisterSubmit.setOnClickListener(this);

        //CEB Initialized firebase auth
        mAuth = FirebaseAuth.getInstance();

    }

    //Registration function of student
    @Override
    public void onClick(View view) {
        //validate(editRegisterEmail.getText(), editRegisterFirstName.getText(),
        //        editRegisterLastName.getText(), editRegisterRoomNumber.getText(),
        //        editRegisterTitle.getText());

        String email = editStudentRegisterEmail.getText().toString().trim();
        String password = editStudentRegisterPassword.getText().toString().trim();


        //Registration function of Counselor @Rohan
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //if login is successful
                            Toast.makeText(RegisterStudentActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            //creating a new intent to send you back to the main activity once registration is successful
                            Intent intent = new Intent(RegisterStudentActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            //if login is unsuccessful
                            Toast.makeText(RegisterStudentActivity.this, "Failed", Toast.LENGTH_SHORT).show();


                        }
                    }
                });

    /*    mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterStudentActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterStudentActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });*/



      /*  //need to figure out how to have two separate authentications
        mAuth.createUserWithEmailAndPassword(editStudentRegisterEmail.getText().toString(), editStudentRegisterPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //if login is successful

                            Toast.makeText(RegisterStudentActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                            //creating a new intent to send you back to the main activity once registration is successful
                         //   Intent intent = new Intent(RegisterStudentActivity.this, MainActivity.class);
                          //  startActivity(intent);

                        } else {
                            //if login is unsuccessful
                            Toast.makeText(RegisterStudentActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });*/
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