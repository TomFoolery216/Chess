/*
 * ChessGame
 * 11SP-CSIS-345-01 OBJ ORINTD PROGRAMNG USNG JAVA
 * Kyle X. Naylor, February 20, 2010
 */

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Game
{
    //inits varbles

	private String turn;
	private String piece;
	private String square;

	Piece pieces[] = new Piece[32];
	Player player[] = new Player[2];
	Board board = new Board();
	Player turnPlayer = new Player();
	
    //Squares squares = new Squares();
	
    //This makes an array of players 
	public void initPlayer() 
	{
		for (int i = 0; i < 2; i++)
		{
			player [i] = new Player();
		}

		player[0].setColor("White");
		player[1].setColor("Black");
		turnPlayer = player[0]; 
		player[0].setTurn(0);
		player[1].setTurn(1);

	}

	public void initPiece()
	{ 

        for (int i =0; i < 1; i++)
        { 
            // This is an array of pieces 32 are created. 
            //Each piece catagory is set to a name, 
            //color, player, row and column. 

            pieces[i] = new King();
            pieces[i].setName("King");
            pieces[i].setColor("White");
            pieces[i].setPlayers("One");
            pieces[i].setRow(0);
            pieces[i].setColumn(3);
            
        }

        for (int i =1; i < 2; i++)
        {
            pieces[i] = new Queen();
            pieces[i].setName("Queen");
            pieces[i].setColor("White");
            pieces[i].setPlayers("One");	
            pieces[i].setRow(0);
            pieces[i].setColumn(4);
            
        }

        for (int i =2; i < 4; i++)
        {
            pieces[i] = new Bishop();
            pieces[i].setName("Bishop");
            pieces[i].setColor("White");
            pieces[i].setPlayers("One");	
            pieces[i].setRow(0);		
            pieces[i].setColumn(4*(i-2)+1);
        }

        for (int i =4; i < 6; i++)
        {
            pieces[i] = new Knight();
            pieces[i].setName("Knight");
            pieces[i].setColor("White");
            pieces[i].setPlayers("One");	
            pieces[i].setRow(0);
            pieces[i].setColumn(1);
            pieces[i].setColumn(5*(i-4)+1);	
        }
        
        for (int i =6; i < 8; i++)
        {
            pieces[i] = new Rook();
            pieces[i].setName("Rook");
            pieces[i].setColor("White");
            pieces[i].setPlayers("One");	
            pieces[i].setRow(0);
            pieces[i].setColumn(7*(i-6));	
        }

        for (int i =8; i < 16; i++)
        {
            pieces[i] = new Pawn();
            pieces[i].setName("Pawn");
            pieces[i].setColor("White");
            pieces[i].setPlayers("One");	
            pieces[i].setRow(1);
            pieces[i].setColumn((((i-8))));
        }

        for (int i =16; i < 17; i++)
        {
            pieces[i] = new King();
            pieces[i].setName("King");
            pieces[i].setColor("Black");
            pieces[i].setPlayers("Two");	
            pieces[i].setRow(7);
            pieces[i].setColumn(3);
            
        }

        for (int i =17; i < 18; i++)
        {
            pieces[i] = new Queen();
            pieces[i].setName("Queen");
            pieces[i].setColor("Black");
            pieces[i].setPlayers("Two");
            pieces[i].setRow(7);
            pieces[i].setColumn(4);		
        }

        for (int i =18; i < 20; i++)
        {
            pieces[i] = new Bishop();
            pieces[i].setName("Bishop");
            pieces[i].setColor("Black");
            pieces[i].setPlayers("Two");	
            pieces[i].setRow(7);
            pieces[i].setColumn(3*(i-18)+2);	
        }
        
        for (int i =20; i < 22; i++)
        {
            pieces[i] = new Knight();
            pieces[i].setName("Knight");
            pieces[i].setColor("Black");
            pieces[i].setPlayers("Two");	
            pieces[i].setRow(7);
            pieces[i].setColumn(4*(i-20)+1);
            
        }

        for (int i =22; i < 24; i++)
        {
            pieces[i] = new Rook();
            pieces[i].setName("Rook");
            pieces[i].setColor("Black");
            pieces[i].setPlayers("Two");	
            pieces[i].setRow(7);
            pieces[i].setColumn(7*(i-22));
        }

        for (int i =24; i < 32; i++)
        {
            pieces[i] = new Pawn();
            pieces[i].setName("Pawn");
            pieces[i].setColor("Black");
            pieces[i].setPlayers("Two");	
            pieces[i].setRow(6);
            pieces[i].setColumn((((((i-24))))));
        }

    }		
	//======================================================================

    public void setTurn (String t)
	{
		turn = t;
	}
	
	public String getTurn ()
	{
		return turn;
	}
	
	public void loadGame(Game game)
	{
		GameDA.initialize(game);
	}
	
	public void saveGame(Game game)
	{
		GameDA.terminate(game);
	}
	
    // This function returns the piece when the square it's on is called
	public Piece getPiece(Squares x) 
    {
        for (int i =0; i < 32; i++)
        {
            if (x.getRow()==pieces[i].getRow() 
            && x.getColumn()==pieces[i].getColumn())
            {			
                return pieces[i];
            }
       }
             
        return null;
    } 
    
	public Squares getSqs(String s)
    {
	    return board.getSqs(s);
    }
    
    // This passes error messages to the tester if the user makes a mistake
    public void selectSquare(Piece piece, Squares squares, Squares squares2) 
    throws InvalidMoveException
	{
        try
        {
            if(getPiece(squares) == null)
            {
                InvalidMoveException exeception = 
                new InvalidMoveException("\nPiece is not on the Square yo!");
            
                throw exeception;

            }
        
            System.out.println(turnPlayer.getColor());
            System.out.println(piece.getColor());
		
            if(turnPlayer.getColor() != piece.getColor())
            {
                InvalidMoveException exeception = 
                new InvalidMoveException("\nIt is not yo turn yo!");

                throw exeception;
            }  
			
            if(piece.movePiece(piece, squares, squares2) == false)
            {
                InvalidMoveException exeception = 
                new InvalidMoveException("\nThat Piece can not be moved yo!");

                throw exeception;
            }
                
            turnPlayer=player[((turnPlayer.getTurn() +1) % 2)];
            System.out.println(turnPlayer.getTurn());
            System.out.println(turnPlayer.getColor());
		
        }
        catch(InvalidMoveException e)
        {	
            throw e;
        }
		    
	} 

	// This passes error messages to the tester if the user makes a mistake
	public boolean pickUpPiece(Piece piece, Squares squares, Squares squares2) 
    throws InvalidMoveException
	{

        try
        {
            if(getPiece(squares) == null)
            {
                InvalidMoveException exeception = 
                new InvalidMoveException("\nPiece is not on the Square yo!");

                throw exeception;
            }
        
            System.out.println(turnPlayer.getColor());
            ChessUI2.moveLog(turnPlayer.getColor());

            if(turnPlayer.getColor() != piece.getColor())
            {
                InvalidMoveException exeception = 
                new InvalidMoveException("\nIt is not yo turn yo!");

                throw exeception;
            }  
			
            if(piece.movePiece(piece, squares, squares2) == false)
            {
                InvalidMoveException exeception = 
                new InvalidMoveException("\nThat Piece can not be moved yo!");

                throw exeception;
                        
            }
                
            turnPlayer=player[((turnPlayer.getTurn() +1) % 2)];
            System.out.println(turnPlayer.getTurn());
            System.out.println(turnPlayer.getColor());
		
            //ChessUI2.moveLog(turnPlayer.getTurn());
            ChessUI2.moveLog(turnPlayer.getColor());
        }
        catch(InvalidMoveException e)
        {	
            throw e;
        }
			
			return true;
		    
	} 

	public String toString()
	{
        String s = "";
		s =  s +  player[0]+ "\n" + player[1];  
		return s;
	}

}

