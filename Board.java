/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */
 
public class Board // this declares the function board
{ 

	String column[] = {"1","2","3","4","5","6","7","8"};
	String row[] = {"A","B","C","D","E","F","G","H"};
	
	Squares squares[][]  = new Squares[8][8]; 
	
	public Board()
	{
        initSq();	
        initColor();
	}
	
	public void initSq()
	{
		for (int i =0; i<8; i++)
		{
			for(int j=0;j<8;j++)
			{
				squares[i][j]= new Squares(i,j);
				squares[i][j].setRow(i);
				squares[i][j].setColumn(j);
				squares[i][j].setId(row[i] + column[j]);
								
                //System.out.println(squares[i][j].getRow());
                //System.out.println(squares[i][j].getColumn());
			}
			
		}
				
    }

	public void initColor()
	{		
		for (int i =0; i < 8; i++)
		{
			for (int j =0; j < 8; j++)
			{
				if ((i + j) % 2 == 0) 
				{ 
                    squares[i][j].setColor(1); 
				} 
				else
				{ 
                    squares[i][j].setColor(0); 
				} 
			}
		} 
	}
		
    //This function gets the row and column of the board that hold the piece 
    //enter. 
   public Squares getSquares(Piece x) 
    {
        for (int i =0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {
                if (x.getRow()==squares[i][j].getRow() 
                    && x.getColumn()==squares[i][j].getColumn())
			                             
                    return squares[i][j];
            }
                
            }
             return null;
    } 
	
    // This function returns the piece when the square it's on is called
    public Squares getSqs(String s) 
    {
        for (int i =0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {
                if (squares[i][j].getId().equals(s))                             
                    return squares[i][j];
            }
		
        }
             
        return null;
    } 

    public Squares locateSq(String s)
	{
			
		for (int i =0; i < 8; i++)
		{
			for(int j=0;j < 8;j++)
			{
				if(s.equals(squares[i][j].getId()))
					return squares[i][j];
			}
				
		}
			return null;
	};
		
	public Squares locateSq(int row, int col)
	{
		for (int i =0; i < 8; i++)
		{
			for(int j=0;j < 8;j++)
			{
				if((row == squares[i][j].getRow()) 
                    && (col == squares[i][j].getColumn()))

					return squares[i][j];
			}
				
        }
			return null;
    };

	private void  setBoardSquareColors(Squares colorSquare)
    {
		// checks to see if square is on column 0,2,4,6
        // if so then set the square color to WHITE
        // else set the color to BLACK
        if ((colorSquare.getColumn() % 2) == 0)
        {
            colorSquare.setColor(0);
        }
        else 
        {
            colorSquare.setColor(1);
        }

        if((colorSquare.getColumn() % 2) == 1)
        {
            colorSquare.setColor(0);
        }
        else
        {
            colorSquare.setColor(1);
        }
    }	 

    public String toString() // Converts board to string
	{
        String s = "";

		for (int i =0; i < 8; i++)
		{     
			for(int j=0;  j < 8;j++)
			{
                String w = squares[i][j].id;
				
                 s = s + squares[i][j].toString();
			}
			
		}

		return s; //This puts spacing in the columns and returns 
        //the board as a string 
	}
}

