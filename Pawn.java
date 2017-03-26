/*
 
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */


public class Pawn extends Piece
{
	public boolean movePiece(Piece x,  Squares fromSq, Squares toSq)
	{
	
	if(x.getColor()=="White" && x.getRow()==1  && fromSq.getColumn() == toSq.getColumn() )// This moves the pawn if it is on row one So the piece can move +2
		{
			if(toSq.getRow() == fromSq.getRow() + 1)
			{
			x.setRow(x.getRow()+1 );
			}
			if(toSq.getRow() == fromSq.getRow() + 2)
			{
			x.setRow(x.getRow()+2 );
			}
		}

	if(x.getColor()=="White" && fromSq.getColumn() == toSq.getColumn())
		{
			x.setRow(toSq.getRow());
		}

	if(x.getColor()=="Black" && x.getRow()==6  && fromSq.getColumn() == toSq.getColumn())// This moves the pawn if it is on row six. So the piece can move -2
		{
			if(toSq.getRow() == fromSq.getRow() - 1)
			{
			x.setRow(x.getRow()-1 );
			}
			if(toSq.getRow() == fromSq.getRow() - 2)
			{
			x.setRow(x.getRow()-2 );
			}
		}

	if(x.getColor()=="Black" && fromSq.getColumn() == toSq.getColumn())
		{
			x.setRow(toSq.getRow());
		}
		return true;
	}
	
}
 
