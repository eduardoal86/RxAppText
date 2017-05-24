package com.example.edualves.myrxapplicationtest.service.api;

import com.example.edualves.myrxapplicationtest.model.GithubResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by edualves on 21/05/17.
 */

public interface GithubAPI {

    @GET("users/{username}")
    Observable<GithubResponse> getUserInfo(@Path("username") String username);
}
