package com.example.groupprojectstart;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ClassStudentCounselorAssignments extends AppCompatActivity {

    //StudentUserID
    //CounselorUserID
    //Start Date
    //End Date

    public String StudentUserID;
    public String CounselorUserID;
    public String StartDate;
    public String EndDate;

    public ClassStudentCounselorAssignments(String studentUserID, String counselorUserID, String startDate, String endDate){
        this.StudentUserID = studentUserID;
        this.CounselorUserID = counselorUserID;
        this.StartDate = startDate;
        this.EndDate = endDate;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.counselormenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}


