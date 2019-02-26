package com.harman.testapp.model;

public class PatientRequestBody {
    final Integer ItemsPerPage;
    final String[] Include;
    final Integer Page;

    public PatientRequestBody(Integer itemsPerPage, String[] include, Integer page){
        this.ItemsPerPage = itemsPerPage;
        this.Include = include;
        this.Page = page;
    }
}
