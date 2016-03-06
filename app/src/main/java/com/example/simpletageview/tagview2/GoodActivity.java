package com.example.simpletageview.tagview2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.example.simpletageview.R;
import com.example.simpletageview.tagview1.NiceActivity;
import com.example.simpletageview.tagview2.view.CustomListView;
import com.example.simpletageview.tagview2.view.RandomListViewAdapter;
import com.example.simpletageview.tagview2.view.TagBean;

import java.util.ArrayList;
import java.util.List;

public class GoodActivity extends AppCompatActivity {

    CustomListView clv;

    List<TagBean> mData;
    RandomListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_goode);
        clv = (CustomListView)findViewById(R.id.clv);
        mData = new ArrayList<TagBean>();

        adapter = new RandomListViewAdapter(mData,GoodActivity.this);
        clv.setAdapter(adapter);
        clv.postDelayed(new Runnable() {
            @Override
            public void run() {
                mData.add(new TagBean().setTagName("长江后浪推前浪长江后浪推前浪长江后浪推前浪长江后浪推前浪长江后浪推前浪长江后浪推前浪长江后浪推前浪长江后浪推前浪"));
                mData.add(new TagBean().setTagName("长江后浪推前浪长江后浪推前浪"));
                mData.add(new TagBean().setTagName("一代更比一代浪"));
                mData.add(new TagBean().setTagName("屌丝鲁大跑"));
                mData.add(new TagBean().setTagName("波霸秋子"));
                adapter.notifyDataSetChanged();
            }
        },2000);

    }


}
