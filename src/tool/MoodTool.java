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
		Mood mope = new Mood("mope", 5, R.drawable.tea_start, R.drawable.tea, R.drawable.tea_end, R.id.iv_mode_mope,
							"Try To Boil A Pot Of Tea\nUsing Your Mope Energy!", 
							"Wow, you have used your Bad mood to Boil the Tea!!\nWell Done!!", 2);	
		Mood upset = new Mood("upset", 10, R.drawable.baozi_start, R.drawable.baozi, R.drawable.baozi_end, R.id.iv_mode_upset,
							"Can You Steam The Bun?\nUsing Your Upset Energy!", 
							"Wow, you have used your upset energy to Steam The Bun!!\nExcellent!!", 2);
		Mood annoy = new Mood("annoy", 15, R.drawable.zongzi_start, R.drawable.zongzi, R.drawable.zongzi_end, R.id.iv_mode_annoy,
							"Release Your Annoyance To Cook Some Delicious Rice Dumpling!", 
							"Wow, you have used your Annoyance to Cook The Rice Dumpling!!\nExcellent!!", 4);
		Mood angry = new Mood("angry", 20, R.drawable.crab_start, R.drawable.crab, R.drawable.crab_end, R.id.iv_mode_angry,
							"Your Anger Is The Best Fuel To Bake The Crab!!", 
							"Wow, you have used your Anger to Bake The Crab!!\nWell Done!!", 4);
		Mood rage = new Mood("rage", 25, R.drawable.dongporou_start, R.drawable.dongporou, R.drawable.dongporou_end, R.id.iv_mode_fury, 
							"Awesome!\nSeems Your Rage Can Bake Some Dongpo Pork!", 
							"Wow, you have used your Rage to Bake The Dongpo Pork!!\nGood Job!!", 6);
		Mood fury = new Mood("fury", 30, R.drawable.hotpot_start, R.drawable.hotpot, R.drawable.hotpot_end, R.id.iv_mode_rage, 
							"Wow, Let Out Your Fury And Burn The Hotpot!!", 
							"Wow, you have used your Fury to Boil The Hotpot!!\\nGood Job!!", 6);
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
