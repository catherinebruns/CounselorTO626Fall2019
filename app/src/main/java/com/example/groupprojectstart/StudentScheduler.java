package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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


import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
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
    Spinner spinnerReason, spinnerDates, spinnerTimeSlots;
    RecyclerView recyclerViewCounselorAvailability;
    String appointmentChoice;

    private FirebaseAuth mAuth;
    //Firebase database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Slots");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_scheduler);

        buttonStudentApptOk = findViewById(R.id.buttonStudentApptOk);
        spinnerReason = findViewById(R.id.spinnerReason);
        spinnerDates = findViewById(R.id.spinnerDates);
        spinnerTimeSlots = findViewById(R.id.spinnerTimeSlots);
        recyclerViewCounselorAvailability = findViewById(R.id.recyclerViewCounselorAvailability);

        //need to make new variable with both appointment date and time in it. set as string above.


        buttonStudentApptOk.setOnClickListener(this);
        spinnerDates.setOnItemSelectedListener(this);
        spinnerReason.setOnItemSelectedListener(this);
        spinnerTimeSlots.setOnItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();


        //Pulling data for recyclerview
        myRef.orderByChild("AppointmentStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<ClassAppointmentSlots> temp = new ArrayList<>();
               for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                   ClassAppointmentSlots c = postSnapshot.getValue(ClassAppointmentSlots.class);
                   temp.add(c);
               }
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(temp, StudentScheduler.this); //Linking the adapter to recyclerView,
                recyclerViewCounselorAvailability.setAdapter(adapter);
                recyclerViewCounselorAvailability.setLayoutManager(new LinearLayoutManager(StudentScheduler.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
/*
        Toast.makeText(StudentScheduler.this, StudentScheduler.this.appointmentSlots.toString(), Toast.LENGTH_LONG).show();
*/

//dummy data for testing recycler view
        /*appointmentSlots = new ArrayList<ClassAppointmentSlots>();
        appointmentSlots.add(new ClassAppointmentSlots ("12/17/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/18/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/19/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/20/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/21/2019 8AM-9AM", "a@a.com"));
        appointmentSlots.add(new ClassAppointmentSlots ("12/22/2019 8AM-9AM", "a@a.com"));
*///Setting the layout manager, commonly used is linear

       /* List<String> reasonCodes = new ArrayList<String>();
        reasonCodes.add("School Work");
        reasonCodes.add("Relationships");
        reasonCodes.add("Mental Wellness");*/

        /*ArrayAdapter dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, reasonCodes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); spinnerReason.setAdapter(dataAdapter);*/
        //^CEB recreated this array in resources file for strings to store with other spinner info

        //setting the spinners to show values
        ArrayAdapter<CharSequence> dateadapter = ArrayAdapter.createFromResource(this, R.array.DateOptions, android.R.layout.simple_spinner_item);
        dateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDates.setAdapter(dateadapter);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TimeOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTimeSlots.setAdapter(adapter);

        ArrayAdapter<CharSequence> reasonadapter = ArrayAdapter.createFromResource(this, R.array.ReasonCodes, android.R.layout.simple_spinner_item);
        reasonadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReason.setAdapter(reasonadapter);
    }

    //Connecting button navigation for OK button
    @Override
    public void onClick(View view) {
        if (buttonStudentApptOk == view){
            //sending selections to firebase

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            final String studentEmail = user.getEmail();

            myRef.orderByChild("AppointmentStart").equalTo(appointmentChoice).addChildEventListener(new ChildEventListener() {

                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String key = dataSnapshot.getKey();

                    myRef.child(key).child("AppointmentReason").setValue(spinnerReason.getSelectedItem().toString());
                    myRef.child(key).child("AppointmentStudentUserID").setValue(studentEmail);
                    myRef.child(key).child("AppointmentStatus").setValue("Booked");
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

        });

            //to make a toast once they are done and take them back to the student home. CEB deciding not to do a confirmation page for the time being.
            Toast.makeText(this,"Confirmed: Your appointment is " + appointmentChoice, Toast.LENGTH_SHORT).show();
            Intent StudentApptOkIntent = new Intent(StudentScheduler.this, StudentHome.class);
            startActivity(StudentApptOkIntent);
    }
    }

//for spinner selections
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String DateSelection = spinnerDates.getItemAtPosition(i).toString();
        String TimeSelection = spinnerTimeSlots.getSelectedItem().toString();
        String ReasonSelection = spinnerReason.getSelectedItem().toString();

        appointmentChoice = DateSelection + " " + TimeSelection;
        Toast.makeText(StudentScheduler.this, appointmentChoice, Toast.LENGTH_LONG).show();
        //need to assign Appointment reason variable the value selected
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }




    //student specific menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.studentmenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemScheduleAppt) {
            Toast.makeText(this, "You are on the appointment scheduling page", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.itemHome) {
            Intent HomeIntent = new Intent(this, StudentHome.class);
            startActivity(HomeIntent);
        }
        else if (item.getItemId() == R.id.itemCheckin) {
            Intent CheckinIntent = new Intent(this, StudentCheckIn.class);
            startActivity(CheckinIntent);
        }
        else if (item.getItemId() == R.id.itemStudentLogout){
            Intent LogoutIntent = new Intent(this, MainActivity.class);
            startActivity(LogoutIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
