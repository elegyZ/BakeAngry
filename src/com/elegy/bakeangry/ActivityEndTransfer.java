package com.elegy.bakeangry;

import com.app.bakeangry.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import tool.Mood;
import tool.MoodTool;
import tool.MusicTool;
import tool.ScreenShotTool;

public class ActivityEndTransfer extends Activity 
{
	private int moodID;
	private MoodTool moodTool;
	private Mood mood;
	private ImageView iv_endtransf_food;
	private ImageView iv_endtransf_bg1;
	private Button bt_endtransf_screenshot;
	private Button bt_endtransf_playagain;
	private Button bt_endtransf_finish;
	private Activity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_transfer);
		getActionBar().hide();
		activity = this;
		iv_endtransf_bg1 = (ImageView)this.findViewById(R.id.iv_endtransf_bg1);
		iv_endtransf_food = (ImageView)this.findViewById(R.id.iv_endtransf_food);
		bt_endtransf_screenshot = (Button)this.findViewById(R.id.bt_endtransf_screenshot);
		bt_endtransf_playagain = (Button)this.findViewById(R.id.bt_endtransf_playagain);
		bt_endtransf_finish = (Button)this.findViewById(R.id.bt_endtransf_finish);
		moodTool = new MoodTool();
		Intent intent = getIntent();
		moodID = intent.getIntExtra("mood", 0);
		mood = moodTool.getMood(moodID);
		if(mood.getMoodName().equals("mope") || mood.getMoodName().equals("annoy") || mood.getMoodName().equals("fury"))
			iv_endtransf_bg1.setVisibility(ImageView.INVISIBLE);
		iv_endtransf_food.setImageResource(mood.getEndtPicture());
		
		OnClickListener lst_endtransf_screenshot = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				bt_endtransf_screenshot.setVisibility(ImageView.INVISIBLE);
				bt_endtransf_playagain.setVisibility(ImageView.INVISIBLE);
				ScreenShotTool.saveImageToGallery(activity, ScreenShotTool.takeScreenShot(activity));
				bt_endtransf_screenshot.setVisibility(ImageView.VISIBLE);
				bt_endtransf_playagain.setVisibility(ImageView.VISIBLE);
			}
		};bt_endtransf_screenshot.setOnClickListener(lst_endtransf_screenshot);
		
		OnClickListener lst_endtransf_playagain = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent intent = new Intent(ActivityEndTransfer.this, ActivityMode.class);
				startActivity(intent);
				finish();
			}			
		};bt_endtransf_playagain.setOnClickListener(lst_endtransf_playagain);
		
		OnClickListener lst_endtransf_finish = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				MusicTool.stopMusic();
				finish();				//”–Œ Ã‚
			}	
		};bt_endtransf_finish.setOnClickListener(lst_endtransf_finish);

		
	}
}
