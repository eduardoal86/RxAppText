package com.example.edualves.myrxapplicationtest.service;


import com.example.edualves.myrxapplicationtest.model.GithubResponse;
import com.example.edualves.myrxapplicationtest.service.api.GithubAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by edualves on 20/05/17.
 */

public class GithubServiceImpl implements GithubService {

    static final String SERVICE_ENDPOINT = "https://api.github.com";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVICE_ENDPOINT)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @Override
    public Observable<Response<GithubResponse>> getUserInfo(String username) {

        GithubAPI githubAPI = retrofit.create(GithubAPI.class);

        Observable<Response<GithubResponse>> observable = githubAPI.getUserInfo(username);
        return observable;
    }
}
