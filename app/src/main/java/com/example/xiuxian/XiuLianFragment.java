package com.example.xiuxian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.telephony.gsm.GsmCellLocation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class XiuLianFragment extends Fragment {

    private Button mBtnBack;
    private Button mBtnTupo;
    private HomeFragment homeFragment;
    private Handler mHandler = new Handler();
    private boolean wasRun = true;
    private TextView mTvXiulianzhi;
    private TextView mTvLevel;
    private TextView mTvSpeed;
    private int curIndex;


    public XiuLianFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View XiuLianFragment = inflater.inflate(R.layout.fragment_xiulian, container, false);
        mBtnBack = XiuLianFragment.findViewById(R.id.back_btn_XiuLianFrag);
        mTvXiulianzhi = XiuLianFragment.findViewById(R.id.num_xiulianzhi_tv_XiuLianFrag);
        mTvLevel = XiuLianFragment.findViewById(R.id.num_level_tv_XiuLianFrag);
        mTvSpeed = XiuLianFragment.findViewById(R.id.num_speed_tv_XiuLianFrag);
        mBtnTupo = XiuLianFragment.findViewById(R.id.tupo_btn_XiuLianFrag);
        return XiuLianFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        curIndex = GlobalApplication.getIndex();
        mTvLevel.setText(GlobalApplication.getLevel(curIndex));
        if (GlobalApplication.getExpSpeed(GlobalApplication.getIndex()) * 60 >= 10000) {
            mTvSpeed.setText((GlobalApplication.getExpSpeed(GlobalApplication.getIndex()) * 60 / 10000) + " 万 / 分钟");
        } else {
            mTvSpeed.setText((GlobalApplication.getExpSpeed(GlobalApplication.getIndex()) * 60) + " / 分钟");
        }
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_homeActivity, homeFragment).commitAllowingStateLoss();
            }
        });

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(wasRun){
                    curIndex = GlobalApplication.getIndex();
                    int requireExp = GlobalApplication.getExpRequire(curIndex) * GlobalApplication.getExpSpeed(curIndex);
                    if (requireExp >= 10000) {
                        mTvXiulianzhi.setText(GlobalApplication.getExp() + " / " + (requireExp / 10000) + " 万");
                    } else {
                        mTvXiulianzhi.setText(GlobalApplication.getExp() + " / " + requireExp);
                    }
                    int curExpRequire = GlobalApplication.getExpRequire(GlobalApplication.getIndex()) * GlobalApplication.getExpSpeed(GlobalApplication.getIndex());
                    if (curIndex < 100 && curExpRequire <= GlobalApplication.getExp()) {
                        mBtnTupo.setEnabled(true);
                    } else {
                        mBtnTupo.setEnabled(false);
                    }
                }
                mHandler.postDelayed(this, 200);
            }
        }, 50);

        mBtnTupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curExpRequire = GlobalApplication.getExpRequire(GlobalApplication.getIndex()) * GlobalApplication.getExpSpeed(GlobalApplication.getIndex());
                curIndex = GlobalApplication.getIndex();
                if (curExpRequire <= GlobalApplication.getExp() && curIndex < 100) {
                    curIndex++;
                    GlobalApplication.setIndex(curIndex);
                    GlobalApplication.setExp(GlobalApplication.getExp() - curExpRequire);
                    mTvLevel.setText(GlobalApplication.getLevel(GlobalApplication.getIndex()));
                    if (GlobalApplication.getExpSpeed(GlobalApplication.getIndex()) * 60 >= 10000) {
                        mTvSpeed.setText((GlobalApplication.getExpSpeed(GlobalApplication.getIndex()) * 60 / 10000) + " 万 / 分钟");
                    } else {
                        mTvSpeed.setText((GlobalApplication.getExpSpeed(GlobalApplication.getIndex()) * 60) + " / 分钟");
                    }

                }
            }
        });

    }

}