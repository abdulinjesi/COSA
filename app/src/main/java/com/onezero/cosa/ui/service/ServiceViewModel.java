package com.onezero.cosa.ui.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onezero.cosa.data.repository.ServiceRepository;
import com.onezero.cosa.data.room.model.Service;

import javax.inject.Inject;
import java.util.List;
public class ServiceViewModel extends ViewModel {
    private final ServiceRepository repository;
    private final MutableLiveData<List<Service>> serviceLiveData = new MutableLiveData<>();

    @Inject
    public ServiceViewModel(ServiceRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<Service>> getServices() {
        return serviceLiveData;
    }

    public void fetchServices() {
        repository.fetchServices().thenAccept(services -> {
            if (services != null) {
                serviceLiveData.postValue(services);
            }
        });
    }

}
