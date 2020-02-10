package chompdemo2;


//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
///*
// *  the main window of the gui
// *  notice that it extends JFrame - so we can add our own components
// *  notice that it implements ActionListener - so we can handle user input
// */
//public class WindowDemo extends JFrame implements ActionListener
//{
//	// gui components that are contained in this frame:
//	private JPanel topPanel, bottomPanel;	// top and bottom panels in the main window
//	private JLabel topLabel;				// a text label to appear in the top panel
//	private JButton topButton;				// a 'reset' button to appear in the top panel
//	private GridSquare [][] gridSquares;	// squares to appear in grid formation in the bottom panel
//	private int x,y;						// the size of the grid
//	
//	/*
//	 *  constructor method takes as input how many rows and columns of gridsquares to create
//	 *  it then creates the panels, their subcomponents and puts them all together in the main frame
//	 *  it makes sure that action listeners are added to selectable items
//	 *  it makes sure that the gui will be visible
//	 */
//	public WindowDemo(int x, int y)
//	{
//		this.x = x;
//		this.y = y;
//		
//		// first create the panels
//		topPanel = new JPanel();
//		topPanel.setLayout( new FlowLayout());
//		
//		bottomPanel = new JPanel();
//		bottomPanel.setLayout( new GridLayout( x, y));
//		
//		// then create the components for each panel and add them to it
//		
//		// for the top panel:
//		topLabel = new JLabel("Click the Buttons!");
//		topButton = new JButton("Reset");
//		topButton.addActionListener( this);			// IMPORTANT! Without this, clicking the button does nothing.
//		
//		topPanel.add( topLabel);
//		topPanel.add ( topButton);
//		
//	
//		// for the bottom panel:	
//		// create the buttons and add them to the grid
//		gridSquares = new GridSquare [x][y];
//		for ( int column = 0; column < x; column ++)
//		{
//			for ( int row = 0; row < y; row ++)
//			{
//				gridSquares [column][row] = new GridSquare( x,y);
//				gridSquares [column][row].setSize( 20, 20);
//				gridSquares [column][row].setColor( column + row);
//				gridSquares [column][row].setOpaque( true);				// without this line and the next the OS' default
//				gridSquares [column][row].setBorderPainted( false);		// look & feel will dominate / interfere
//																		// (try commenting each out & see what happens)
//				
//				gridSquares [column][row].addActionListener( this);		// AGAIN, don't forget this line!
//				
//				bottomPanel.add( gridSquares [column][row]);
//			}
//		}
//		
//		// now add the top and bottom panels to the main frame
//		getContentPane().setLayout( new BorderLayout());
//		getContentPane().add( topPanel, BorderLayout.NORTH);
//		getContentPane().add( bottomPanel, BorderLayout.SOUTH);
//		pack();
//		
//		// housekeeping : behaviour
//		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
//		setResizable( false);
//		setVisible( true);
//	}
//	
//	
//	/*
//	 *  handles actions performed in the gui
//	 *  this method must be present to correctly implement the ActionListener interface
//	 */
//	public void actionPerformed (ActionEvent aevt)
//	{
//		// get the object that was selected in the gui
//		Object selected = aevt.getSource();
//		
//		/*
//		 * I'm using instanceof here so that I can easily cover the selection of any of the gridsquares
//		 * with just one piece of code.
//		 * In a real system you'll probably have one piece of action code per selectable item.
//		 * Later in the course we'll see that the Command Holder pattern is a much smarter way to handle actions.
//		 */
//		
//		// if a gridsquare is selected then switch its color
//		if ( selected instanceof GridSquare)
//		{
//			((GridSquare) selected).switchColor();
//		}
//		
//		// if resetting the squares' colours is requested then do so
//		if ( selected.equals( topButton) )
//		{
//			for ( int column = 0; column < x; column ++)
//			{
//				for ( int row = 0; row < y; row ++)
//				{
//					gridSquares [column][row].setColor( column + row);
//				}
//			}
//		}
//	}
//}
