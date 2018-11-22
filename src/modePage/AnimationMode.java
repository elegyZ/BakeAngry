package modePage;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import transferPage.ActivityStartTransfer;

public class AnimationMode 
{	
	private ImageView iv_mode_vertical;
	private Activity activity;
	private int moodID;
	private float height;
	
	public AnimationMode(Activity activity, ImageView iv_mode_vertical, ImageView iv_mode_horizontal)
	{
		this.activity = activity;
		this.iv_mode_vertical = iv_mode_vertical;
	}
	
	public void setMood(int mood, float height)
	{
		this.moodID = mood;
		this.height = height;
	}
	
	public void drawAnimation()
	{
		//drawVertical();
		//drawHorizontal();
		ScaleAnimation verticalAnimation = new ScaleAnimation(1f, 0.8f, 1f, height, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
		verticalAnimation.setInterpolator(new DecelerateInterpolator());
		verticalAnimation.setDuration(400);
		verticalAnimation.setFillAfter(true);
		iv_mode_vertical.setAnimation(verticalAnimation);
		
		AnimationListener animatorListener = new AnimationListener()
        {
			@Override
			public void onAnimationEnd(Animation animation) 
			{
				Intent intent = new Intent(activity, ActivityStartTransfer.class);
            	intent.putExtra("mood", moodID);
            	activity.startActivity(intent);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationStart(Animation animation) {}
        };
        
        verticalAnimation.setAnimationListener(animatorListener);
        
	}
	
	public void drawVertical()
	{
		ScaleAnimation verticalAnimation = new ScaleAnimation(1f, 0.8f, 1f, height, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
		verticalAnimation.setInterpolator(new DecelerateInterpolator());
		verticalAnimation.setDuration(250);
		verticalAnimation.setFillAfter(true);
		iv_mode_vertical.setAnimation(verticalAnimation);
	}
	
	public void drawHorizontal()
	{
		
		
	}
	
	public void stopAnimation()
	{
		iv_mode_vertical.clearAnimation();
	}
}
