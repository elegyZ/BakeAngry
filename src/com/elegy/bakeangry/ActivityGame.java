package com.elegy.bakeangry;

import com.app.bakeangry.R;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import gamePage.AnimationBoat;
import gamePage.AnimationDialog;
import gamePage.AnimationFood;
import gamePage.AnimationPan;
import tool.Mood;
import tool.MoodTool;

public class ActivityGame extends BaseActivity implements SensorEventListener 
{
	private final static double GRAVITY = 9.8;
	private MoodTool moodTool;
	private int moodID;
	private Mood mood;
	private TextView tv_game_shaketime;
	private ImageView iv_game_pan;
	private ImageView iv_game_food;
	private ImageView iv_game_boat;
	private AnimationBoat boatAnimation;
	private AnimationDialog dialogAnimation;
	private int shakeNumber;
    private SensorManager sensorManager;
    private long lastShakeTime;
	private int num = 0;
	
	public void drawDialog()
	{
		dialogAnimation.drawAnimation();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		getActionBar().hide();
		lastShakeTime = System.currentTimeMillis();
		sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        tv_game_shaketime = (TextView)this.findViewById(R.id.tv_game_shaketime);
        iv_game_pan = (ImageView)this.findViewById(R.id.iv_game_pan);
        iv_game_food = (ImageView)this.findViewById(R.id.iv_game_food);
        iv_game_boat = (ImageView)this.findViewById(R.id.iv_game_boat);
        moodTool = new MoodTool();
		Intent intent = getIntent();
		moodID = intent.getIntExtra("mood", 0);
		mood = moodTool.getMood(moodID);
		iv_game_food.setImageResource(mood.getGamePicture());
		shakeNumber = mood.getShakeNumber();
		boatAnimation = new AnimationBoat(iv_game_boat, shakeNumber);		//test
		boatAnimation.drawAnimation(num);
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		lastShakeTime = System.currentTimeMillis();
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
	public void onSensorChanged(SensorEvent event) 
	{
		int sensorType = event.sensor.getType();
		float[] values = event.values;
		if(sensorType == Sensor.TYPE_ACCELEROMETER)
		{
			if((Math.abs(values[0]) > GRAVITY * mood.getGravityTime() || Math.abs(values[1]) > GRAVITY * mood.getGravityTime() || Math.abs(values[2]) > GRAVITY * mood.getGravityTime()))
			{
				long currentShakeTime = System.currentTimeMillis();
				if(num > shakeNumber)
				{
					Intent intent = new Intent(ActivityGame.this, ActivityEndTransfer.class);
					intent.putExtra("mood", moodID);
					startActivity(intent);
					onStop();
					finish();
				}
				else if(currentShakeTime - lastShakeTime > 400)
				{
					num++;
					tv_game_shaketime.setText("р║ак"+num+"об");			//test
					AnimationPan panAnimation = new AnimationPan(iv_game_pan);
					AnimationFood foodAnimation = new AnimationFood(iv_game_food);
					panAnimation.drawAnimation();
					foodAnimation.drawAnimation();
					boatAnimation.drawAnimation(num);
					lastShakeTime = currentShakeTime;
				}
			}
		}
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}
}
