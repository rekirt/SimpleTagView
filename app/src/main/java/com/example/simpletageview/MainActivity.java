package com.example.simpletageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.simpletageview.tagview1.NiceActivity;
import com.example.simpletageview.tagview2.GoodActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void test1(View v){
        Intent intent = new Intent(this, NiceActivity.class);
        startActivity(intent);

    }

    public void test2(View v){
        Intent intent = new Intent(this, GoodActivity.class);
        startActivity(intent);
    }

}
