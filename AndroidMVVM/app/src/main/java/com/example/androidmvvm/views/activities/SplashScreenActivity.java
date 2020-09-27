package com.example.androidmvvm.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvvm.R;

import me.wangyuwei.particleview.ParticleView;


/**
 * Created by Satish on 09/06/2020.
 * Animation for company name
 */
public class SplashScreenActivity extends AppCompatActivity {
    ParticleView mPvGithub;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        mPvGithub = (ParticleView) findViewById(R.id.pv_github);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                mPvGithub.startAnim();
            }

        }, 1 * 1000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreenActivity.this, UserListActivity.class);
                startActivity(i);
                finish();

            }

        }, 5 * 1000);
    }

}