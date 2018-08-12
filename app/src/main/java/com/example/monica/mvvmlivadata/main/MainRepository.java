package com.example.monica.mvvmlivadata.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.monica.mvvmlivadata.common.helper.Resource;
import com.example.monica.mvvmlivadata.common.models.EmployeeList;
import com.example.monica.mvvmlivadata.common.service.GetEmployeeDataService;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by monica on 8/12/2018.
 */

@Singleton
public class MainRepository {

    private final GetEmployeeDataService getEmployeeDataService;
    private final AppExecutors appExecutors;

    @Inject
    public MainRepository(GetEmployeeDataService getEmployeeDataService) {
        this.getEmployeeDataService = getEmployeeDataService;

    }

    public LiveData<Resource<EmployeeList>> getEmployeesData(int companyId) {
        final MutableLiveData<Resource<EmployeeList>> data = new MutableLiveData<>();

        getEmployeeDataService.getEmployeeData(companyId).enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {

                data.setValue(Resource.success(response.body()));
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                data.setValue(Resource.error(t.getMessage().toString(),null));

            }
        });
        return data;
    }


}
