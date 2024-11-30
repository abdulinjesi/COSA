package com.onezero.cosa.ui.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onezero.cosa.R;
import com.onezero.cosa.data.room.model.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private List<Service> serviceList;

    // Constructor to initialize the service list
    public ServiceAdapter(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service, parent, false);
        return new ServiceViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        Service currentService = serviceList.get(position);
        holder.serviceName.setText(currentService.name);
        holder.serviceDescription.setText(currentService.description);
        holder.serviceLikes.setText(currentService.likes);
    }

    public void updateServices(List<Service> newServices) {
        this.serviceList = newServices;
        notifyDataSetChanged();
    }

    // Return the size of the dataset
    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    // ViewHolder class to hold references to the views for each item
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {

        public TextView serviceName;
        public TextView serviceDescription;
        public TextView serviceLikes;

        public ServiceViewHolder(View itemView) {
            super(itemView);
            serviceName = itemView.findViewById(R.id.serviceName);
            serviceDescription = itemView.findViewById(R.id.serviceDescription);
            serviceLikes = itemView.findViewById(R.id.likeCount);
        }
    }

    // Update the list of services when the data changes
    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
        notifyDataSetChanged();
    }
}
