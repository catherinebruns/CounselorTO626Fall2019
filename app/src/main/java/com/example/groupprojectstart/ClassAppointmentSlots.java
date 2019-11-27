package com.example.groupprojectstart;

import java.util.Date;

public class ClassAppointmentSlots {

    public String AppointmentID;
    //public String AppointmentDay;
 //   public Date AppointmentStart =  new Date();
 //   public Date AppointmentEnd = new Date();

   public String AppointmentStart;
    public String AppointmentEnd;
    public String AppointmentStatus;
    public String AppointmentStudentUserID;
    public String AppointmentCounselorUserID;
    public String AppointmentReason;
    public Date AppointmentCreationTimestamp =  new Date();

    public ClassAppointmentSlots() {
    }

    public ClassAppointmentSlots(String appointmentStart, String appointmentEnd, String AppointmentCreationTimestamp, String appointmentID, String appointmentStatus, String appointmentStudentUserID,
                                 String appointmentCounselorUserID, String appointmentReason) {
        AppointmentStart = appointmentStart;
        AppointmentEnd = appointmentEnd;
        AppointmentID = appointmentID;
        AppointmentStatus = appointmentStatus;
        AppointmentStudentUserID = appointmentStudentUserID;
        AppointmentCounselorUserID = appointmentCounselorUserID;
        AppointmentReason = appointmentReason;
    }





}
