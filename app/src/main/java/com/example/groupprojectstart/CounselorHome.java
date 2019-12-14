package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CounselorHome extends AppCompatActivity implements View.OnClickListener{

    //creating items for CounselorAvailability activity page
    //Counselor's name will be showed in textViewCounselorWelcome2
    TextView textViewCounselorWelcome,textViewCounselorWelcome2, textViewAppointmentsToday, textViewSadStudents;
    private FirebaseAuth mAuth;

    //showing the appointment schedule and the number of check in responses. Currently a static display

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_home);

        mAuth = FirebaseAuth.getInstance();

        textViewAppointmentsToday = findViewById(R.id.textViewAppointmentsToday);
        textViewSadStudents = findViewById(R.id.textViewSadStudents);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Slots");

/*//CEB Tried and failed to connect TextViews here to Appointment Slot information to show appointments today.

        myRef.orderByChild("AppointmentStart").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                ClassAppointmentSlots Slots = dataSnapshot.getValue(ClassAppointmentSlots.class);
                String findTodayAppt = Slots.AppointmentStart;
                textViewAppointmentsToday.setText(findTodayAppt);

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
//CEB Connecting Check In text View to show the sad students
        final DatabaseReference myRef2 = database.getReference("CheckInData");


        myRef2.orderByChild("rating").equalTo("ImSad").limitToLast(5).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ClassCheckIn CheckInData = dataSnapshot.getValue(ClassCheckIn.class);
                String findSadStudents = CheckInData.studentUserID;
                textViewSadStudents.setText(findSadStudents);
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

//test1

        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String email = "empty";
       // String email = user.getEmail();
       // if(email.isEmpty()){
        //     email = "empty";
      // }

      //  Toast.makeText(this, email, Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onClick(View view) {

    }

    //Create counselor specific menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.counselormenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemHome) {
            Toast.makeText(this, "You are on the home page", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.itemMyAvailability) {
            Intent MyAvailabilityIntent = new Intent(this, CounselorAvailability.class);
            startActivity(MyAvailabilityIntent);
        }
        else if (item.getItemId() == R.id.itemLogout){
            Intent LogoutIntent = new Intent(this, MainActivity.class);
            startActivity(LogoutIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}

