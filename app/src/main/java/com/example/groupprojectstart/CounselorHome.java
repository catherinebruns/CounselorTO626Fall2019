package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CounselorHome extends AppCompatActivity implements View.OnClickListener{

    //creating items for CounselorAvailability activity page
    //Couselor's name will be showed in textViswCounselorWelcome2
    TextView textViewCounselorWelcome,textViewCounselorWelcome2;
    private FirebaseAuth mAuth;

    //showing the appointment schedule and the number of response


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_home);

        mAuth = FirebaseAuth.getInstance();

          FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String email = "empty";
       // String email = user.getEmail();
       // if(email.isEmpty()){
        //     email = "empty";
      // }

      //  Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

    }

    //Inserting Dummy Navigation for Development Stages >>> replaces with counselor menu by Amy
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

