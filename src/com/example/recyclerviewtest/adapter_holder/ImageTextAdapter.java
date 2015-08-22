package com.example.recyclerviewtest.adapter_holder;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.recyclerviewtest.R;
import com.example.recyclerviewtest.data.*;

public class ImageTextAdapter extends RecyclerView.Adapter<ImageTextAdapter.ViewHolder> {
	
	private  OnItemClickListener mOnItemClickLister;
	private  OnItemLongClickListener mItemLongClickListener;
	
//	item监听器
	public interface OnItemClickListener{
		public void onItemClick(View view, int position);
	}
	//item长按监听器
	public interface OnItemLongClickListener{//因为系统原生的OnLongClickListener没有position 我们再包一层
		public void onItemLongClick(View view,int position);
	}
	
	public void setItemLongClickListener(OnItemLongClickListener mItemLongClickListener) {
		this.mItemLongClickListener = mItemLongClickListener;
    }
	public void setOnItemClickLister(OnItemClickListener mOnItemClickLister) {
		this.mOnItemClickLister = mOnItemClickLister;
	}
	
	
	public  class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener,OnLongClickListener{
		private ImageView mImageView;
		private TextView mTextView;
		//就是对应一项的布局文件中有的控件来定义结构，找到里边的控件
		public ViewHolder(View itemView) {
			super(itemView);
			// TODO Auto-generated constructor stub
			mImageView  = (ImageView)itemView.findViewById(R.id.image);
			mTextView = (TextView) itemView.findViewById(R.id.name);
			itemView.setOnClickListener(this);
			itemView.setOnLongClickListener(this);
		}
		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
		    if(mItemLongClickListener !=null){
		    	mItemLongClickListener.onItemLongClick(v, getPosition());
		    }
			return false;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mOnItemClickLister!=null)
				mOnItemClickLister.onItemClick(v, getPosition());
			
		}		
		
	}
	
	private List<Fruit> mFruitList;
	private Context mContext;
	
	public ImageTextAdapter(Context context,List<Fruit> list) {
		// TODO Auto-generated constructor stub
		this.mContext=context;
		mFruitList=list;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mFruitList==null? 0:mFruitList.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int i) {
		// TODO Auto-generated method stub
		//将数据(data)绑定到viewholder中对应的控件
		Fruit mFruit =mFruitList.get(i);
		viewHolder.mTextView.setText(mFruit.getName());
		viewHolder.mImageView.setImageDrawable(mContext.getDrawable(mFruit.getImageId(mContext)));//注意怎么获取图片资源的
		
		
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
		// TODO Auto-generated method stub
		//用于给viewholder设置布局文件
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item_layout, viewGroup, false);
		return new ViewHolder(view); //这样就对应到viewHolder中，找到一项到布局，利用viewHolder获取该项布局中到控件了
	}

}
