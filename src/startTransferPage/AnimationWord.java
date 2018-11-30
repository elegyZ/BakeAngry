package startTransferPage;

import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

public class AnimationWord 
{
	private TextView shakeText;
	private RotateAnimation shakeAnimation;
	
	public AnimationWord(TextView shakeText)
	{
		this.shakeText = shakeText;
	}
	
	public void drawAnimation()
	{
		shakeAnimation = new RotateAnimation(45, -45,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.75f);
		shakeAnimation.setInterpolator(new LinearInterpolator());
		shakeAnimation.setDuration(200);						//last time 
		shakeAnimation.setRepeatCount(4);
		shakeAnimation.setRepeatMode(AnimationSet.REVERSE);
		shakeText.startAnimation(shakeAnimation);
	}
	
	public void stopAnimation()
	{
		shakeText.clearAnimation();
	}
}
