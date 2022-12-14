package com.example.myapplication.popwindow;

import java.util.List;

import android.content.Context;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.demo.MultiChoicAdapter;
import com.example.myapplication.demo.Utils;


public class MultiChoicePopWindow extends AbstractChoicePopWindow{

	
	private MultiChoicAdapter<String> mMultiChoicAdapter;
	
	public MultiChoicePopWindow(Context context,View parentView, List<String> list, boolean flag[])
	{
		super(context, parentView, list);
		
		initData(flag);
	}
	

	protected void initData(boolean flag[]) {
		// TODO Auto-generated method stub
		mMultiChoicAdapter = new MultiChoicAdapter<String>(mContext, mList, flag, R.drawable.selector_checkbox1);
		
		mListView.setAdapter(mMultiChoicAdapter);
		mListView.setOnItemClickListener(mMultiChoicAdapter);   
		
		Utils.setListViewHeightBasedOnChildren(mListView);

	}


	public boolean[] getSelectItem()
	{
		return mMultiChoicAdapter.getSelectItem();
	}
	
}
