package com.example.recyclerviewtest;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.recyclerviewtest.adapter_holder.ImageTextAdapter;
import com.example.recyclerviewtest.adapter_holder.ImageTextAdapter.OnItemClickListener;
import com.example.recyclerviewtest.adapter_holder.ImageTextAdapter.OnItemLongClickListener;
import com.example.recyclerviewtest.data.Fruit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	RecyclerView mRecyclerView;
	ImageTextAdapter mImageTextAdapter;
	String[] names={"葡萄","苹果"," 芒果","猕猴桃","榴莲","樱桃"};
	String[] imageId={"f0","f1","f2","f3","f4","f5"};
	private List<Fruit> mFruitData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recyclerview_layout);
		getSupportActionBar().setTitle("果果们");
		initData();
		initViews();
		
		//设置布局
		
		mImageTextAdapter = new ImageTextAdapter(this, mFruitData);
		mImageTextAdapter.setOnItemClickLister(new OnItemClickListener(){

			@Override
			public void onItemClick(View view, int position) {
				// TODO Auto-generated method stub
				Log.e("fxj", "you click "+position);
			}
			
		} );
		mImageTextAdapter.setItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public void onItemLongClick(View view, int position) {
				// TODO Auto-generated method stub
				Log.e("fxj", "long click "+position);
				
			}
			
		});
		mRecyclerView.setAdapter(mImageTextAdapter);
		
	//	mRecyclerView.add
		
		
	}
	 public void initData() {
	    mFruitData=new ArrayList<Fruit>();
	    for (int i = 0; i < 3; i++) {
	    	 mFruitData.add(new Fruit(names[i],imageId[i]));
		}
	   	
	    }
	public void initViews(){
		mRecyclerView = (RecyclerView)findViewById(R.id.list);
		LinearLayoutManager mlayoutManager =new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(mlayoutManager);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置dognhua 
		
		
	}
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		int nums=mImageTextAdapter.getItemCount();
		switch (id) {
		case R.id.add:

			if(nums!=names.length)
			{
				mFruitData.add(new Fruit(names[nums], imageId[nums]));
				mRecyclerView.scrollToPosition(nums-1);
				mImageTextAdapter.notifyDataSetChanged();
			}else {
				Toast.makeText(this, "nothing to add", Toast.LENGTH_SHORT).show();
			}
			
			break;
		case R.id.remove:
			if(nums!=0)
			{
				mFruitData.remove(nums-1);
				mRecyclerView.scrollToPosition(nums-1);
				mImageTextAdapter.notifyDataSetChanged();
			}else {
				Toast.makeText(this, "nothing to remove", Toast.LENGTH_SHORT).show();
			}
            break;
			
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
