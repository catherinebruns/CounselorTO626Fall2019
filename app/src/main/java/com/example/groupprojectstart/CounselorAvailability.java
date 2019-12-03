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
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CounselorAvailability extends AppCompatActivity implements View.OnClickListener{
//test

    Button ButtonSubmitAvailability;
    CalendarView CalendarAvailability;
    EditText EditTextTime;
    TextView TextViewDate;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Slots");


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_availability2);

        ButtonSubmitAvailability = findViewById(R.id.buttonCounselorAvailabilitySubmit);
        CalendarAvailability = findViewById(R.id.calendarView1);
        EditTextTime = findViewById(R.id.editTextTime);
        TextViewDate = findViewById(R.id.textViewDate);

        ButtonSubmitAvailability.setOnClickListener(this);

        CalendarAvailability.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                 String date = (i1+1) + "/" + i2 + "/" + i;
  //              Toast.makeText(CounselorAvailability.this, date , Toast.LENGTH_SHORT).show();
                TextViewDate.setText(date);
            }
        });

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

        if(ButtonSubmitAvailability == view){
          String time = EditTextTime.getText().toString();
          String date2 = TextViewDate.getText().toString();

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
             int currentMinute = calendar.get(Calendar.MINUTE);

            ClassAppointmentSlots createSlot = new ClassAppointmentSlots(date2 + " " + time,"", currentHour + ":" + currentMinute,"","","","","");
                     myRef.push().setValue(createSlot);

            Toast.makeText(this,"Added to firebase :" + date2 + " " + time , Toast.LENGTH_SHORT).show();

//           ClassCheckIn createcheckinResponse = new ClassCheckIn("","teststudent",CheckInButton,"time1","time2");
  //          myRef.push().setValue(createcheckinResponse);
   //         Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();



        }}


}
