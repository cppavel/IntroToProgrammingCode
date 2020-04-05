
public abstract class ConnectPlayer 
{
	private int discColor;
	private String playerName;
	protected static final int RED = 1;
	protected static final int YELLOW = 2;
	
	public ConnectPlayer(int discColor,String playerName)
	{
		this.discColor = discColor;
		this.playerName = playerName;
	}
	
	public int getDiscColor()
	{
		return discColor;
	}
	
	public void setDiscColor(int discColor)
	{
		if(discColor==RED||discColor==YELLOW)
		{
			this.discColor = discColor;
		}
	}
	
	public String getColorName()
	{
		switch(discColor)
		{
		case RED: return "RED";
		case YELLOW: return "YELLOW";
		default: return "ERROR";
		}
	}
	
	public String getPlayerName()
	{
		return playerName;
	}
	
	public void setPlayerName(String name)
	{
		playerName = name;
	}
		
	public String toString()
	{
		return "[discColor = "+ getColorName()+ ",playerName = " +getPlayerName() + "]";
	}
	
	public boolean integerTryParse(String line) 
	{  
		  try 
		  {  
	         Integer.parseInt(line);  
	         return true;  
	      } 
		  catch (Exception e) 
		  {  
	         return false;  
	      }  
	}
	
	abstract public void decideWhereToDrop(Connect4Grid2DArray grid) throws Exception;
		
}
