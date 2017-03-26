/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */

public class Squares
{

	public String id;
	private int row;
	private int column;
	private int color;
	
//----------------------------------------------------------------------------
	Squares(int r, int c)
	{
		row = r;
		column = c;
		String rowID = Integer.toString(r);
		String columnID = Integer.toString(c);
		id = rowID + columnID ;
		setRow(r);
		setColumn(c);
	}

//--------------------------------------------------------------------------

	public void setId(String x)
	{
		id = x;
	}	
	
    // get function to return the value for column
	public String getId()
	{
		return id;
	}
	
	public void setColumn(int c)
	{
		column = c;
	}	
	
    // get function to return the value for column
	public int getColumn()
	{
		return column;
	}
	
    // set function to set the value for row
	public void setRow(int r)
	{
		row = r;
	}
	
    // get function to return the value of row
	public int getRow()
	{
		return row;
	}
	
	public void setColor(int c)
	{
		color = c;
	}
	
	public int getColor()
	{
		//color = row + column % 2;
		return color;
	}
	
    public String toString()
	{
		return  "\t \nSq Row=" + getRow() 
        + "\t"+ "\nSq Column=" + getColumn() 
        + "\t"+ "\nPiece ID:" + getId() 
        +"\n";
 	}
	
}
	
