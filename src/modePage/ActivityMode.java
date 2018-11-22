package modePage;

import com.app.bakeangry.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityMode extends Activity 
{
	private AnimationMode animation;
	private ImageView iv_mode_vertical;
	private ImageView iv_mode_horizontal;
	private ImageView iv_mode_thermometer;
	private Button bt_mode_mope;
	private Button bt_mode_upset;
	private Button bt_mode_annoy;
	private Button bt_mode_fury;
	private Button bt_mode_angry;
	private Button bt_mode_rage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mode);
		bt_mode_mope = (Button)this.findViewById(R.id.bt_mode_mope);
		bt_mode_upset = (Button)this.findViewById(R.id.bt_mode_upset);
		bt_mode_annoy = (Button)this.findViewById(R.id.bt_mode_annoy);
		bt_mode_fury = (Button)this.findViewById(R.id.bt_mode_fury);
		bt_mode_angry = (Button)this.findViewById(R.id.bt_mode_angry);
		bt_mode_rage = (Button)this.findViewById(R.id.bt_mode_rage);
		iv_mode_vertical = (ImageView)this.findViewById(R.id.iv_mode_vertical);
		iv_mode_thermometer = (ImageView)this.findViewById(R.id.iv_mode_thermometer);
		animation = new AnimationMode(this, iv_mode_vertical, iv_mode_horizontal);
		
		OnClickListener lst_mode_mope = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(0, 11.2f);
				animation.drawAnimation();
			}
		};bt_mode_mope.setOnClickListener(lst_mode_mope);
		
		OnClickListener lst_mode_upset = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(1, 11.2f);
				animation.drawAnimation();
			}
		};bt_mode_upset.setOnClickListener(lst_mode_upset);
		
		OnClickListener lst_mode_annoy = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(2, 11.2f);
				animation.drawAnimation();
			}
		};bt_mode_annoy.setOnClickListener(lst_mode_annoy);

		OnClickListener lst_mode_angry = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(3, 11.2f);
				animation.drawAnimation();
			}
		};bt_mode_angry.setOnClickListener(lst_mode_angry);
		
		OnClickListener lst_mode_fury = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(4, 11.2f);
				animation.drawAnimation();
			}
		};bt_mode_fury.setOnClickListener(lst_mode_fury);
		
		OnClickListener lst_mode_rage = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				iv_mode_thermometer.bringToFront();
				animation.setMood(5, 11.2f);
				animation.drawAnimation();
			}
		};bt_mode_rage.setOnClickListener(lst_mode_rage);
	}
}
