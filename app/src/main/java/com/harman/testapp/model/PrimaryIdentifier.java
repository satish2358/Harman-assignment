package com.harman.testapp.model;

import com.google.gson.annotations.SerializedName;

public class PrimaryIdentifier {
    @SerializedName("Label")
    private String Label;
    @SerializedName("Value")
    private String Value;

    public PrimaryIdentifier(String label, String value){
        this.Label = label;
        this.Value = value;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
