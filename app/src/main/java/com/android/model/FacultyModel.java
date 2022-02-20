package com.android.model;

import java.io.Serializable;

public class FacultyModel implements Serializable {
    String userName;
    String department;
    String subject;
    String profileImage;

//    public FacultyModel(String userName, String department, String subject, String profileImage) {
//        this.userName = userName;
//        this.department = department;
//        this.subject = subject;
//        this.profileImage = profileImage;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
