package com.example.monica.mvvmlivadata.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.monica.mvvmlivadata.common.helper.Resource;
import com.example.monica.mvvmlivadata.common.models.EmployeeList;

import javax.inject.Inject;

/**
 * Created by monica on 8/12/2018.
 */

public class MainViewModel extends ViewModel {
    private int companyNo;
    private MainRepository mainRepository;
    private LiveData<Resource<EmployeeList>> employeeList;


    @Inject
    // UserRepository parameter is provided by Dagger 2
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

     void init(int companyNo) {
        if(this.companyNo!=-1)
        {
            // ViewModel is created per Fragment so
            // we know the companyNo won't change
            return;
        }
        employeeList=mainRepository.getEmployeesData(companyNo);
    }

     LiveData<Resource<EmployeeList>> getEmployeeList() {
        return this.employeeList;
    }
}
