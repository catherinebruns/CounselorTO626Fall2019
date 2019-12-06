package com.example.groupprojectstart;

import java.util.Date;

public class ClassAppointmentSlots {

    public String AppointmentID;
    //public String AppointmentDay;
 //   public Date AppointmentStart =  new Date();
 //   public Date AppointmentEnd = new Date();

   public String AppointmentStart;
    public String AppointmentStatus;
    public String AppointmentStudentUserID;
    public String AppointmentCounselorUserID;
    public String AppointmentReason;
    public Date AppointmentCreationTimestamp =  new Date();


    public ClassAppointmentSlots() {
    }

    public ClassAppointmentSlots(String AppointmentCounselorUserID, String AppointmentStart){
        this.AppointmentCounselorUserID = AppointmentCounselorUserID;
        this.AppointmentStart = AppointmentStart;
    }

    public ClassAppointmentSlots(String appointmentStart, String AppointmentCreationTimestamp, String appointmentID, String appointmentStatus, String appointmentStudentUserID,
                                 String appointmentCounselorUserID, String appointmentReason) {
        AppointmentStart = appointmentStart;
        AppointmentID = appointmentID;
        AppointmentStatus = appointmentStatus;
        AppointmentStudentUserID = appointmentStudentUserID;
        AppointmentCounselorUserID = appointmentCounselorUserID;
        AppointmentReason = appointmentReason;
    }
}
