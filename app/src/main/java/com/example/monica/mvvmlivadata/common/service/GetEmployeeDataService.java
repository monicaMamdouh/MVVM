package com.example.monica.mvvmlivadata.common.service;

import com.example.monica.mvvmlivadata.common.models.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by monica on 8/12/2018.
 */
public interface GetEmployeeDataService {
    @GET("retrofit-demo.php")
    Call<EmployeeList> getEmployeeData(@Query("company_no") int companyNo);
}