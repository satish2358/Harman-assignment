package com.harman.testapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PatientDetails {
    @SerializedName("PatientGivenName")
    private String PatientGivenName;
    @SerializedName("PatientFamilyName")
    private String PatientFamilyName;
    @SerializedName("Clinician")
    private PatientClinicalDetails Clinician;
    @SerializedName("PatientIdentifiers")
    private PatientIdentifiers PatientIdentifiers;
    @SerializedName("SiteName")
    private String SiteName;
    @SerializedName("AreaName")
    private String AreaName;
    @SerializedName("Bay")
    private String Bay;
    @SerializedName("Bed")
    private String Bed;

    private boolean expanded;


    public PatientDetails(String patientgivenname, String patientfalimyname, PatientClinicalDetails clinical, PatientIdentifiers patientIdentifiers, String siteName, String areaName, String bay, String bed){
        this.PatientGivenName = patientgivenname;
        this.PatientFamilyName = patientfalimyname;
        this.Clinician = clinical;
        this.PatientIdentifiers = patientIdentifiers;
        this.SiteName = siteName;
        this.AreaName = areaName;
        this.Bay = bay;
        this.Bed = bed;
    }

    public String getPatientFamilyName() {
        return PatientFamilyName;
    }

    public void setPatientFamilyName(String patientFamilyName) {
        PatientFamilyName = patientFamilyName;
    }

    public String getPatientGivenName() {
        return PatientGivenName;
    }

    public void setPatientGivenName(String patientGivenName) {
        PatientGivenName = patientGivenName;
    }

    public PatientClinicalDetails getClinician() {
        return Clinician;
    }

    public void setClinician(PatientClinicalDetails clinician) {
        Clinician = clinician;
    }

    public com.harman.testapp.model.PatientIdentifiers getPatientIdentifiers() {
        return PatientIdentifiers;
    }

    public void setPatientIdentifiers(com.harman.testapp.model.PatientIdentifiers patientIdentifiers) {
        PatientIdentifiers = patientIdentifiers;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public String getBay() {
        return Bay;
    }

    public void setBay(String bay) {
        Bay = bay;
    }

    public String getBed() {
        return Bed;
    }

    public void setBed(String bed) {
        Bed = bed;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
