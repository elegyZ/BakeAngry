package mainPage;

import com.app.bakeangry.R;
import com.elegy.bakeangry.ActivityStart;
import android.app.Activity;
import android.content.Intent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class AnimationLion 
{
	private ImageView lionImage;
	private RotateAnimation lionAnimation;
	private Activity activity;
	
	
	public AnimationLion(Activity activity, ImageView lionImage)
	{
		this.activity = activity;
		this.lionImage = lionImage;
	}
	
	public void drawAnimation()
	{
		lionAnimation = new RotateAnimation(45, -45,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.75f);
		lionAnimation.setInterpolator(new AccelerateInterpolator());
		lionAnimation.setDuration(500);						//last time 
		lionAnimation.setRepeatCount(4);
		lionAnimation.setRepeatMode(AnimationSet.REVERSE);
		lionImage.startAnimation(lionAnimation);
		
		AnimationListener animatorListener = new AnimationListener()
        {
			@Override
			public void onAnimationEnd(Animation animation) 
			{
				Intent intent = new Intent(activity, ActivityStart.class);
            	activity.startActivity(intent);
            	activity.overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationStart(Animation animation) {}
        };
        
        lionAnimation.setAnimationListener(animatorListener);
	}
	
	public void stopAnimation()
	{
		lionImage.clearAnimation();
	}

}
