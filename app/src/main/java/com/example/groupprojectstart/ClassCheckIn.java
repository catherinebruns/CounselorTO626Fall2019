package com.example.groupprojectstart;

public class ClassCheckIn {

    public String CheckinID;
    public String StudentUserID;
    public String Rating;
    public String CheckinPushTS;
    public String CheckinCompleteTS;

    public ClassCheckIn(String checkinID, String studentUserID, String rating, String checkinPushTS, String checkinCompleteTS) {
        CheckinID = checkinID;
        StudentUserID = studentUserID;
        Rating = rating;
        CheckinPushTS = checkinPushTS;
        CheckinCompleteTS = checkinCompleteTS;
    }
}
