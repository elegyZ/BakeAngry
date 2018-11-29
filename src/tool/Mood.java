package tool;

public class Mood 
{
	private String moodName;
	private int shakeNumber;
	private int stainPicture;
	private int startPicture; 
	private int gamePicture; 
	private int endPicture; 
	private String startText;
	private String endText;
	private int gravityTime;
	
	public Mood(String moodName, int shakeNumber, int startPicture, int gamePicture, int endPicture, int stainPicture, String startText, String endText, int gravityTime)
	{
		this.moodName = moodName;
		this.shakeNumber = shakeNumber;
		this.startPicture = startPicture;
		this.gamePicture = gamePicture;
		this.endPicture = endPicture;
		this.stainPicture = stainPicture;
		this.startText = startText;
		this.endText = endText;
		this.gravityTime = gravityTime;
	}
	
	public String getMoodName()
	{
		return moodName;
	}
	
	public int getShakeNumber()
	{
		return shakeNumber;
	}
	
	public int getStartPicture()
	{
		return startPicture;
	}
	
	public int getGamePicture()
	{
		return gamePicture;
	}
	
	public int getEndtPicture()
	{
		return endPicture;
	}
	
	public int getStainPicture()
	{
		return stainPicture;
	}
	
	public String getStartText()
	{
		return startText;
	}
	
	public String getEndText()
	{
		return endText;
	}
	
	public int getGravityTime()
	{
		return gravityTime;
	}
}
