package com.example.edualves.myrxapplicationtest.service;

import com.example.edualves.myrxapplicationtest.model.GithubResponse;

import io.reactivex.Observable;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by edualves on 21/05/17.
 */

public interface GithubService {
    Observable<Response<GithubResponse>> getUserInfo(String username);
}
