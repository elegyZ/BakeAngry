package tool;

public class Mood 
{
	private String moodName;
	private int shakeNumber;
	private int stainPicture;
	private int startPicture; 
	private int gamePicture; 
	private int endPicture; 
	
	public Mood(String moodName, int shakeNumber, int startPicture, int gamePicture, int endPicture, int stainPicture)
	{
		this.moodName = moodName;
		this.shakeNumber = shakeNumber;
		this.startPicture = startPicture;
		this.gamePicture = gamePicture;
		this.endPicture = endPicture;
		this.stainPicture = stainPicture;
	}
	
	public void setMoodName(String moodName)
	{
		this.moodName = moodName;
	}
	
	public void setShakeNumber(int shakeNumber)
	{
		this.shakeNumber = shakeNumber;
	}
	
	public void setStartPicture(int startPicture)
	{
		this.startPicture = startPicture;
	}
	
	public void setGamePicture(int gamePicture)
	{
		this.gamePicture = gamePicture;
	}
	
	public void setEndPicture(int endPicture)
	{
		this.endPicture = endPicture;
	}
	
	public void setStainPicture(int stainPicture)
	{
		this.stainPicture = stainPicture;
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
}
