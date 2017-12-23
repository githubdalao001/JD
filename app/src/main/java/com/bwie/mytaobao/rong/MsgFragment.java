package com.bwie.mytaobao.rong;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mytaobao.R;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * 消息会话列表ConversationListFragment
 */
public class MsgFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg, container, false);
        initView(view);
        //消息会话列表
        ConversationListFragment fragment = new ConversationListFragment();
        Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")//设置群组会话聚合显示
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置讨论组会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话非聚合显示
                .build();
        fragment.setUri(uri);

        //替换为融云提供的Fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.rong_content, fragment);
        transaction.commit();
        return view;
    }

    private void initView(View view) {
        RelativeLayout rl_iv_right = (RelativeLayout) view.findViewById(R.id.rl_iv_right);
        RelativeLayout rl_back = (RelativeLayout) view.findViewById(R.id.rl_back);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText("消息");
        rl_iv_right.setVisibility(View.GONE);
        rl_back.setVisibility(View.GONE);
    }
}
