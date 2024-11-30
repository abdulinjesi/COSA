package com.onezero.cosa.data.remote.api;

import com.onezero.cosa.data.room.model.Service;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

//    @POST("login")
//    retrofit2.Call<AuthenticationResponse> authenticate(
//            @Body AuthenticationRequest requestBody
//    );

    @GET("service")
    Call<List<Service>> getServices();


}
