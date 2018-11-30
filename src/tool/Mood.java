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
		this.moodName = moodName;				//mood's type name
		this.shakeNumber = shakeNumber;			//the number of shaking times should be reach in the game part
		this.startPicture = startPicture;		//the picture show in the beginning of the game
		this.gamePicture = gamePicture;			//the food picture show in the game part
		this.endPicture = endPicture;			//the picture show in the ending of the game
		this.stainPicture = stainPicture;		//the temperature length of the thermometer
		this.startText = startText;				//the hint word show in the beginning of the game
		this.endText = endText;					//the congratulation word show in the end of the game
		this.gravityTime = gravityTime;			//the acceleration level of shaking used in the game part
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
