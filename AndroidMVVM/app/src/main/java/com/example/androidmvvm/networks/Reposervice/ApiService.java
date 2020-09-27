package com.example.androidmvvm.networks.Reposervice;

import com.example.androidmvvm.models.BaseModel;
import com.example.androidmvvm.models.CardModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Satish on 09/06/2020.
 * Base model
 */
public interface ApiService<T extends BaseModel> {

/*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */

    @GET("users/hadley/orgs")
    Call<List<CardModel>> getOrgsCall();

}

