/*
 
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */
 
public class Player
{	
	private String name;
	private String color;
	private String players;
	private int turn;
		  
//-------------------------------------------------------------------------------	
	//construtor for player
	public Player()
	{
		setName("");
				
	}
	public void setColor(String c)
	{
	  color = c;
	}
	public String getColor()
	{ 
		
		return color;
	}
//--------------------------------------------------------------------------------------	

	
	public Player(String name)
	{
		setName(name);
	}
			
	public void setName(String n)
	{
		name = n;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setTurn(int t)
	{
		turn = t;
		
	}
	
	public int getTurn()
	{
		return turn;
	}
//--------------------------------------------------------------------------------------------
	
	public String toString()
	{
		return "\n" +  "\n" +"Name: " + getName() +  "\n" +"Color: " + getColor()+ "\n" ;
	}


}