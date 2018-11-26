package tool;

import java.util.ArrayList;
import java.util.List;

import com.app.bakeangry.R;

public class MoodTool 
{
	private List<Mood> moodList;
	
	public MoodTool()
	{
		moodList = new ArrayList<Mood>();
		Mood mope = new Mood("mope", 5, R.drawable.tea_start, R.drawable.tea, R.drawable.tea_end, R.id.iv_mode_mope);	
		Mood upset = new Mood("upset", 10, R.drawable.egg_start, R.drawable.egg, R.drawable.egg_end, R.id.iv_mode_upset);
		Mood annoy = new Mood("annoy", 15, R.drawable.baozi_start, R.drawable.baozi, R.drawable.baozi_end, R.id.iv_mode_annoy);
		Mood angry = new Mood("angry", 20, R.drawable.crab_start, R.drawable.crab, R.drawable.crab_end, R.id.iv_mode_angry);
		Mood rage = new Mood("rage", 25, R.drawable.dongporou_start, R.drawable.dongporou, R.drawable.dongporou_end, R.id.iv_mode_fury);
		Mood fury = new Mood("fury", 30, R.drawable.hotpot_start, R.drawable.hotpot, R.drawable.hotpot_end, R.id.iv_mode_rage);
		moodList.add(mope);
		moodList.add(upset);
		moodList.add(annoy);
		moodList.add(angry);
		moodList.add(rage);
		moodList.add(fury);
	}

	public Mood getMood(int i)
	{
		return moodList.get(i);
	}
}
