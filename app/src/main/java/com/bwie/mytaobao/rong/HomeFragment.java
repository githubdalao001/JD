package com.bwie.mytaobao.rong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bwie.mytaobao.R;

import io.rong.imkit.RongIM;

public class HomeFragment extends Fragment {
    boolean flag=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        init(view);
        return view;
    }

    private void init(View view) {
        RelativeLayout rl_iv_right = (RelativeLayout) view.findViewById(R.id.rl_iv_right);
        RelativeLayout rl_back = (RelativeLayout) view.findViewById(R.id.rl_back);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("首页");
        rl_iv_right.setVisibility(View.GONE);
        rl_back.setVisibility(View.GONE);
        Button bt = (Button) view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = RongIM.getInstance().getCurrentUserId();
                Log.i("xxx", "userId::" + userId);
                if (RongIM.getInstance() != null) {
                    if (flag) {
                        //目前写死  Context context, String targetUserId, String title 真实开发从后台获取对方信息后发起聊天
                        RongIM.getInstance().startPrivateChat(getActivity(), "2", "小红");
                    } else {
                        //目前写死
                        RongIM.getInstance().startPrivateChat(getActivity(), "1", "小明");
                    }
                }
            }
        });
    }
}
