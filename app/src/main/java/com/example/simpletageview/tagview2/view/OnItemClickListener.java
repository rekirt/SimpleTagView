package com.example.simpletageview.tagview2.view;

import android.view.View;
import android.widget.AdapterView;

public abstract interface OnItemClickListener
{
  public abstract void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
}