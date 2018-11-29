package gamePage;

import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class AnimationPan 
{
	private ImageView panImage;
	private RotateAnimation panAnimation;
	
	public AnimationPan(ImageView panImage)
	{
		this.panImage = panImage;
	}
	
	public void drawAnimation()
	{
		panAnimation = new RotateAnimation(-10, 20,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		panAnimation.setInterpolator(new LinearInterpolator());
		panAnimation.setDuration(200);						//last time 
		panAnimation.setRepeatCount(2);
		panAnimation.setRepeatMode(AnimationSet.REVERSE);
		panAnimation.setFillAfter(false);
		panImage.startAnimation(panAnimation);
	}
	
	public void stopAnimation()
	{
		panImage.clearAnimation();
	}

}
