package com.elegy.bakeangry;

import com.app.bakeangry.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import startPage.AnimationFire;
import startPage.AnimationPan;
import tool.MusicTool;

public class ActivityStart extends Activity 
{
	private TextView tv_start_start;
	private Typeface typeface;
	private ImageView iv_start_pan;
	private ImageView iv_start_fire;
	private AnimationPan animationPan;
	private AnimationFire animationFire;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		MusicTool.playMusic(this);
		setContentView(R.layout.activity_start);
		getActionBar().hide();
		tv_start_start = (TextView)this.findViewById(R.id.tv_start_start);
		typeface = Typeface.createFromAsset(getAssets(), "fonts/gantz.ttf");
		tv_start_start.setTypeface(typeface);
		iv_start_pan = (ImageView)this.findViewById(R.id.iv_start_pan);
		iv_start_fire = (ImageView)this.findViewById(R.id.iv_start_fire);
		animationPan = new AnimationPan(iv_start_pan);
		animationFire = new AnimationFire(iv_start_fire);
		animationPan.drawAnimation();
		animationFire.drawAnimation();
		
		OnClickListener lst_start_start = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent intent = new Intent(ActivityStart.this, ActivityMode.class);
				startActivity(intent);
				finish();
			}
		};tv_start_start.setOnClickListener(lst_start_start);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

