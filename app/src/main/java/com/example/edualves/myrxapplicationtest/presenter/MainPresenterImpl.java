package com.example.edualves.myrxapplicationtest.presenter;

import android.util.Log;

import com.example.edualves.myrxapplicationtest.model.GithubResponse;
import com.example.edualves.myrxapplicationtest.service.GithubService;
import com.example.edualves.myrxapplicationtest.service.GithubServiceImpl;
import com.example.edualves.myrxapplicationtest.service.api.GithubAPI;
import com.example.edualves.myrxapplicationtest.ui.MainView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by edualves on 20/05/17.
 */

public class MainPresenterImpl implements MainPresenter {

    static final String LOG_TAG = MainPresenterImpl.class.getSimpleName();

    MainView view;
    GithubService service = new GithubServiceImpl();

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void getUserInfo(String username) {

        Observable<GithubResponse> observable = service.getUserInfo(username);

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GithubResponse>() {
            @Override
            public void accept(GithubResponse githubResponse) throws Exception {
                view.showUserInfo(githubResponse);
            }
        });

    }
}
