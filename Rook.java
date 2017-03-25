/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010move
 */

public class Rook extends Piece{

	
	boolean move(Piece mRook, Squares fromSq, Squares toSq) {
		
		if((fromSq.getColumn()==toSq.getColumn()) || (fromSq.getRow()==toSq.getRow()))
		{
			mRook.setRow(toSq.getRow());
			mRook.setColumn(toSq.getColumn());
			return true;
		}
		return false;
	}
	
	
	Rook()
	{
		super();
	}
}
