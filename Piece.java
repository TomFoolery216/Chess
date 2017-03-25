/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */

public class Piece
{
	Piece pieces[] = new Piece[32];
	
	private String name;
	private String players;
	private int row;
	private int column;
	public String id;
	public String color;
	private Squares pieceSquare;
	
	
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------

	public void setId(String x)
	{
		id = x;
	}
	
	public String getId()
	{
		return id;
	}
	
	public boolean movePiece(Piece x,  Squares fromSq, Squares toSq)
	{
	
	return false;
		
	}
	

//------------------------------------------------------------------------------------------------
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
//----------------------------------------------------------------------------------------------------	
	public void setColor(String c)
	{
		color = c;
	}
	
	public String getColor()
	{
		return color;
	}
//-----------------------------------------------------------------------------------------------------------
	public void setPlayers(String p)
	{
		players = p;
	}
	
	public String getPlayers()
	{
		return players;
	}
	
	public void setSquare(Squares squares)
    {
        pieceSquare = squares;
    }
    
//-----------------------------------------------------------------------------------------------------------------
	public void setColumn(int c)
	{
		column = c;
	}
	
	public int getColumn()
	{	
		return column;
	}

	public void setRow(int r)
	{	
		row = r;
	}
	
	public int getRow()
	{
		return row; 
	}
//---------------------------------------------------------------------------------------------------------------------	

//--	
	public String toString()
	{
		return "\nPiece Player   = "+ getPlayers()+ "\n" + "Piece Info      = " + getName() +"\n"+ "Piece Color    = " + getColor() +"\n" + "Piece Row      = " + getRow() + "\n" + "Piece Column = " + getColumn() + "\n  " ;
	}
	
	
}



