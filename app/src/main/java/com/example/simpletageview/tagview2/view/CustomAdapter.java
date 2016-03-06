package com.example.simpletageview.tagview2.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


public class CustomAdapter {
	  protected View myView;
	  protected ViewGroup myViewGroup;
	  private CustomListView myCustomListView;
	  private OnItemClickListener listener;
	  private OnItemLongClickListener longListener;

	  public int getCount()
	  {
	    return 0;
	  }

	  public Object getItem(int position) {
	    return null;
	  }

	  public long getItemId(int position) {
	    return 0L;
	  }

	  public View getView(int position, View convertView, ViewGroup parent) {
	    return null;
	  }

	  private final void getAllViewAddSexangle()
	  {
	    this.myCustomListView.removeAllViews();
		  Log.e("test", "size===" + getCount());
		for (int i = 0; i < getCount(); i++) {
			View viewItem = getView(i, null, myCustomListView);
			Log.e("test","view1=="+viewItem);
			myCustomListView.addView(viewItem,i);
			myCustomListView.postInvalidate();
		}
	  }

	  public void notifyDataSetChanged()
	  {
	    CustomListView.setAddChildType(true);
	    notifyCustomListView(this.myCustomListView);
	  }

	  public void notifyCustomListView(CustomListView formateList)
	  {
	    this.myCustomListView = formateList;
	    this.myCustomListView.removeAllViews();
	    getAllViewAddSexangle();
	    if(null!=listener)setOnItemClickListener(this.listener);
	    if(null!=longListener)setOnItemLongClickListener(this.longListener);
	  }

	  public void setOnItemClickListener(final OnItemClickListener listener)
	  {
	    this.listener = listener;
	    for (int i = 0; i < this.myCustomListView.getChildCount(); i++) {
	      final int parame = i;
	      View view = this.myCustomListView.getChildAt(i);
	      view.setOnClickListener(new View.OnClickListener()
	      {
	        @Override
			public void onClick(View v)
	        {
	          listener.onItemClick(null, v, parame, CustomAdapter.this.getCount());
	        }
	      });
	    }
	  }

	  public void setOnItemLongClickListener(final OnItemLongClickListener listener)
	  {
	    this.longListener = listener;
	    for (int i = 0; i < this.myCustomListView.getChildCount(); i++) {
	      final int parame = i;
	      View view = this.myCustomListView.getChildAt(i);
	      view.setOnLongClickListener(new View.OnLongClickListener()
	      {
	        @Override
			public boolean onLongClick(View v)
	        {
	          listener.onItemLongClick(null, v, parame, CustomAdapter.this.getCount());
	          return true;
	        }
	      });
	    }
	  }
}
