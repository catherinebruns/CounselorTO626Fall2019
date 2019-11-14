package com.example.groupprojectstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CounselorAvailability extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_availability2);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.counselormenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemHome) {
            Intent HomeIntent = new Intent(this, CounselorHome.class);
            startActivity(HomeIntent);
        } else if (item.getItemId() == R.id.itemSettings){
            //I linked it back to home since we don't have a settings page
            Intent SettingsIntent = new Intent(this, CounselorHome.class);
            startActivity(SettingsIntent);
        }
        else if (item.getItemId() == R.id.itemCheckInManager){
            Intent CheckInManagerIntent = new Intent(this,CounselorCheckInManager.class);
            startActivity(CheckInManagerIntent);
        }
        else if (item.getItemId() == R.id.itemMyAvailability){
            Intent MyAvailabilityIntent = new Intent(this, CounselorAvailability.class);
            startActivity(MyAvailabilityIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
