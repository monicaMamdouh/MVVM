package com.example.monica.mvvmlivadata.common.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by monica on 8/12/2018.
 */

public class EmployeeList {
    @SerializedName("employeeList")
    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeList = employeeArrayList;
    }
}