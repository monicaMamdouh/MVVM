package com.example.monica.mvvmlivadata.common.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceHelper {


    private GetEmployeeDataService getEmployeeDataService;
    private static ServiceHelper mInstance;
    private static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=123";


    public static synchronized ServiceHelper getInstance() {
        if (mInstance == null) {
            mInstance = new ServiceHelper();
        }
        return mInstance;
    }

    private ServiceHelper() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getEmployeeDataService = retrofit.create(GetEmployeeDataService.class);
    }


}
