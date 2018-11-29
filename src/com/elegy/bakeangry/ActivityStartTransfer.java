package com.elegy.bakeangry;

import com.app.bakeangry.R;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import tool.Mood;
import tool.MoodTool;

public class ActivityStartTransfer extends BaseActivity 
{
	private ImageView iv_starttransf_food;
	private TextView tv_starttransf_shake;
	private TextView tv_starttransf_hint;
	private Typeface typeface;
	private MoodTool moodTool;
	private int moodID;
	private Mood mood;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_transfer);
		getActionBar().hide();
		tv_starttransf_shake = (TextView)this.findViewById(R.id.tv_starttransf_shake);
		tv_starttransf_hint = (TextView)this.findViewById(R.id.tv_starttransf_hint);
		typeface = Typeface.createFromAsset(getAssets(), "fonts/gantz.ttf");
		tv_starttransf_shake.setTypeface(typeface);
		tv_starttransf_hint.setTypeface(typeface);
		iv_starttransf_food = (ImageView)this.findViewById(R.id.iv_starttransf_food);
		moodTool = new MoodTool();
		Intent intent = getIntent();
		moodID = intent.getIntExtra("mood", 0);
		mood = moodTool.getMood(moodID);
		tv_starttransf_hint.setText(mood.getStartText());
		iv_starttransf_food.setImageResource(mood.getStartPicture());
		
		OnClickListener lst_starttransf_shake = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent intent = new Intent(ActivityStartTransfer.this, ActivityGame.class);
				intent.putExtra("mood", moodID);
				startActivity(intent);
			}			
		};tv_starttransf_shake.setOnClickListener(lst_starttransf_shake);
	}
}
