package com.example.edualves.myrxapplicationtest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.edualves.myrxapplicationtest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToFragment();
    }

    private void goToFragment() {

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment1, fragment).commit();
    }
}
