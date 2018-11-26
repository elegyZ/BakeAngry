package tool;

import com.app.bakeangry.R;

import android.app.Activity;
import android.media.MediaPlayer;

public class MusicTool 
{
	private static MediaPlayer mediaPlayer;
	
	public static void playMusic(Activity activity)
	{
		mediaPlayer=MediaPlayer.create(activity, R.raw.bgm);
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
	}
	
	public static void stopMusic()
	{
		mediaPlayer.stop();
	}
}
