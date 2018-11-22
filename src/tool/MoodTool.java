package tool;

import java.util.ArrayList;
import java.util.List;

import com.app.bakeangry.R;

import modePage.Mood;

public class MoodTool 
{
	private List<Mood> moodList;
	
	public MoodTool()
	{
		moodList = new ArrayList<Mood>();
		Mood mope = new Mood("mope", 5, R.drawable.egg_start, R.drawable.egg, R.drawable.egg_end);	
		Mood upset = new Mood("upset", 10, R.drawable.coffee_start, R.drawable.coffee, R.drawable.coffee_end);
		Mood annoy = new Mood("annoy", 15, R.drawable.sushi_start, R.drawable.sushi, R.drawable.sushi_end);
		Mood angry = new Mood("angry", 20, R.drawable.pancake_start, R.drawable.pancake, R.drawable.pancake_end);
		Mood rage = new Mood("rage", 25, R.drawable.steak_start, R.drawable.steak, R.drawable.steak_end);
		Mood fury = new Mood("fury", 30, R.drawable.turkey_start, R.drawable.turkey, R.drawable.turkey_end);
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
