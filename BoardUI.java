import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardUI extends JPanel implements MouseListener
{
    protected SquareUI [][] showBoard;
    protected Board board = new Board();
    protected Game game = new Game();

   // String curDir = "/home/kxnaylor/Chess/";

    String curDir = getClass().getProtectionDomain()
    .getCodeSource().getLocation().getPath();
        
    boolean clicked = true;

    Component components[]; 

    Piece piece;
    Squares from, to;
             
    private ImageIcon pawn0imj = new ImageIcon(curDir + "/pawn0.jpg");
    private ImageIcon pawn1imj =  new ImageIcon(curDir + "/pawn1.jpg");
    private ImageIcon wKingimj = new ImageIcon(curDir + "/whiteKing.jpg");
    private ImageIcon bKingimj = new ImageIcon(curDir + "/blackKing.jpg");
    private ImageIcon wQueenimj = new ImageIcon(curDir + "/whiteQueen.jpg");
    private ImageIcon bQuennimj = new ImageIcon(curDir + "/blackQueen.jpg");
    private ImageIcon wRookimj =  new ImageIcon(curDir + "/whiteRook.jpg");
    private ImageIcon bRookimj = new ImageIcon(curDir + "/blackRook.jpg");
    private ImageIcon wKightimj = new ImageIcon(curDir + "/whiteKnight.jpg");
    private ImageIcon bKightimj = new ImageIcon(curDir + "/blackKnight.jpg");
    private ImageIcon wBishopimj = new ImageIcon(curDir + "/whiteBishop.jpg");
    private ImageIcon bBishopimj = new ImageIcon(curDir + "/blackBishop.jpg");
                                 
    JLabel whiteKing = new JLabel(wKingimj);
    JLabel blackKing = new JLabel(bKingimj);
    JLabel whiteQueen = new JLabel(wQueenimj);
    JLabel blackQueen = new JLabel(bQuennimj);
    
    JLabel blackRook1 = new JLabel(bRookimj);
    JLabel blackRook2 = new JLabel(bRookimj);
    JLabel whiteRook1 = new JLabel(wRookimj);
    JLabel whiteRook2 = new JLabel(wRookimj);
    
    JLabel blackKnight1 = new JLabel(bKightimj);
    JLabel blackKnight2 = new JLabel(bKightimj);
    JLabel whiteKnight1 = new JLabel(wKightimj);
    JLabel whiteKnight2 = new JLabel(wKightimj);
        
    JLabel blackBishop1 = new JLabel(bBishopimj);
    JLabel blackBishop2 = new JLabel(bBishopimj);
    JLabel whiteBishop1 = new JLabel(wBishopimj);
    JLabel whiteBishop2 = new JLabel(wBishopimj);
    
//	Game game = new Game();

	//Constructor
BoardUI(SquareUI s)
{
	setSize(0,190);
	setLayout(new GridLayout(8,8));

	this.setShowBoard(createChessBoardUI());
        
        for (int i = 0; i < 8; i++)
            {
                for (int k =0; k < 8; k++)
                {
                      showBoard[i][k].addMouseListener(this);
                }
            }
		
    for (int i = 0; i < 8; i++) 
    { 
        //showBoard[6][i].add(pawn0); 
        showBoard[6][i].add(new JLabel(new ImageIcon(curDir + "/pawn0.jpg"))); 
        showBoard[1][i].add(new JLabel(new ImageIcon(curDir + "/pawn8.jpg"))); 

    } 	    

	showBoard[7][4].add(whiteKing);
	showBoard[0][4].add(blackKing);
	showBoard[7][3].add(whiteQueen);
	showBoard[0][3].add(blackQueen);
	
	showBoard[0][0].add(blackRook1);
	showBoard[0][7].add(blackRook2);
	showBoard[7][0].add(whiteRook1);
	showBoard[7][7].add(whiteRook2);
	
	showBoard[0][2].add(blackKnight1);
	showBoard[0][5].add(blackKnight2);
	showBoard[7][2].add(whiteKnight1);
	showBoard[7][5].add(whiteKnight2);
	
	showBoard[0][1].add(blackBishop1);
	showBoard[0][6].add(blackBishop2);
	showBoard[7][1].add(whiteBishop1);
	showBoard[7][6].add(whiteBishop2);
	
}	
	 void setShowBoard(SquareUI [][] c)
		{
			showBoard = c;
		}
		
		SquareUI[][] getShowChessBoard()
		{
			return showBoard;
		}

SquareUI[][] createChessBoardUI()
	{
	 showBoard = new SquareUI[8][8]; 
		
		for (int i =0; i< 8; i++)
		{
			for(int j=0;j<8;j++)
			{
				showBoard[i][j] = new SquareUI(board.locateSq(i, j));
				colorSquares(showBoard[i][j]);
				add(showBoard[i][j]);
			}
		}
		return showBoard;
	}

void colorSquares(SquareUI chessSquare)
	{
		if(chessSquare.getSquare().getColor()== 1)
			chessSquare.setBackground(Color.YELLOW);
		else chessSquare.setBackground(Color.GRAY);
	}

public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {
            
		/* textArea3.append((game.getPiece(game.getSqs(textfield1.getText()))).toString());
			game.selectSquare((game.getPiece(game.getSqs(textfield1.getText()))), game.getSqs(textfield1.getText()),game.getSqs(textfield2.getText()) );
			textArea3.append((game.getPiece(game.getSqs(textfield2.getText()))).toString()); 
			 */
		
            for (int i = 0; i < 8; i++)
            {  
                for (int k =0; k < 8; k++)
                {
                      if (arg0.getSource() == showBoard[i][k])
			 
			
			      
                      {
			 if (clicked == true )
                          {

                              System.out.println(clicked);
				
                             components = showBoard[i][k].getComponents();
                             showBoard[i][k].removeAll();
				  
                             showBoard[i][k].repaint();
                             clicked = false;
				  System.out.println((board.locateSq(i,k)));
				  //piece = game.getPiece(board.locateSq(i,k));
				  from = board.locateSq(i, k);
				  
				System.out.println(showBoard[i][k]);
				  System.out.println(board.locateSq(i, k));
				}
                          else if (clicked == false)
                          {
				  try{
				  to = board.locateSq(i, k);
                              System.out.println(clicked);
				   System.out.println("There is a click");
				  //game.pickUpPiece(piece, from, to);
                      for (int j = 0; j < components.length; j++)
                      {
                          showBoard[i][k].add(components[j]);
			        System.out.println(board.locateSq(i, k));
                      }
		     
                      showBoard[i][k].repaint();
                      clicked = true;
			
		      
                          }
		  
		  catch (Exception e)
		  {e.getMessage();}}
                }
            }
            }
        }
	public void mouseReleased(MouseEvent arg0) {}

}

