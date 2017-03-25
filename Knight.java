/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */

public class Knight extends Piece
{

	Knight() {
		super();
	}

	public boolean movePiece(Piece mKnight, Squares fromSq, Squares toSq){
		boolean move = false;
		//Knight moves up one and left two
		if((fromSq.getRow()== toSq.getRow()+1)&&(fromSq.getColumn()==toSq.getColumn()+2))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves up one right two 
		if((fromSq.getRow()== toSq.getRow()+1)&&(fromSq.getColumn()==toSq.getColumn()-2))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves up two and left one
		if((fromSq.getRow()== toSq.getRow()+2)&&(fromSq.getColumn()==toSq.getColumn()+1))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves up two and right one
		if((fromSq.getRow()== toSq.getRow()+2)&&(fromSq.getColumn()==toSq.getColumn()-1))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves back one and left two
		if((fromSq.getRow()== toSq.getRow()-1)&&(fromSq.getColumn()==toSq.getColumn()+2))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves back one and right two
		if((fromSq.getRow()== toSq.getRow()-1)&&(fromSq.getColumn()==toSq.getColumn()-2))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves back two and left one
		if((fromSq.getRow()== toSq.getRow()-2)&&(fromSq.getColumn()==toSq.getColumn()-1))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		// Knight moves back two and right one
		if((fromSq.getRow()== toSq.getRow()-2)&&(fromSq.getColumn()==toSq.getColumn()-2))
		{
			mKnight.setRow(toSq.getRow());
			mKnight.setColumn(toSq.getColumn());
			move = true;
		}
		return move;
	}



	
}


