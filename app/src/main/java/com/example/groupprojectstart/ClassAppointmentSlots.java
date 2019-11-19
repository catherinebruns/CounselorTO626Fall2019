package com.example.groupprojectstart;

public class ClassAppointmentSlots {

    public String AppointmentID;
    public String AppointmentDay;
    public String AppointmentStartTime;
    public String AppointmentEndTime;
    public String AppointmentStatus;
    public String AppointmentStudentUserID;
    public String AppointmentCounselorUserID;
    public String AppointmentReason;
    public String AppointmentCreationTimestamp;

    public AppointmentSlots() {
    }

    public AppointmentSlots(String appointmentID, String appointmentDay, String appointmentStartTime, String appointmentEndTime,
                            String appointmentStatus, String appointmentStudentUserID, String appointmentCounselorUserID,
                            String appointmentReason, String appointmentCreationTimestamp) {
        AppointmentID = appointmentID;
        AppointmentDay = appointmentDay;
        AppointmentStartTime = appointmentStartTime;
        AppointmentEndTime = appointmentEndTime;
        AppointmentStatus = appointmentStatus;
        AppointmentStudentUserID = appointmentStudentUserID;
        AppointmentCounselorUserID = appointmentCounselorUserID;
        AppointmentReason = appointmentReason;
        AppointmentCreationTimestamp = appointmentCreationTimestamp;
    }




}
