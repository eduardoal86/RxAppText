package com.example.edualves.myrxapplicationtest.service;

import com.example.edualves.myrxapplicationtest.model.GithubResponse;

import io.reactivex.Observable;
import retrofit2.Callback;

/**
 * Created by edualves on 21/05/17.
 */

public interface GithubService {
    Observable<GithubResponse> getUserInfo(String username);
}
