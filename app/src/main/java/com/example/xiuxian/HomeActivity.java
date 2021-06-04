package com.example.xiuxian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class HomeActivity extends AppCompatActivity {

    private XiuLianFragment xiuLianFragment;
    private HomeFragment homeFragment;
    private Handler mHandler = new Handler();
    private boolean wasRun = true;
    private double exp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer_homeActivity, homeFragment).commitAllowingStateLoss();


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(wasRun){
                    exp = GlobalApplication.getExp();
                    exp++;
                    GlobalApplication.setExp(exp);
                }
                mHandler.postDelayed(this, 1000);
            }
        }, 1000); // 1 seconds






    }
}