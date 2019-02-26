package com.harman.testapp.model;

import com.google.gson.annotations.SerializedName;

public class PatientIdentifiers {
    @SerializedName("PrimaryIdentifier")
    PrimaryIdentifier primaryIdentifier;

    public PatientIdentifiers(PrimaryIdentifier primaryIdentifier){
        this.primaryIdentifier = primaryIdentifier;
    }

    public PrimaryIdentifier getPrimaryIdentifier() {
        return primaryIdentifier;
    }

    public void setPrimaryIdentifier(PrimaryIdentifier primaryIdentifier) {
        this.primaryIdentifier = primaryIdentifier;
    }
}
