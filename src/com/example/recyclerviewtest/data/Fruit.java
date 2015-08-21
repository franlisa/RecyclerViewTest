package com.example.recyclerviewtest.data;

import android.content.Context;

public class Fruit {
	private String mName;
	private String mImage;
	public Fruit(String name, String image) {
		// TODO Auto-generated constructor stub
		this.mName=name;
		this.mImage=image;
	}
	public int getImageId(Context context){
		try {
			return context.getResources().getIdentifier(mImage, "drawable", context.getPackageName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}	
	}
	public String getName() {
		return mName;
	}
	

}
