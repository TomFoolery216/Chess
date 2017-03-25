import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SquareUI extends JPanel{

	Squares uiSquare;
	
	void setSquare(Squares s)
	{
		uiSquare = s;
	}
	
	Squares getSquare()
	{
		return uiSquare;
	}
	

	SquareUI(Squares f)
	{
		this.setSquare(f);
	}

	
	
}
