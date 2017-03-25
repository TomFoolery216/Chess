import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;
import java.net.MalformedURLException;


public class ChessUI2 extends JFrame implements ActionListener    
{
	Game game;
	
        String curDir = System.getProperty("user.dir");
	
        private ImageIcon slidePanelimj = new ImageIcon(curDir + "\\slidePanel.jpg");
        private ImageIcon ChessPartyimj = new ImageIcon(curDir + "\\ChessParty.jpg");
        private ImageIcon symbolimj = new ImageIcon(curDir + "\\symbol.jpg");
        private ImageIcon starimj = new ImageIcon(curDir + "\\star.jpg");
           
   private AudioClip clip1,clip2, clip3;
  
   private URL file1, file2, file3;
	
	JButton moveButton,  clearButton, closeButton, newGameButton, newPlayerButton, loadGameButton, saveGameButton, displayNamesButton, soundClip;
	JTextArea  textArea2,textArea3;
	JPanel Panel1, Panel2, Panel3;
	JLabel label1, label2, turnLB, label3, label4;
	JTextField textfield1,textfield2, p1field, p2field;

	SquareUI s;	
	BoardUI boardUI = new BoardUI(s);
	
	// constructor
	public ChessUI2(Game g)
	{	
		game = g;
 
        
	
	textArea2 = new JTextArea();
	textArea3 = new JTextArea();

        JLabel slidePanel = new JLabel(slidePanelimj);
	
	JLabel ChessParty = new JLabel(ChessPartyimj);
	JLabel symbol = new JLabel(symbolimj);
	JLabel star = new JLabel(starimj);
	
	moveButton = new JButton("  MOVE ");
	closeButton = new JButton(" CLOSE"); 
	newGameButton = new JButton("New Game ");
	newPlayerButton = new JButton("New Player");
	loadGameButton = new JButton(" LOAD  ");
	saveGameButton = new JButton("     SAVE      ");
	displayNamesButton = new JButton("Display Names");
        soundClip = new JButton("Kung Fu Master's Advice");
		
		
	
			
	turnLB = new JLabel();		
	label1 = new JLabel("From:    ");
        label2 = new JLabel("To:         ");
	label3 = new JLabel("Player 1");
	label4 = new JLabel("Player 2");

	if (game.turnPlayer.getTurn()==0)
	 {
	 turnLB.setText("WHITE Player's Turn");
		 
	 }
	 else if (game.turnPlayer.getTurn()==1)
	 {
	 turnLB.setText("BLACK Player's Turn");
	} 
	
//setLayout(new GridLayout(0,0));
textfield1 = new JTextField("Enter from Square ID",12);
        textfield2 = new JTextField("Enter to Square ID",12);
	p1field = new JTextField("Enter Name",12);
	p2field = new JTextField("Enter Name",12);
		
	Panel1 = new JPanel();
	Panel2 = new JPanel();
	Panel3 = new JPanel();
	
	Panel1.add(slidePanel);
	Panel1.add(moveButton);
	
//	Panel2.add(slidePanel);

	Panel1.add(newGameButton);
	Panel1.add(closeButton);
	Panel1.add(newPlayerButton);
	Panel1.add(loadGameButton);
	Panel1.add(saveGameButton);
	Panel1.add(displayNamesButton);
	
	Panel1.add(turnLB);
	
	Panel2.add(symbol);
	Panel2.add(label1);
        Panel2.add(textfield1);
        Panel2.add(label2);
        Panel2.add(textfield2);
	
	Panel2.add(label3);
	Panel2.add(p1field);
	Panel2.add(label4);
	Panel2.add(p2field);
	Panel2.add(star);
        
Panel3.setLayout(new BorderLayout());
Panel3.add(BorderLayout.SOUTH, soundClip);
Panel3.add(BorderLayout.NORTH, ChessParty);




	// add panels to frame - frame default is BorderLayout
        Container c = getContentPane();
	//setLayout(new GridLayout(1,0));
	
		//c.add(BorderLayout.WEST,leftPanel);
		
		// add text area to the center
		c.add("North",Panel1);
		c.add("South",Panel2);
		c.add("West", Panel3);
                
		c.add("Center",boardUI);
		c.add("East",textArea3);
		
		try {
	   file1 = new URL("file:" + System.getProperty("user.dir") + "/wutang.wav");
	     file2 = new URL("file:" + System.getProperty("user.dir") + "/ruckus.wav");
		file3 = new URL("file:" + System.getProperty("user.dir") + "/fight.wav");
	  clip1 = JApplet.newAudioClip(file1);
	  clip2 = JApplet.newAudioClip(file2);
	clip3 = JApplet.newAudioClip(file3);
	  	}

	catch (MalformedURLException e) 
	{
            System.err.println(e.getMessage());
        }

	
		moveButton.addActionListener(this);
			
		closeButton.addActionListener(this);
		newPlayerButton.addActionListener(this);
		loadGameButton.addActionListener(this);
		saveGameButton.addActionListener(this);
		displayNamesButton.addActionListener(this);
		newGameButton.addActionListener(this);
               soundClip.addActionListener(this);
               
textArea3.setText("                                                     ");
setResizable( false );
  	       
		setTitle(" KXN's Wu Tang Chess");
		
		setVisible(true);

		setSize(900, 670);
		pack();
		clip2.play();
		
		addWindowListener
		( new WindowAdapter() 
			{ 
				public void windowClosing(WindowEvent event) 
  	 				{shutDown();} 
			}// end of inner class definition	  
		 ); // end of argument sent to addWindowListener method	 
	}
		
