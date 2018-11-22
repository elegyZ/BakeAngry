package transferPage;

import com.app.bakeangry.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import gamePage.ActivityGame;
import modePage.Mood;
import tool.MoodTool;

public class ActivityStartTransfer extends Activity 
{
	private ImageView iv_starttransf_food;
	private Button bt_starttransf_start;
	private MoodTool moodTool;
	private int moodID;
	private Mood mood;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_transfer);
		bt_starttransf_start = (Button)this.findViewById(R.id.bt_starttransf_start);
		iv_starttransf_food = (ImageView)this.findViewById(R.id.iv_starttransf_food);
		moodTool = new MoodTool();
		Intent intent = getIntent();
		moodID = intent.getIntExtra("mood", 0);
		mood = moodTool.getMood(moodID);
		
		iv_starttransf_food.setImageResource(mood.getStartPicture());
		
		OnClickListener lst_starttransf_start = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent intent = new Intent(ActivityStartTransfer.this, ActivityGame.class);
				intent.putExtra("mood", moodID);
				startActivity(intent);
			}			
		};bt_starttransf_start.setOnClickListener(lst_starttransf_start);
	}
}
