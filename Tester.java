/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */

public class Tester
{
       public static void main(String arg[])
       {	
	       //makes a object
	       Board board = new Board();
	       Game game = new Game();
	      
	//----------------------------------------------------------------------
	     
	           //function calls 
	       System.out.println("\nChessgame\n"); 
	       game.initPlayer();
	       game.initPiece();
	       board.initSq();
	 
	       game.player[1].setName("Deep Blue IBM TM");
	       game.player[0].setName("Garry Kasparov");
	       game.player[1].setColor("Black");
	       game.player[0].setColor("White");
	      
	       //prints the player array
	       System.out.println(game);
	      // System.out.println(board.squares[1][7]);
	       //System.out.println("\n");
	       //System.out.println(game.pieces[29]);
	       //System.out.println(game.pieces[31]);
	       
	       //System.out.println(board.getSquares(game.pieces[11]));
	       
		//System.out.println(squares.getId("7F"));
		
		System.out.println(board.getSqs("G6"));
		

		System.out.println(game.getPiece(board.getSqs("G6"))); // I call this just to show what the piece is on before it is moved
	 
		try
		{
		    game.selectSquare(game.pieces[29],  board.getSqs("G6"), board.getSqs("E6"));
		}
		        
	catch(Exception e)//this catches the exception that was thrown and displays the proper message that is assoicated with that exception
	{
            System.out.println(e.getMessage()); 
	
	}
	System.out.println(game.getPiece(board. squares[4][5])); 
	
	
	 System.out.println(game.getPiece(board.getSqs("B8")));
	
	
/* Board of Chess Game
	-------------------

	77  76  75  74  73  72  71  70
  
	67  66  65  64  63  62  61  60 
 
	57  56  55  54  53  52  51  50  

	47  46  45  44  43  42  41  40  

	37  36  35  34  33  32  31  30  

	27  26  25  24  23  22  21  20 
	
	17   16  15   14  13   12  11   10 
   
	07  06  05  04  03  02  01  00 */



// Should never access an objects attributes directly (player[i])
// The movePiece method does not need a piece as a parameter.  The piece is the one receiving the message.

	
	}

} 
