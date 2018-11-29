package modePage;

import com.elegy.bakeangry.ActivityStartTransfer;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import tool.Mood;
import tool.MoodTool;

public class AnimationMode 
{	
	private ImageView iv_mode_vertical;
	private Activity activity;
	private int moodID;
	private Mood mood;
	private float height;
	
	public AnimationMode(Activity activity, ImageView iv_mode_vertical, ImageView iv_mode_horizontal)
	{
		this.activity = activity;
		this.iv_mode_vertical = iv_mode_vertical;
	}
	
	public void setMood(int moodID, float height)
	{
		MoodTool moodTool = new MoodTool();
		this.moodID = moodID;
		this.mood = moodTool.getMood(moodID);
		this.height = height;
	}
	
	public void drawAnimation()
	{
		ScaleAnimation verticalAnimation = new ScaleAnimation(1f, 0.8f, 1f, height, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
		verticalAnimation.setInterpolator(new DecelerateInterpolator());
		verticalAnimation.setDuration(500);
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
	
	public void drawStain()
	{
		ImageView stain = (ImageView)activity.findViewById(mood.getStainPicture());
		ScaleAnimation stainAnimation = new ScaleAnimation(1f, 100f, 1f, 100f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
		stainAnimation.setInterpolator(new DecelerateInterpolator());
		stainAnimation.setDuration(50);
		stainAnimation.setFillAfter(true);
		stain.setAnimation(stainAnimation);
		
		AnimationListener animatorListener = new AnimationListener()
        {
			@Override
			public void onAnimationEnd(Animation animation) 
			{
				drawAnimation();
			}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationStart(Animation animation) {}
        };
        
        stainAnimation.setAnimationListener(animatorListener);
	}
	
	public void stopAnimation()
	{
		ImageView stain = (ImageView)activity.findViewById(mood.getStainPicture());
		stain.clearAnimation();
	}
}
