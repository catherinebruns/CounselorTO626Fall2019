package com.example.groupprojectstart;

import java.util.Date;

public class ClassAppointmentSlots {

    public String AppointmentID;
    //public String AppointmentDay;
    public Date AppointmentStart =  new Date();
    public Date AppointmentEnd = new Date();

 //   public String AppointmentStartTime;
 //   public String AppointmentEndTime;
    public String AppointmentStatus;
    public String AppointmentStudentUserID;
    public String AppointmentCounselorUserID;
    public String AppointmentReason;
    public Date AppointmentCreationTimestamp =  new Date();

    public ClassAppointmentSlots() {
    }

    public ClassAppointmentSlots(Date appointmentStart, Date appointmentEnd, Date AppointmentCreationTimestamp) {
        AppointmentStart = appointmentStart;
        AppointmentEnd = appointmentEnd;

    }

    public ClassAppointmentSlots(Date appointmentCreationTimestamp) {
        AppointmentCreationTimestamp = appointmentCreationTimestamp;
    }

    public ClassAppointmentSlots(String appointmentID, String appointmentStatus, String appointmentStudentUserID,
                                 String appointmentCounselorUserID, String appointmentReason) {

        AppointmentID = appointmentID;
        AppointmentStatus = appointmentStatus;
        AppointmentStudentUserID = appointmentStudentUserID;
        AppointmentCounselorUserID = appointmentCounselorUserID;
        AppointmentReason = appointmentReason;
    }




}
