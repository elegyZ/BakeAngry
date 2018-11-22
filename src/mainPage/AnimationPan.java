package mainPage;

import android.view.animation.DecelerateInterpolator;
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
		panAnimation.setInterpolator(new DecelerateInterpolator());
		panAnimation.setDuration(850);						//last time 
		panAnimation.setRepeatCount(RotateAnimation.INFINITE);
		panAnimation.setFillAfter(true);
		panImage.startAnimation(panAnimation);
	}
	
	public void stopAnimation()
	{
		panImage.clearAnimation();
	}

}
