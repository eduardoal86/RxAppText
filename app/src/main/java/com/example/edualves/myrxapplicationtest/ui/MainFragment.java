package com.example.edualves.myrxapplicationtest.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.edualves.myrxapplicationtest.model.GithubResponse;
import com.example.edualves.myrxapplicationtest.R;
import com.example.edualves.myrxapplicationtest.presenter.MainPresenter;
import com.example.edualves.myrxapplicationtest.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by edualves on 20/05/17.
 */

public class MainFragment extends Fragment implements MainView{

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.bio_desc)
    TextView bioDesc;

    @BindView(R.id.user_photo)
    CircleImageView userPhoto;

    @BindView(R.id.info_container)
    RelativeLayout infoContainer;

    MainPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_main_example, container, false);
        ButterKnife.bind(this, view);

        presenter = new MainPresenterImpl(this);

        return view;
    }

    @OnClick(R.id.btn_container)
    void fetchData() {
        presenter.getUserInfo("eduardoal86");

    }

    @Override
    public void showUserInfo(GithubResponse user) {

        infoContainer.setVisibility(View.VISIBLE);

        Glide.with(getActivity())
                .load(user.getUserPhotoUrl())
                .crossFade()
                .into(userPhoto);

        name.setText(user.getName());
        bioDesc.setText(user.getBio());

    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getActivity(),
                message,
                Toast.LENGTH_LONG).show();
    }

}
