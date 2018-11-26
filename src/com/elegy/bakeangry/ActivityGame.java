package com.elegy.bakeangry;

import com.app.bakeangry.R;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import gamePage.AnimationFood;
import gamePage.AnimationPan;
import tool.Mood;
import tool.MoodTool;

public class ActivityGame extends Activity implements SensorEventListener 
{
	private MoodTool moodTool;
	private int moodID;
	private Mood mood;
	private TextView tv_game_shaketime;
	private ImageView iv_game_pan;
	private ImageView iv_game_food;
	private int shakeNumber;
    private SensorManager sensorManager;
    private int lastShakeTime;
	private int num = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		getActionBar().hide();
		sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        tv_game_shaketime = (TextView)this.findViewById(R.id.tv_game_shaketime);
        iv_game_pan = (ImageView)this.findViewById(R.id.iv_game_pan);
        iv_game_food = (ImageView)this.findViewById(R.id.iv_game_food);
        moodTool = new MoodTool();
		Intent intent = getIntent();
		moodID = intent.getIntExtra("mood", 0);
		mood = moodTool.getMood(moodID);
		iv_game_food.setImageResource(mood.getGamePicture());
		shakeNumber = mood.getShakeNumber();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		lastShakeTime = (int) System.currentTimeMillis();
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
	}
 
	@Override
	protected void onStop()
	{
		sensorManager.unregisterListener(this);
		super.onStop();
	}
 
	@Override
	protected void onPause()
	{
		sensorManager.unregisterListener(this);
		super.onPause();
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}
 
	@Override
	public void onSensorChanged(SensorEvent event) 
	{
		int sensorType = event.sensor.getType();
		float[] values = event.values;
		if(sensorType == Sensor.TYPE_ACCELEROMETER)
		{
			if((Math.abs(values[0])>14||Math.abs(values[1])>14||Math.abs(values[2])>14))
			{
				int currentShakeTime = (int) System.currentTimeMillis();
				if(num > shakeNumber)
				{
					Intent intent = new Intent(ActivityGame.this, ActivityEndTransfer.class);
					intent.putExtra("mood", moodID);
					startActivity(intent);
					finish();
				}
				else if(currentShakeTime - lastShakeTime > 700)
				{
					num++;
					tv_game_shaketime.setText("р║ак"+num+"об");
					AnimationPan panAnimation = new AnimationPan(iv_game_pan);
					AnimationFood foodAnimation = new AnimationFood(iv_game_food);
					panAnimation.drawAnimation();
					foodAnimation.drawAnimation();
					lastShakeTime = currentShakeTime;
				}
			}
		}
	}
}
