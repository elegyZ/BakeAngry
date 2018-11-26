package com.elegy.bakeangry;

import com.app.bakeangry.R;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import modePage.AnimationMode;

public class ActivityMode extends Activity 
{
	private AnimationMode animation;
	private ImageView iv_mode_vertical;
	private ImageView iv_mode_horizontal;
	private ImageView iv_mode_thermometer;
	private TextView tv_mode_mope;
	private TextView tv_mode_upset;
	private TextView tv_mode_annoy;
	private TextView tv_mode_fury;
	private TextView tv_mode_angry;
	private TextView tv_mode_rage;
	private Typeface typeface;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mode);
		getActionBar().hide();
		typeface = Typeface.createFromAsset(getAssets(), "fonts/gantz.ttf");
		tv_mode_mope = (TextView)this.findViewById(R.id.tv_mode_mope);
		tv_mode_mope.setTypeface(typeface);
		tv_mode_upset = (TextView)this.findViewById(R.id.tv_mode_upset);
		tv_mode_upset.setTypeface(typeface);
		tv_mode_annoy = (TextView)this.findViewById(R.id.tv_mode_annoy);
		tv_mode_annoy.setTypeface(typeface);
		tv_mode_fury = (TextView)this.findViewById(R.id.tv_mode_fury);
		tv_mode_fury.setTypeface(typeface);
		tv_mode_angry = (TextView)this.findViewById(R.id.tv_mode_angry);
		tv_mode_angry.setTypeface(typeface);
		tv_mode_rage = (TextView)this.findViewById(R.id.tv_mode_rage);
		tv_mode_rage.setTypeface(typeface);
		iv_mode_vertical = (ImageView)this.findViewById(R.id.iv_mode_vertical);
		iv_mode_thermometer = (ImageView)this.findViewById(R.id.iv_mode_thermometer);
		animation = new AnimationMode(this, iv_mode_vertical, iv_mode_horizontal);
		
		OnClickListener lst_mode_mope = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(0, 2.8f);
				animation.drawStain();
			}
		};tv_mode_mope.setOnClickListener(lst_mode_mope);
		
		OnClickListener lst_mode_upset = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(1, 4.2f);
				animation.drawStain();
			}
		};tv_mode_upset.setOnClickListener(lst_mode_upset);
		
		OnClickListener lst_mode_annoy = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(2, 5.5f);
				animation.drawStain();
			}
		};tv_mode_annoy.setOnClickListener(lst_mode_annoy);

		OnClickListener lst_mode_angry = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(3, 7.6f);
				animation.drawStain();
			}
		};tv_mode_angry.setOnClickListener(lst_mode_angry);
		
		OnClickListener lst_mode_fury = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(4, 8.9f);
				animation.drawStain();
			}
		};tv_mode_fury.setOnClickListener(lst_mode_fury);
		
		OnClickListener lst_mode_rage = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(5, 11.2f);
				animation.drawStain();
			}
		};tv_mode_rage.setOnClickListener(lst_mode_rage);
	}
}
