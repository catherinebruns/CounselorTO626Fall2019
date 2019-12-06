package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CounselorAvailability extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    //test View.OnClickListener AdapterView.OnItemSelectedListener,

    //creating items for CounselorAvailability activity page
    Button ButtonSubmitAvailability;
    CalendarView CalendarAvailability;
    Spinner SpinnerTimeSelection;
    TextView TextViewDate;
    private FirebaseAuth mAuth;


    //Firebase database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Slots");

    //showing the calendar and time
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_availability2);

        ButtonSubmitAvailability = findViewById(R.id.buttonCounselorAvailabilitySubmit);
        CalendarAvailability = findViewById(R.id.calendarView1);
        TextViewDate = findViewById(R.id.textViewApptStart);

      SpinnerTimeSelection = findViewById(R.id.spinnerTimeSelection);
        mAuth = FirebaseAuth.getInstance();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TimeOptions, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
              adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
              SpinnerTimeSelection.setAdapter(adapter);

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

    //submitting counselor's available day
    @Override
    public void onClick(View view) {

        if(ButtonSubmitAvailability == view){


            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String email = user.getEmail();
    //      String time = EditTextTime.getSelectedItem().toString();
          String date2 = TextViewDate.getText().toString();

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
             int currentMinute = calendar.get(Calendar.MINUTE);
            String TimeSelection = SpinnerTimeSelection.getSelectedItem().toString();

            ClassAppointmentSlots createSlot = new ClassAppointmentSlots(date2 + " " + TimeSelection ,currentHour + ":" + currentMinute,"","","",email,"");
                     myRef.push().setValue(createSlot);

    //        Toast.makeText(this,"Added to firebase :" + date2, Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Added to firebase :" + date2+  " for "+email, Toast.LENGTH_SHORT).show();

        }}

    //selecting spinner of time
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String TimeSelection = SpinnerTimeSelection.getSelectedItem().toString();
               Toast.makeText(this, TimeSelection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
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
