package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "StudentInfo")
public class Student {
    @ColumnInfo(name = "StudentName")
    String name;
    String mailId;
    String phonenumber;
    @PrimaryKey @NonNull
    String Rollnumer;
    String Gender;
    String Language;
    String Department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @NonNull
    public String getRollnumer() {
        return Rollnumer;
    }

    public void setRollnumer(@NonNull String rollnumer) {
        Rollnumer = rollnumer;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
