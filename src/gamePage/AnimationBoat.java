package gamePage;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class AnimationBoat 
{
	private final static float START_X = -0.7f;
	private final static float END_X = 1f;
	private final static float START_Y = 0.0f;
	private final static float END_Y = 0.0f;
	private ImageView boatImage;
	private TranslateAnimation boatAnimation;
	private float unitX;
	private float lastX;
	private float nextX;
	
	public AnimationBoat(ImageView boatImage, int times)
	{
		this.boatImage = boatImage;
		unitX = (END_X - START_X) / ++times;
		lastX = START_X;
	}
	
	public void drawAnimation(int countTime)
	{
		//x.start, x.end, y.start, y.end
		if(countTime == 0)
		{	
			boatAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, START_X, Animation.RELATIVE_TO_SELF, START_X, 
					   Animation.RELATIVE_TO_SELF, START_Y, Animation.RELATIVE_TO_SELF, END_Y);
			boatAnimation.setDuration(0);
			boatAnimation.setFillAfter(true);
			boatImage.setAnimation(boatAnimation);
		}
		else
		{
			nextX = lastX + unitX;
			boatAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, lastX, Animation.RELATIVE_TO_SELF, nextX, 
												   Animation.RELATIVE_TO_SELF, START_Y, Animation.RELATIVE_TO_SELF, END_Y);
			boatAnimation.setInterpolator(new LinearInterpolator());
			boatAnimation.setDuration(400);
			boatAnimation.setFillAfter(true);
			boatImage.setAnimation(boatAnimation);
			lastX += unitX;
		}
	}
	
	public void stopAnimation()
	{
		boatImage.clearAnimation();
	}
}
