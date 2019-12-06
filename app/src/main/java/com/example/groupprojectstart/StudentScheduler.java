package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentScheduler extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    public ArrayList<ClassAppointmentSlots> appointmentSlots = new ArrayList<>();
    //creating items for StudentScheduler activity page
    Button buttonStudentApptOk;
    Spinner spinnerReason;
    RecyclerView recyclerViewCounselorAvailability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_scheduler);

        buttonStudentApptOk = findViewById(R.id.buttonStudentApptOk);
        buttonStudentApptOk.setOnClickListener(this);
        spinnerReason = findViewById(R.id.spinnerReason);
        spinnerReason.setOnItemSelectedListener(this);

        //recyclerview pulling data from firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Slots");

        myRef.orderByChild("AppointmentStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<ClassAppointmentSlots> temp = new ArrayList<>();
               for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                   ClassAppointmentSlots c = postSnapshot.getValue(ClassAppointmentSlots.class);
                   temp.add(c);
               }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Toast.makeText(StudentScheduler.this, StudentScheduler.this.appointmentSlots.toString(), Toast.LENGTH_LONG).show();

//dummy data for testing recycler view
        /*appointmentSlots = new ArrayList<ClassAppointmentSlots>();
        appointmentSlots.add(new ClassAppointmentSlots ("12/17/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/18/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/19/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/20/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/21/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/22/2019 8AM-9AM", "a@a.com"));
*/
        recyclerViewCounselorAvailability = findViewById(R.id.recyclerViewCounselorAvailability); //Link recyclerview variable to xml
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(appointmentSlots, this); //Linking the adapter to recyclerView,
        //check out the RecyclerViewAdapter (this is the hard part)
        recyclerViewCounselorAvailability.setAdapter(adapter);
        recyclerViewCounselorAvailability.setLayoutManager(new LinearLayoutManager(this)); //Setting the layout manager, commonly used is linear



        List<String> reasonCodes = new ArrayList<String>();
        reasonCodes.add("School Work");
        reasonCodes.add("Relationships");
        reasonCodes.add("Mental Wellness");

        ArrayAdapter dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, reasonCodes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); spinnerReason.setAdapter(dataAdapter);
    }

    //Connecting button navigation for OK button
    @Override
    public void onClick(View view) {
        if (buttonStudentApptOk == view){
            Intent StudentApptOkIntent = new Intent(this, StudentApptConfirmation.class);
            startActivity(StudentApptOkIntent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String reasonSelection = adapterView.getItemAtPosition(i).toString();

        //need to assign Appointment reason variable the value selected
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //Inserting Dummy Navigation for Development Stages >>> replaces with counselor menu
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
            //I linked it back to home since we don't have a settings page
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
