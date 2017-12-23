package com.bwie.mytaobao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.mytaobao.myview.MyYinDaoView;

public class YinDaoActivity extends AppCompatActivity{
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private MyYinDaoView myYinDaoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);

        sp = getSharedPreferences("dialog",MODE_PRIVATE);
        edit = sp.edit();
        myYinDaoView = (MyYinDaoView) findViewById(R.id.yindaoview);
        if(sp.getBoolean("lianjie",true)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final AlertDialog alertDialog = builder.create();
            View view = View.inflate(YinDaoActivity.this, R.layout.curstomdialog, null);
            alertDialog.setView(view);
            final CheckBox dialog_check = view.findViewById(R.id.dialog_check);
            TextView dialog_jujue = view.findViewById(R.id.dialog_jujue);
            TextView dialog_tongyi = view.findViewById(R.id.dialog_tongyi);
            dialog_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialog_check.isChecked()){
                        edit.putBoolean("lianjie",false);
                    }else{
                        edit.putBoolean("lianjie",true);
                    }
                    edit.commit();
                }
            });
            dialog_jujue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                    finish();
                }
            });
            dialog_tongyi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                    activityjump();
                }
            });
            alertDialog.show();
        }else{
            activityjump();
        }

    }
    //跳转方法
    private void activityjump() {
        myYinDaoView.setVisibility(View.VISIBLE);
        myYinDaoView.setStartActivity(new MyYinDaoView.startActivity() {
            @Override
            public void start() {
                startActivity(new Intent(YinDaoActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
