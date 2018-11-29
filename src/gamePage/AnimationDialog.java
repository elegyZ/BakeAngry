package gamePage;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class AnimationDialog 
{
	private final static float START_ALPHA = 0;
	private final static float END_ALPHA = 1;
	private ImageView dialogImage;
	private AlphaAnimation dialogAnimation;
	
	public AnimationDialog(ImageView dialogImage)
	{
		this.dialogImage = dialogImage;
	}
	
	public void drawAnimation()
	{
		dialogAnimation = new AlphaAnimation(START_ALPHA, END_ALPHA);
		dialogAnimation.setInterpolator(new LinearInterpolator());
		dialogAnimation.setDuration(1000);
		dialogAnimation.setFillAfter(true);
		dialogImage.setAnimation(dialogAnimation);
		
		AnimationListener animatorListener = new AnimationListener()
        {
			@Override
			public void onAnimationStart(Animation animation) 
			{
				dialogImage.setVisibility(ImageView.VISIBLE);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationEnd(Animation animation) {}
        };
        
        dialogAnimation.setAnimationListener(animatorListener);
	}
	
	public void stopAnimation()
	{
		dialogImage.clearAnimation();
	}
}
