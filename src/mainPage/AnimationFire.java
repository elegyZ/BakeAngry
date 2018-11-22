package mainPage;

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class AnimationFire 
{
	private ImageView fireImage;
	private TranslateAnimation fireAnimation;
	
	public AnimationFire(ImageView fireImage)
	{
		this.fireImage = fireImage;
	}
	
	public void drawAnimation()
	{
		//x.start, x.end, y.start, y.end
		fireAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.4f);
		fireAnimation.setInterpolator(new DecelerateInterpolator());
		fireAnimation.setDuration(850);
		fireAnimation.setRepeatCount(RotateAnimation.INFINITE);
		fireAnimation.setFillAfter(true);
		fireImage.setAnimation(fireAnimation);
	}
	
	public void stopAnimation()
	{
		fireImage.clearAnimation();
	}
}
