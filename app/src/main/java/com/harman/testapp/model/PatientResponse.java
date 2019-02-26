package com.harman.testapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PatientResponse {
    /*@SerializedName("Metadata")
    private int metadata;
    @SerializedName("Messages")
    private int messages;*/
    @SerializedName("Data")
    private List<PatientDetails> data;

   /* public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }

    public int getMetadata() {
        return metadata;
    }

    public void setMetadata(int metadata) {
        this.metadata = metadata;
    }*/

    public List<PatientDetails> getData() {
        return data;
    }

    public void setData(List<PatientDetails> data) {
        this.data = data;
    }
}
