import java.util.Vector;  	 
import java.io.*;				// needed for file i/o

public class GameDA 
{
	
	static File gameFile = new File("Game.txt");	
	

	public static void initialize(Game game)
	{
	// create Vector instance to hold customer reference variables
	
  if(gameFile.exists() && gameFile.length() != 0) 
   {
// read all customer in, create instances, populate Vector 
   	try
	   {
	   	BufferedReader in = new BufferedReader(new FileReader(gameFile));
	
	String name;
        String color;
        String id;	
	int row;
	int column;
	int turn;
	String color2;

			for (int i = 0; i < 2; i++)
			{
				name = in.readLine();
				color = in.readLine();
				//turn = Integer.parseInt(in.readLine());
				
				
				game.player[i].setName(name);
				game.player[i].setColor(color);
				
				
			} 
			
			for (int i = 0; i < 32; i++)
			{
				row = Integer.parseInt(in.readLine());
				column = Integer.parseInt(in.readLine());
								
				game.pieces[i].setRow((row));
				game.pieces[i].setColumn((column));
			} 
			
			color2 = in.readLine();
		
			if (color2.equals(game.player[0].getColor()))
			game.turnPlayer = game.player[0];
		
			else if (color2.equals(game.player[1].getColor()))
				game.turnPlayer = game.player[1];
		}
		catch (Exception e)
			{System.out.println (e);}	
	}
	
}
	public static void terminate(Game game)
	{
	// write customer data to the sequential file
		try 
		{
		// create PrintStream for output
		PrintStream out = new PrintStream(new FileOutputStream (gameFile));

			for (int i = 0; i < 2; i++)
			{	
			 
				out.println(game.player[i].getName());
				out.println(game.player[i].getColor());
				//out.println(game.turnPlayer.getTurn());
				
			
			}
			
			for (int i = 0; i < 32; i++)
			{
				out.println(game.pieces[i].getRow());
				out.println(game.pieces[i].getColumn());
				
			}out.println(game.turnPlayer.getColor());
		}
		catch (Exception e)
			{System.out.println (e);}
		
	}
 
}
 
 
