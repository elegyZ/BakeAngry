package com.elegy.bakeangry;

import com.app.bakeangry.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import mainPage.AnimationLion;

public class MainActivity extends BaseActivity 
{
	private ImageView iv_main_lion;
	private AnimationLion animationLion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		iv_main_lion = (ImageView)this.findViewById(R.id.iv_main_lion);
		animationLion = new AnimationLion(this, iv_main_lion);
		animationLion.drawAnimation();
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
