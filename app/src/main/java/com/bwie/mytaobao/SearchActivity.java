package com.bwie.mytaobao;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONException ;
import org.json.JSONObject ;

import com.bwie.mytaobao.kedaxinfei.JsonParser;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private List<String> titleList,titleList2;
    private EditText edittext;
    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String , String>();
    private Button search_yuyinshuru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        titleList = new ArrayList<>();
        titleList2 = new ArrayList<>();
        titleList2.add("条目一");
        titleList2.add("条目二");
        titleList2.add("条目三");
        //得到控件
        edittext = (EditText) findViewById(R.id.search_edittext);
        //语音听写的触发事件
        search_yuyinshuru = (Button) findViewById(R.id.search_yuyinshuru);
        search_yuyinshuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSpeechDialog();
            }
        });
        initView();
    }

    //返回按钮
    public void search_back(View view){
        finish();
    }
    //点击搜索按钮
    public void homepager_search(View view){
        String edContent = edittext.getText().toString();
        if(!TextUtils.isEmpty(edContent)){
            Intent intent = new Intent(SearchActivity.this, WitchActivity.class);
            intent.putExtra("ed_name",edContent);
            startActivity(intent);
        }else{
            Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
        }
    }
    //初始化
    private void initView() {
        //初始化Tablayout
       TabLayout tab = (TabLayout) findViewById(R.id.homepager_search_tablayout);
//       GridView cearch_faxiangridview = (GridView) findViewById(R.id.cearch_faxiangridview);
       tab.addTab(tab.newTab().setText("全部"));
       tab.addTab(tab.newTab().setText("天猫"));
       tab.addTab(tab.newTab().setText("店铺"));
    }
    //语音听写
    private void startSpeechDialog() {
        //1. 创建RecognizerDialog对象
        RecognizerDialog mDialog = new RecognizerDialog(this, new MyInitListener()) ;
        //2. 设置accent、 language等参数
        mDialog.setParameter(SpeechConstant. LANGUAGE, "zh_cn" );// 设置中文
        mDialog.setParameter(SpeechConstant. ACCENT, "mandarin" );
        // 若要将UI控件用于语义理解，必须添加以下参数设置，设置之后 onResult回调返回将是语义理解
        // 结果
        // mDialog.setParameter("asr_sch", "1");
        // mDialog.setParameter("nlp_version", "2.0");
        //3.设置回调接口
        mDialog.setListener( new MyRecognizerDialogListener()) ;
        //4. 显示dialog，接收语音输入
        mDialog.show() ;
    }

    class MyRecognizerDialogListener implements RecognizerDialogListener {

        /**
         * @param results
         * @param isLast  是否说完了
         */
        @Override
        public void onResult(RecognizerResult results, boolean isLast) {
            String result = results.getResultString(); //为解析的
            showTip(result) ;
            System. out.println(" 没有解析的 :" + result);

            String text = JsonParser.parseIatResult(result);
            System. out.println(" 解析后的 :" + text);

            String sn = null;
            // 读取json结果中的 sn字段
            try {
                JSONObject resultJson = new JSONObject(results.getResultString()) ;
                sn = resultJson.optString("sn" );
            } catch (JSONException e) {
                e.printStackTrace();
            }

            mIatResults .put(sn, text) ;//没有得到一句，添加到

            StringBuffer resultBuffer = new StringBuffer();
            for (String key : mIatResults.keySet()) {
                resultBuffer.append(mIatResults .get(key));
            }

            edittext.setText(resultBuffer.toString());// 设置输入框的文本
            edittext .setSelection(edittext.length()) ;//把光标定位末尾
        }

        @Override
        public void onError(SpeechError speechError) {

        }
    }

    class MyInitListener implements InitListener {

        @Override
        public void onInit(int code) {
            if (code != ErrorCode.SUCCESS) {
                showTip("初始化失败 ");
            }

        }
    }
    //Toast方法
    private void showTip (String data) {
        Toast.makeText( this, data, Toast.LENGTH_SHORT).show() ;
    }

}
