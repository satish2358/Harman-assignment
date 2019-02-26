package com.harman.testapp.model;

import com.google.gson.annotations.SerializedName;

public class PatientClinicalDetails {

    @SerializedName("FullName")
    private String FullName;
    @SerializedName("FirstName")
    private String FirstName;
    @SerializedName("LastName")
    private String LastName;

    public PatientClinicalDetails(String fullName, String firstName, String lastName){
        this.FullName = fullName;
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
