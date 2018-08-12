package com.example.monica.mvvmlivadata.main;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monica.mvvmlivadata.R;
import com.example.monica.mvvmlivadata.common.helper.Resource;
import com.example.monica.mvvmlivadata.common.helper.Status;
import com.example.monica.mvvmlivadata.common.models.EmployeeList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final int companyNo = 100;
    private MainViewModel mainViewModel;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init(companyNo);
        mainViewModel.getEmployeeList().observe(this, new Observer<Resource<EmployeeList>>() {
            @Override
            public void onChanged(@Nullable Resource<EmployeeList> employeeListResource) {


                assert employeeListResource != null;
                if(employeeListResource.status.equals( Status.SUCCESS))
                {
                    //update UI
                }
                else
                {
                    //set error
                }
            }
        });
    }


}
