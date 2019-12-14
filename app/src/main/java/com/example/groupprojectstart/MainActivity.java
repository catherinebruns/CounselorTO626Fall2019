package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //creating items for Main Activity page
    Button buttonStudentSignIn,buttonStudentSignUp;
    Button buttonCounselorSignIn,buttonCounselorSignUp;
    EditText editTextUsername, editTextPassword;

    public FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        //connecting UI to buttons for main activity page
        buttonStudentSignIn = findViewById(R.id.buttonStudentSignIn);
        buttonCounselorSignIn = findViewById(R.id.buttonCounselorSignIn);
        buttonStudentSignUp = findViewById(R.id.buttonStudentSignUp);
        buttonCounselorSignUp = findViewById(R.id.buttonCounselorSignUp);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextUsername = findViewById(R.id.editTextUsername);

        buttonStudentSignIn.setOnClickListener(this);
        buttonCounselorSignIn.setOnClickListener(this);
        buttonCounselorSignUp.setOnClickListener(this);
        buttonStudentSignUp.setOnClickListener(this);
    }

   // @Override
    //protected void onStart() {
       // super.onStart();
        //if the person is logged in, then do whatever is in this if statement; for example, skip
        // log in page all together
       // if(currentUser =! null) {
      //  }
   // }

    //Student and Counselor Sign in Page
    @Override
    public void onClick(View view) {
       final Intent CounselorSignInIntent = new Intent(this, CounselorHome.class);
       final Intent StudentSignInIntent = new Intent(this,StudentHome.class);

        String email = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //Connecting 4 buttons on Main Activity Page to log in or sign up @
        if(buttonStudentSignIn == view){

            //showing brank error message
            if (editTextUsername.getText().toString().trim().equalsIgnoreCase("")) {
                editTextUsername.setError("This field can not be blank");
            }
            if (editTextPassword.getText().toString().trim().equalsIgnoreCase("")) {
                editTextPassword.setError("This field can not be blank");
            }
            //CEB signing in students
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "sign in success", Toast.LENGTH_SHORT).show();
                                startActivity(StudentSignInIntent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }else if(buttonStudentSignUp == view) {
            Intent StudentSignUpIntent = new Intent(this, RegisterActivity.class);
            startActivity(StudentSignUpIntent);

        }else if(buttonCounselorSignIn == view) {

            //showing blank error message
            if (editTextUsername.getText().toString().trim().equalsIgnoreCase("")) {
                editTextUsername.setError("This field can not be blank");
            }

            if (editTextPassword.getText().toString().trim().equalsIgnoreCase("")) {
                editTextPassword.setError("This field can not be blank");
            }

            //Don: this is the code which is supposed to actually log the user in
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "sign in success", Toast.LENGTH_SHORT).show();
                                startActivity(CounselorSignInIntent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



        }else if(buttonCounselorSignUp == view) {
            Intent CounselorSignUpIntent = new Intent(this, RegisterActivity.class);
            startActivity(CounselorSignUpIntent);
        }

    }

    //Inserting Dummy Navigation for Development Stages  <<< Menu is not necessary in main page.
    // Comment Out.
    /*
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dummymenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
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
    }*/
}
