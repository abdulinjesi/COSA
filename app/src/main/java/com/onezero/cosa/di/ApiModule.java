package com.onezero.cosa.di;

import android.content.Context;
import android.content.SharedPreferences;


import com.onezero.cosa.data.Constants;
import com.onezero.cosa.data.remote.api.ApiService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    @Provides
    public static ApiService provideApiService() {
        long timeoutDuration = 30L; // Timeout duration in seconds

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    okhttp3.Request originalRequest = chain.request();
                    okhttp3.Request modifiedRequest = originalRequest.newBuilder()
                            .build();
                    return chain.proceed(modifiedRequest);
                })
                .connectTimeout(timeoutDuration, TimeUnit.SECONDS)
                .readTimeout(timeoutDuration, TimeUnit.SECONDS)
                .writeTimeout(timeoutDuration, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(ApiService.class);
    }

}
