package com.elegy.bakeangry;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import tool.ActivityCollector;

public class BaseActivity extends Activity 
{
	private long firstTime = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	
	@Override
    public void onBackPressed() 
	{
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) 
        {
            Toast.makeText(getBaseContext(), "Press Again To Exit The Game", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } 
        else 
        	ActivityCollector.finishAll();
	}
}
