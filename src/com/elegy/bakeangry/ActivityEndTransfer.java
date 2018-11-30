package com.elegy.bakeangry;

import com.app.bakeangry.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import tool.ActivityCollector;
import tool.Mood;
import tool.MoodTool;
import tool.MusicTool;
import tool.ScreenShotTool;
import tool.ShareTool;

public class ActivityEndTransfer extends BaseActivity 
{
	private int moodID;
	private MoodTool moodTool;
	private Mood mood;
	private ImageView iv_endtransf_bg;
	private ImageView iv_title;
	private TextView tv_endtransf_words;
	private TextView tv_endtransf_words2;
	private ImageView iv_endtransf_again;
	private ImageView iv_endtransf_screenshot;
	private ImageView iv_endtransf_share;
	private ImageView iv_endtransf_finish;
	private Activity activity;
	private Typeface typeface;
	private long firstTime = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_transfer);
		getActionBar().hide();
		activity = this;
		iv_endtransf_bg = (ImageView)this.findViewById(R.id.iv_endtransf_bg);
		iv_title = (ImageView)this.findViewById(R.id.iv_endtransf_title);
		tv_endtransf_words = (TextView)this.findViewById(R.id.tv_endtransf_words);
		tv_endtransf_words2 = (TextView)this.findViewById(R.id.tv_endtransf_words2);
		typeface = Typeface.createFromAsset(getAssets(), "fonts/gantz.ttf");
		iv_endtransf_again = (ImageView)this.findViewById(R.id.iv_endtransf_again);
		iv_endtransf_screenshot = (ImageView)this.findViewById(R.id.iv_endtransf_screenshot);
		iv_endtransf_share = (ImageView)this.findViewById(R.id.iv_endtransf_share);
		iv_endtransf_finish = (ImageView)this.findViewById(R.id.iv_endtransf_finish);
		moodTool = new MoodTool();
		Intent intent = getIntent();
		moodID = intent.getIntExtra("mood", 0);
		mood = moodTool.getMood(moodID);
		iv_endtransf_bg.setImageResource(mood.getEndtPicture());
		tv_endtransf_words.setText(mood.getEndText());
		tv_endtransf_words2.setText(mood.getEndText());
		tv_endtransf_words.setTypeface(typeface);
		tv_endtransf_words2.setTypeface(typeface);
		iv_title.setVisibility(ImageView.INVISIBLE);
		
		OnClickListener lst_endtransf_again = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent intent = new Intent(ActivityEndTransfer.this, ActivityMode.class);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
				finish();
			}			
		};iv_endtransf_again.setOnClickListener(lst_endtransf_again);
		
		OnClickListener lst_endtransf_screenshot = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_endtransf_again.setVisibility(ImageView.INVISIBLE);
				iv_endtransf_screenshot.setVisibility(ImageView.INVISIBLE);
				iv_endtransf_share.setVisibility(ImageView.INVISIBLE);
				iv_endtransf_finish.setVisibility(ImageView.INVISIBLE);
				iv_title.setVisibility(ImageView.VISIBLE);
				ScreenShotTool.saveImageToGallery(activity, ScreenShotTool.takeScreenShot(activity));
				iv_endtransf_again.setVisibility(ImageView.VISIBLE);
				iv_endtransf_screenshot.setVisibility(ImageView.VISIBLE);
				iv_endtransf_share.setVisibility(ImageView.VISIBLE);
				iv_endtransf_finish.setVisibility(ImageView.VISIBLE);
				iv_title.setVisibility(ImageView.INVISIBLE);
			}
		};iv_endtransf_screenshot.setOnClickListener(lst_endtransf_screenshot);
		
		OnClickListener lst_endtransf_share = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_endtransf_again.setVisibility(ImageView.INVISIBLE);
				iv_endtransf_screenshot.setVisibility(ImageView.INVISIBLE);
				iv_endtransf_share.setVisibility(ImageView.INVISIBLE);
				iv_endtransf_finish.setVisibility(ImageView.INVISIBLE);
				iv_title.setVisibility(ImageView.VISIBLE);
				Bitmap bmp = ScreenShotTool.takeScreenShot(activity);
				iv_endtransf_again.setVisibility(ImageView.VISIBLE);
				iv_endtransf_screenshot.setVisibility(ImageView.VISIBLE);
				iv_endtransf_share.setVisibility(ImageView.VISIBLE);
				iv_endtransf_finish.setVisibility(ImageView.VISIBLE);
				iv_title.setVisibility(ImageView.INVISIBLE);
				ShareTool.ShareToWechatTimeLine(activity, bmp);
			}	
		};iv_endtransf_share.setOnClickListener(lst_endtransf_share);
		
		OnClickListener lst_endtransf_finish = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				long secondTime = System.currentTimeMillis();
				if (secondTime - firstTime > 2000) 
		        {
		            Toast.makeText(getBaseContext(), "Press Again To Exit The Game", Toast.LENGTH_SHORT).show();
		            firstTime = secondTime;
		        } 
		        else 
		        {
		        	MusicTool.stopMusic();
					ActivityCollector.finishAll();
		        }
			}	
		};iv_endtransf_finish.setOnClickListener(lst_endtransf_finish);

		
	}
}
