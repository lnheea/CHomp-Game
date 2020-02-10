package chompdemo2;

import java.awt.Color;

import javax.swing.*;

/*
 *  a simple extension of JButton which allows the background colour to be set and switched back and forth with ease
 *  
 *  there are other ways of doing this, but it's a neat way to demonstrate how to create your own gui components
 *  (as well as how to use ternary operators)
 */
public class GridSquare extends JButton
{
	private int xcoord, ycoord;			// not used in this demo, but might be helpful in future...
	//private boolean usedBar;
	// constructor takes the x and y coordinates of this square
	public GridSquare( int xcoord, int ycoord)
	{
		super();
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		
	}

	

//	// if the decider is even, it chooses black, otherwise white (for 'column+row' will allow a chequeboard effect)
	public void setColor( int decider)
	{
		Color chocolate2 = new Color(110,70,50);
		this.setBackground(chocolate2);
		
	}
	
	public void setSoap()
	{
		this.setText("Soap");
		Color colour2 = Color.red ;
		this.setBackground(colour2);
	}
	
	public void bittenSoap() {
		System.out.println();
		
	}
	
	public void bittenBar(){
		
		Color colour =  Color.gray;
		this.setBackground(colour);
	}
	
	public boolean isBittenBar() {
		return this.getBackground() == Color.gray;
	}
	
	public int getXCoord() {
		return xcoord;
	}
	
	public int getYCoord() {
		return ycoord;
	}
}
	
