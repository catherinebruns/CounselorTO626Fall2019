package com.example.groupprojectstart;

public class ClassStudentUser {

    public String studentUserID;
    public String studentFirstName;
    public String studentLastName;
    public String studentEmail;

    public ClassStudentUser(String studentUserID, String studentFirstName, String studentLastName, String studentEmail) {
        this.studentEmail = studentEmail;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentUserID = studentUserID;

    }
}
