package chompdemo2;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/*
 * 
 *  the main window of the gui
 *  notice that it extends JFrame - so we can add our own components
 *  notice that it implements ActionListener - so we can handle user input
 */
public class WindowDemo extends JFrame implements ActionListener {

	//private static final long serialVersionUID = 1L;

	// gui components that are contained in this frame:
	private JFrame frame = new JFrame("CHOMP");
	private JPanel topPanel, bottomPanel, centerPanel; // top and bottom panels in the main window
	private JLabel topLabel; // a text label to appear in the top panel
	private JLabel bottomLabel;
	private JButton topButton;
	private JButton bottomButton;
	private JButton bottomButton2;
	private JButton bottomButton3; // a 'reset' button to appear in the top panel
	private GridSquare[][] smGrid; // squares to appear in grid formation in the bottom panel
	private GridSquare[][] medGrid;
	private int x, y; // the size of the grid

	/*
	 * constructor method takes as input how many rows and columns of gridsquares to
	 * create it then creates the panels, their subcomponents and puts them all
	 * together in the main frame it makes sure that action listeners are added to
	 * selectable items it makes sure that the gui will be visible
	 */
	public WindowDemo(int x, int y) {
		this.x = x;
		this.y = y;

		// first create the panels
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(x, y));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// then create the components for each panel and add them to it

		// for the bottom and top panel:
		bottomLabel = new JLabel("Select the size:");
		bottomButton = new JButton("Small");
		bottomButton.addActionListener(this);
		bottomButton2 = new JButton("Medium");
		bottomButton2.addActionListener(this);
		bottomButton3 = new JButton("Large");
		bottomButton3.addActionListener(this);
		bottomButton.addActionListener(this); // IMPORTANT! Without this, clicking the button does nothing.
		bottomPanel.add(bottomLabel);
		bottomPanel.add(bottomButton);
		bottomPanel.add(bottomButton2);
		bottomPanel.add(bottomButton3);
		topLabel = new JLabel("Click to reset");
		topButton = new JButton("Reset");
		topButton.addActionListener(this);
		topPanel.add(topLabel);
		topPanel.add(topButton);

		//this.smGrid();
		
		
		
		smGrid = new GridSquare[x][y];
		//
		for (int column = 0; column < x; column++) {
			for (int row = 0; row < y; row++) {
				smGrid[column][row] = new GridSquare(column, row);
				smGrid[column][row].setSize(10, 10);
				smGrid[column][row].setColor(0);
				smGrid[column][row].setOpaque(true); // without this line and the next the OS' default
				smGrid[column][row].setBorderPainted(true);

				smGrid[column][row].addActionListener(this);

				centerPanel.add(smGrid[column][row]);

			}
		}
		smGrid[0][0].setSoap();

		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	// housekeeping : behaviour

	// frame.setResizable( false);

	private void computerMove() {
		Random rand = new Random();

		int xCoord = rand.nextInt(x);
		int yCoord = rand.nextInt(y);
		GridSquare selected = smGrid[xCoord][yCoord];

		// If all chocs are not bitten

		boolean isComplete = this.areAllBitten();
		if (!isComplete) {
			while (true) {
				boolean trigger = !(xCoord == 0 && yCoord == 0);
				if (trigger && !selected.isBittenBar()) {
					break;
				} else {
					xCoord = rand.nextInt(x);
					yCoord = rand.nextInt(y);
					selected = smGrid[xCoord][yCoord];
				}
			}
			System.out.println("Computer's move was " + xCoord + ", " + yCoord);
			System.out.println("Your turn!");
			this.biteChocolate(selected);
		} 
		else { // If all chocs are bitten
			System.out.println("Player won!");
		}
	}

	private void biteChocolate(GridSquare selected) {
		int xCoord = selected.getXCoord();
		int yCoord = selected.getYCoord();
		// selected.bittenBar();

		for (int column = xCoord; column < this.x; column++) {
			for (int row = yCoord; row < this.y; row++) {
				smGrid[column][row].bittenBar();
			}
		}

	}

	// Something wrong with this method
	private boolean areAllBitten() {
		for (int col = 0; col < this.x; col++) {
			for (int row = 0; row < this.y; row++) {
				boolean trigger = !(col == 0 && row == 0);
				if (!smGrid[col][row].isBittenBar() && trigger) {
					return false;
				}
			}
		}
		return true;
	}

	public void actionPerformed(ActionEvent aevt) {
		Object selected = aevt.getSource();
		// boolean finished = false;

		if (aevt.getSource() instanceof GridSquare) {
			GridSquare gridSquare = (GridSquare) selected;
			boolean areAllBitten = this.areAllBitten();
			if (areAllBitten) {
				System.out.println("Computer Won!");
			} else {
				this.biteChocolate(gridSquare);
				this.computerMove();
			}
		}
// if resetting the GAME is requested then do so
		if (selected.equals(topButton)) {
			for (int col = 0; col < smGrid.length; col++) {
				for (int row = 0; row < smGrid[0].length; row++) {
					smGrid[col][row].setColor(col + row);
					smGrid[0][0].setSoap();
				}
			}
		}
	}
}
		
	
//		}
	
//
