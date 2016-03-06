package com.example.simpletageview.tagview2.view;

import android.os.Bundle;

public class RefreshCustomThread implements Runnable {
	private CustomListView mView;
    public RefreshCustomThread(CustomListView view){
    	mView = view;
    }
    
    @Override
    public void run(){
      Bundle b = new Bundle();
      try {
        Thread.sleep(50L);
      } catch (Exception localException) {
      }finally {
        b.putBoolean("getRefreshThreadHandler", true);
        mView.sendMsgHanlder(mView.getHandler(), b);
      }
    }
}
