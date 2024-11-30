package com.onezero.cosa.ui.service;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onezero.cosa.data.room.model.Service;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

import androidx.navigation.ui.AppBarConfiguration;

import com.onezero.cosa.databinding.ActivityServiceBinding;


@AndroidEntryPoint
public class ServiceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ServiceAdapter serviceAdapter;
    private List<Service> serviceList = new ArrayList<>();

    // Inject ViewModel using Hilt
    private ServiceViewModel serviceViewModel = new ViewModelProvider(this).get(ServiceViewModel.class);


    private ActivityServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recyclerView;

        // Initialize RecyclerView and Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        serviceAdapter = new ServiceAdapter(new ArrayList<>());
        recyclerView.setAdapter(serviceAdapter);

        // Initialize ViewModel
        serviceViewModel = new ViewModelProvider(this).get(ServiceViewModel.class);

        // Observe LiveData from ViewModel
        serviceViewModel.getServices().observe(this, services -> {
            if (services != null) {
                // Update the adapter with new data when it changes
                serviceAdapter.updateServices(services);
            }
        });

        // Fetch services (this triggers the network call in ViewModel)
        serviceViewModel.fetchServices();



        // Initialize RecyclerView
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        serviceViewModel.getServices().observe(this, services -> {
//            if (services != null) {
//                serviceAdapter.updateServices(services);
//            }
//        });
//
//        serviceViewModel.fetchServices();

    }

//    private void addService() {
//
//    }
}