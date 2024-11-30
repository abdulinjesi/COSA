package com.onezero.cosa.data.repository;

import androidx.lifecycle.LiveData;

import com.onezero.cosa.data.remote.api.ApiService;
import com.onezero.cosa.data.room.dao.ServiceDao;
import com.onezero.cosa.data.room.model.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class ServiceRepository {
    private final ServiceDao serviceDao;
    private final ApiService apiService ;
    @Inject
    public ServiceRepository(ServiceDao serviceDao, ApiService apiService) {
        this.serviceDao = serviceDao;
        this.apiService = apiService;
    }

    public CompletableFuture<List<Service>> fetchServices() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Service> res = apiService.getServices().execute().body();
                serviceDao.insertAll(res);
                return res;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public LiveData<List<Service>> getServices(){
        return serviceDao.getAllServices();
    }

    public void addService(Service service) {
        serviceDao.insertService(service);
    }
}
