package com.example.simpletageview.tagview2.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * 自动换行的listview
 */
public class CustomListView extends ViewGroup {
	private CustomAdapter myCustomAdapter;
	private static boolean addChildType;
	private int dividerHeight = 0;

	private int dividerWidth = 0;

	private final Handler handler = new Handler(Looper.getMainLooper()) {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			try {
				if (msg.getData().containsKey("getRefreshThreadHandler")) {
					CustomListView.setAddChildType(false);
					CustomListView.this.myCustomAdapter.notifyCustomListView(CustomListView.this);
				}
			} catch (Exception e) {
			}
		}
	};

	public CustomListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onLayout(boolean arg0, int argLeft, int argTop,int argRight, int argBottom) {
		int count = getChildCount();
		int row = 0;
		int lengthX = 0;
		int lengthY = 0;
		for (int i = 0; i < count; i++) {
			View child = getChildAt(i);
			int width = child.getMeasuredWidth();
			int height = child.getMeasuredHeight();
			Log.e("test","childw=="+width+"childh==="+height);
			if (lengthX == 0)
				lengthX += width;
			else {
				lengthX += width + getDividerWidth();
			}

			if ((i == 0) && (lengthX <= argRight)) {
				lengthY += height;
			}

			if (lengthX > argRight) {
				lengthX = width;
				lengthY += getDividerHeight() + height;
				row++;
				Log.e("test", "lengthx===" + lengthX + "right===" + argRight);
				child.layout(lengthX - width, lengthY - height, lengthX,lengthY);
			} else {
				child.layout(lengthX - width, lengthY - height, lengthX,lengthY);
			}
		}
		ViewGroup.LayoutParams lp = getLayoutParams();
		lp.height = lengthY;
		setLayoutParams(lp);
		if (isAddChildType())new Thread(new RefreshCustomThread(this)).start();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		int mode = MeasureSpec.getMode(heightMeasureSpec);

//		measureChildren(widthMeasureSpec, heightMeasureSpec);
		int childCount = getChildCount();

		for (int i = 0; i < childCount; i++) {
			View child = getChildAt(i);
			child.measure(0, 0);
		}
		if(height==0 && childCount!=0){
			for (int i = 0; i < childCount; i++) {
				View child = getChildAt(i);
				height+=child.getMeasuredHeight();
			}
		}

		Log.e("test","count=="+childCount+"w==="+width + "h===" + height+"mode==="+mode);

		if(childCount==0){
			setMeasuredDimension(0, 0);
			Log.e("test","0000");
		}else if(mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED){
			setMeasuredDimension(width, height);
			Log.e("test", "1111");
		}else{
			setMeasuredDimension(width, height);
			Log.e("test", "2222");
		}


	}

	static final boolean isAddChildType() {
		return addChildType;
	}

	public static void setAddChildType(boolean addChildType) {
		addChildType = addChildType;
	}

	final int getDividerHeight() {
		return this.dividerHeight;
	}

	public void setDividerHeight(int dividerHeight) {
		this.dividerHeight = dividerHeight;
	}

	final int getDividerWidth() {
		return this.dividerWidth;
	}

	public void setDividerWidth(int dividerWidth) {
		this.dividerWidth = dividerWidth;
	}

	public void setAdapter(CustomAdapter adapter) {
		this.myCustomAdapter = adapter;
		setAddChildType(true);
		adapter.notifyCustomListView(this);
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		this.myCustomAdapter.setOnItemClickListener(listener);
	}

	public void setOnItemLongClickListener(OnItemLongClickListener listener) {
		this.myCustomAdapter.setOnItemLongClickListener(listener);
	}

	public void sendMsgHanlder(Handler handler, Bundle data) {
		Message msg = handler.obtainMessage();
		msg.setData(data);
		handler.sendMessage(msg);
	}

	@Override
	public Handler getHandler() {
		return handler;
	}

}
