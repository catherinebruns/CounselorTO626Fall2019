package com.example.groupprojectstart;

public class ClassCheckIn {

    public String checkinID;
    public String studentUserID;
    public String rating;
    public String checkinPushTS;
    public String checkinCompleteTS;

    public ClassCheckIn(String checkinID, String studentUserID, String rating, String checkinPushTS, String checkinCompleteTS) {
        this.checkinID = checkinID;
        this.studentUserID = studentUserID;
        this.rating = rating;
        this.checkinPushTS = checkinPushTS;
        this.checkinCompleteTS = checkinCompleteTS;
    }
}
