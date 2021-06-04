package com.example.xiuxian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;


public class HomeFragment extends Fragment {

    private Button mBtnUser;
    private Button mBtnXiuLian;
    private Button mBtnBag;
    private Button mBtnSkill;
    private Button mBtnPet;
    private Button mBtnFuBen;
    private XiuLianFragment xiuLianFragment;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View HomeFragment = inflater.inflate(R.layout.fragment_home, container, false);
        mBtnUser = HomeFragment.findViewById(R.id.user_btn_HomeFrag);
        mBtnXiuLian = HomeFragment.findViewById(R.id.xiuLian_btn_HomeFrag);
        mBtnBag = HomeFragment.findViewById(R.id.bag_btn_HomeFrag);
        mBtnSkill = HomeFragment.findViewById(R.id.skill_btn_HomeFrag);
        mBtnPet = HomeFragment.findViewById(R.id.pet_btn_HomeFrag);
        mBtnFuBen = HomeFragment.findViewById(R.id.fuben_btn_HomeFrag);

        return HomeFragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBtnXiuLian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xiuLianFragment == null) {
                    xiuLianFragment = new XiuLianFragment();
                }
                Bundle bundleXiuLian = new Bundle();
                xiuLianFragment.setArguments(bundleXiuLian);

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_homeActivity, xiuLianFragment).commitAllowingStateLoss();
            }
        });



    }
}