package gamePage;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class AnimationFood 
{
	private ImageView foodImage;
	private TranslateAnimation foodAnimation;
	
	public AnimationFood(ImageView foodImage)
	{
		this.foodImage = foodImage;
	}
	
	public void drawAnimation()
	{
		//x.start, x.end, y.start, y.end
		foodAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1f);
		foodAnimation.setInterpolator(new LinearInterpolator());
		foodAnimation.setDuration(200);						//last time 
		foodAnimation.setRepeatCount(2);
		foodAnimation.setRepeatMode(AnimationSet.REVERSE);
		foodAnimation.setFillAfter(false);
		foodImage.setAnimation(foodAnimation);
	}
	
	public void stopAnimation()
	{
		foodImage.clearAnimation();
	}
}
