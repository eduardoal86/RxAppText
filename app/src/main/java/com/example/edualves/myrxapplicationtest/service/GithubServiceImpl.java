package com.example.edualves.myrxapplicationtest.service;


import com.example.edualves.myrxapplicationtest.model.GithubResponse;
import com.example.edualves.myrxapplicationtest.service.api.GithubAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
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
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @Override
    public Observable<GithubResponse> getUserInfo(String username) {
        
        GithubAPI githubAPI = retrofit.create(GithubAPI.class);

        Observable<GithubResponse> observable = githubAPI.getUserInfo(username);
        observable.subscribe(new Observer<GithubResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GithubResponse value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return observable;
    }
}