	// in main create an instance of ChessUI
	public static void main(String args[])
	{	
		Game g = new Game();
		Board board = new Board();
				 
			g.initPlayer();
			g.initPiece();
		board.initColor();
		//
		ChessUI2 UI = new ChessUI2(g); 	
//		System.out.println(squares.toString());
		 
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		
// see which button was clicked
		if(boardUI.clicked==false)
		{
		clip3.play();
		}
		
	
		if(e.getSource() == moveButton)
		{
		 move(); 
			clip3.play();
		}
			
		if(e.getSource() == newGameButton)
		{
			 
			  game.initPlayer();
			game.initPiece();
			textArea3.setText(" ");
			
			validate();
			
			
			setVisible(false);
			ChessUI2 UI = new ChessUI2(game); 	
			
			if (game.turnPlayer.getTurn()==0){
			turnLB.setText("WHITE Player's Turn");}
			else if (game.turnPlayer.getTurn()==1){
			turnLB.setText("BLACK Player's Turn");} 
		} 
		if(e.getSource() == closeButton)
		{
			shutDown();	
			clip3.play();
		} 
                
                if(e.getSource() == soundClip)
		{
                     
			clip1.play();
			
		} 
		if(e.getSource() == displayNamesButton)
		{
			displayNames();	
			clip3.play();
		} 
		if(e.getSource() == loadGameButton)
		{
			game.loadGame(game);
			
			Toolkit.getDefaultToolkit().beep();
			
			if (game.turnPlayer.getTurn()==0){
			turnLB.setText("WHITE Player's Turn");}
			else if (game.turnPlayer.getTurn()==1){
			turnLB.setText("BLACK Player's Turn");} 
			
			System.out.println(game.pieces[8].getRow());
			
			System.out.println(game.pieces[8].getColumn());
			System.out.println(game.turnPlayer.getColor());
			System.out.println(game.turnPlayer.getTurn());
			System.out.println(game.pieces[8].getColor());
		} 
		if(e.getSource() == saveGameButton)
		{
			game.saveGame(game);	
			Toolkit.getDefaultToolkit().beep();
		} 
		  if(e.getSource() == newPlayerButton)
		{
			
			textArea3.setText("Players:");
			game.player[0].setName(p1field.getText());
			game.player[1].setName(p2field.getText());
			
			textArea3.append(game.player[0].toString());
			textArea3.append(game.player[1].toString());
		}
	}
		
	public void shutDown()
		{
			dispose();
			System.exit(0);  // terminate
		}
	
	
	public void displayNames()
		{
			
			textArea3.append(game.player[0].toString());
			textArea3.append(game.player[1].toString());
		}	
		
	public void move()
			{
			textArea3.setText("Movement\n");
			textArea3.append("\n");
		try
			{
			//textArea3.append((game.getPiece(board.getSqs("B8"))));
			textArea3.append((game.getPiece(game.getSqs(textfield1.getText()))).toString());
			game.selectSquare((game.getPiece(game.getSqs(textfield1.getText()))), game.getSqs(textfield1.getText()),game.getSqs(textfield2.getText()) );
			textArea3.append((game.getPiece(game.getSqs(textfield2.getText()))).toString()); 
			
				
				if (game.turnPlayer.getTurn()==0)
				{
				turnLB.setText("WHITE Player's Turn");
				}
				else if (game.turnPlayer.getTurn()==1)
				{
				turnLB.setText("BLACK Player's Turn");}
				//textArea3.setText(game.getTurn());	
				}
					catch(Exception e)
					{
					textArea3.append(e.getMessage()); 
					}
			}
	
	
}
