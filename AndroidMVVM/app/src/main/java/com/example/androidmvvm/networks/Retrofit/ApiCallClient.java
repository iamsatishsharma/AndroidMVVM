package com.example.androidmvvm.networks.Retrofit;

import com.example.androidmvvm.networks.Reposervice.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Satish on 09/06/2020.
 * Base model
 */
public class ApiCallClient {

    public static final String BASE_URL = "https://api.github.com/";

    private static Retrofit retrofit = null;
    public static ApiService getClient() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiService api = retrofit.create(ApiService.class);
        return api; // return the APIInterface object
    }

}
