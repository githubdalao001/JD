package com.bwie.mytaobao.rong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mytaobao.R;


/**
 * 聊天界面注册在布局中ConversationFragment
 */
public class ConversationActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // 聊天界面注册在布局中ConversationFragment
        setContentView(R.layout.acyivity_conversation);
        Intent intent = getIntent();
        //获取对方信息
        String targetId = intent.getData().getQueryParameter("targetId");
        String title = intent.getData().getQueryParameter("title");
        Log.i("xxx","title:"+title);
        Log.i("xxx","targetId:"+targetId);
        RelativeLayout rl_back = (RelativeLayout) findViewById(R.id.rl_back);
        RelativeLayout rl_iv_right = (RelativeLayout) findViewById(R.id.rl_iv_right);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        //显示跟谁聊天
        tv_title.setText(title);
        rl_iv_right.setVisibility(View.GONE);
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
