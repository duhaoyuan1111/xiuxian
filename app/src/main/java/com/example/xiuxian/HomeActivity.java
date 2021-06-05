package com.example.xiuxian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    private XiuLianFragment xiuLianFragment;
    private HomeFragment homeFragment;
    private Handler mHandler = new Handler();
    private boolean wasRun = true;
    private int exp;
    private Runnable myRunnable;
    private long frozenPeriod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (SaveSharedPreference.getExp(HomeActivity.this).length() != 0) {
            GlobalApplication.setIndex(Integer.parseInt(SaveSharedPreference.getIndex(HomeActivity.this)));
            GlobalApplication.setExp(Integer.parseInt(SaveSharedPreference.getExp(HomeActivity.this)));
            int differences = (int)(System.currentTimeMillis() - Long.parseLong(SaveSharedPreference.getFrozenPeriod(HomeActivity.this)))  / 1000;
            GlobalApplication.setExp(GlobalApplication.getExp() + (differences * GlobalApplication.getExpSpeed(GlobalApplication.getIndex())));

        }
//        Log.d("--exp--", SaveSharedPreference.getExp(HomeActivity.this));
//        Log.d("--FrozenPeriod--", SaveSharedPreference.getFrozenPeriod(HomeActivity.this));
//        Log.d("--Index--", SaveSharedPreference.getIndex(HomeActivity.this));

        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer_homeActivity, homeFragment).commitAllowingStateLoss();




    }

    @Override
    protected void onResume() {
        super.onResume();

        long curTime = System.currentTimeMillis();
        int differences = (int)(curTime - GlobalApplication.getFrozenPeriod()) / 1000;
        GlobalApplication.setExp(GlobalApplication.getExp() + (differences * GlobalApplication.getExpSpeed(GlobalApplication.getIndex())));

        wasRun = true;
        myRunnable = new Runnable() {
            public void run() {
                // Things to be done
                if (wasRun) {
                    exp = GlobalApplication.getExp();
                    exp += GlobalApplication.getExpSpeed(GlobalApplication.getIndex());
                    GlobalApplication.setExp(exp);
                }
                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.postDelayed(myRunnable, 200);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(myRunnable);
        frozenPeriod = System.currentTimeMillis();
        GlobalApplication.setFrozenPeriod(frozenPeriod);

        SaveSharedPreference.setExp(HomeActivity.this, GlobalApplication.getExp() + "");
        SaveSharedPreference.setFrozenPeriod(HomeActivity.this, GlobalApplication.getFrozenPeriod() + "");
        SaveSharedPreference.setIndex(HomeActivity.this, GlobalApplication.getIndex() + "");
//        Log.d("--exp--", SaveSharedPreference.getExp(HomeActivity.this));
//        Log.d("--FrozenPeriod--", SaveSharedPreference.getFrozenPeriod(HomeActivity.this));
//        Log.d("--Index--", SaveSharedPreference.getIndex(HomeActivity.this));
    }

}