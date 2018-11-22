package mainPage;

import com.app.bakeangry.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import modePage.ActivityMode;

public class MainActivity extends Activity 
{
	private Button bt_main_start;
	private ImageView iv_main_pan;
	private ImageView iv_main_fire;
	private AnimationPan animationPan;
	private AnimationFire animationFire;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt_main_start = (Button)this.findViewById(R.id.bt_main_start);
		iv_main_pan = (ImageView)this.findViewById(R.id.iv_main_pan);
		iv_main_fire = (ImageView)this.findViewById(R.id.iv_main_fire);
		animationPan = new AnimationPan(iv_main_pan);
		animationFire = new AnimationFire(iv_main_fire);
		animationPan.drawAnimation();
		animationFire.drawAnimation();
		
		OnClickListener lst_main_start = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				//animationPan.stopAnimation();
				Intent intent = new Intent(MainActivity.this, ActivityMode.class);
				startActivity(intent);
			}
		};bt_main_start.setOnClickListener(lst_main_start);
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
