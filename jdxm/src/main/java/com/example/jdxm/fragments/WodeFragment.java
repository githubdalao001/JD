package com.example.jdxm.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jdxm.AddAddressActivity;
import com.example.jdxm.LoginActivity;
import com.example.jdxm.R;
import com.example.jdxm.ShowDindanActivity;
import com.example.jdxm.bean.LoginBean;
import com.example.jdxm.utils.SPUtils;
import com.example.jdxm.utils.StaticUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class WodeFragment extends Fragment implements View.OnClickListener {

    private ImageView mHeadWode;
    private TextView mLoginWode;
    private Button wode_select_ding;
    private Button wode_shezhi_address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wode, container, false);
        initView(view);
        return view;
    }

    private void initView(View itemView) {
        mHeadWode = (ImageView) itemView.findViewById(R.id.wode_head);
        mHeadWode.setOnClickListener(this);
        mLoginWode = (TextView) itemView.findViewById(R.id.wode_login);
        mLoginWode.setOnClickListener(this);
        if (StaticUtils.USER_INFO != null) {
            Log.i("===", "initView: "+StaticUtils.USER_INFO.getData().getUid());
            mLoginWode.setText(StaticUtils.USER_INFO.getData().getUsername());
        }

        wode_select_ding = itemView.findViewById(R.id.wode_select_ding);
        wode_select_ding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShowDindanActivity.class));
            }
        });
        //设置收货地址
        wode_shezhi_address = itemView.findViewById(R.id.wode_shezhi_address);
        wode_shezhi_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), AddAddressActivity.class));
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        LoginBean userInfo = StaticUtils.USER_INFO;
        if(userInfo != null){
            if(!mLoginWode.getText().toString().equals(userInfo.getData().getUsername())){
                mLoginWode.setText(userInfo.getData().getUsername());
            }
        }
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.wode_head:
            case R.id.wode_login:
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            default:
                break;
        }
    }
}
