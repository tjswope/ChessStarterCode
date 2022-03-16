// Class: GraphicsPanel
// Written by: Mr. Swope
// Date: 12/2/15
// Description: This class is the main class for this project.  It extends the Jpanel class and will be drawn on
// 				on the JPanel in the GraphicsMain class.  
//
// Since you will modify this class you should add comments that describe when and how you modified the class.  
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements MouseListener{
		
	private final int SQUARE_WIDTH = 90;    // The width of one space on the board.  Constant used for drawing board.
	private final int OFFSET = 5;
	private Location from;   			    // holds the coordinates of the square that the user would like to move from.
	private Location to;   				    // holds the coordinates of the square that the user would like to move to.
	private boolean click;   				// false until the game has started by somebody clicking on the board.  should also be set to false
	                         				// after an attempted move.
	private Piece[][] board; 				// an 8x8 board of 'Pieces'.  Each spot should be filled by one of the chess pieces or a 'space'. 
	private int turn;						// used to keep track of who's turn it is - should only be 1 or 2.
	
	public GraphicsPanel(){
		setPreferredSize(new Dimension(SQUARE_WIDTH*8+OFFSET*2,SQUARE_WIDTH*8+OFFSET*2));   // Set these dimensions to the width 
        											 // of your background picture.   
        this.setFocusable(true);					 // for keylistener
		this.addMouseListener(this);
		
		// instantiate the instance variables.
		board = new Piece[8][8];
		
		for(int column = 0; column<8; column++){
			board[1][column] = new Pawn(1);
			board[6][column] = new Pawn(2);
			board[2][column] = new Space();
			board[3][column] = new Space();
			board[4][column] = new Space();
			board[5][column] = new Space();
		}
		
		board[0][0] = new Rook(1);
		board[0][7] = new Rook(1);
		board[7][0] = new Rook(2);
		board[7][7] = new Rook(2);
		
		board[0][1] = new Knight(1);
		board[0][6] = new Knight(1);
		board[7][1] = new Knight(2);
		board[7][6] = new Knight(2);
		
		board[0][2] = new Bishop(1);
		board[0][5] = new Bishop(1);
		board[7][2] = new Bishop(2);
		board[7][5] = new Bishop(2);
		
		board[0][3] = new Queen(1);
		board[7][3] = new Queen(2);
		
		board[0][4] = new King(1);
		board[7][4] = new King(2);
		
		click = false;
		from = new Location();
		to = new Location();
		turn = 1;
	}
	
	// method: paintComponent
	// description: This method will paint the items onto the graphics panel.  This method is called when the panel is
	//   			first rendered.  It can also be called by this.repaint()
	// parameters: Graphics g - This object is used to draw your images onto the graphics panel.
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if(turn == 1)
			g2.setColor(Color.WHITE);
		else
			g2.setColor(Color.LIGHT_GRAY);
		
		g2.fillRect(0,0,SQUARE_WIDTH*8+OFFSET*2,SQUARE_WIDTH*8+OFFSET*2);
		// Draw the board
		g2.setColor(Color.gray);
		g2.drawLine(SQUARE_WIDTH*8+OFFSET, OFFSET, SQUARE_WIDTH*8+OFFSET, SQUARE_WIDTH*8+OFFSET);
		g2.drawLine(OFFSET, SQUARE_WIDTH*8+OFFSET, SQUARE_WIDTH*8+OFFSET, SQUARE_WIDTH*8+OFFSET);
		g2.drawLine(OFFSET, OFFSET, SQUARE_WIDTH*8+OFFSET, 0+OFFSET);
		g2.drawLine(OFFSET, OFFSET, OFFSET, SQUARE_WIDTH*8+OFFSET);
		
		for(int i = 0; i <8; i+=2)
			for (int j = 0; j<8; j+=2){
				g2.setColor(Color.gray);
				g2.fillRect(i*SQUARE_WIDTH+OFFSET,j*SQUARE_WIDTH+OFFSET,SQUARE_WIDTH,SQUARE_WIDTH);
			}
		
		for(int i = 1; i <8; i+=2)
			for (int j = 1; j<8; j+=2){
				g2.setColor(Color.gray);
				g2.fillRect(i*SQUARE_WIDTH+OFFSET,j*SQUARE_WIDTH+OFFSET,SQUARE_WIDTH,SQUARE_WIDTH);
			}
		
		if(click == true){
			g2.setColor(Color.YELLOW);
			g2.fillRect(from.column*SQUARE_WIDTH+OFFSET,from.row*SQUARE_WIDTH+OFFSET,SQUARE_WIDTH,SQUARE_WIDTH);
		}	
		
		// instead of drawing a single piece you should loop through the two-dimensional array and draw each piece except for 
		// empty spaces.
		for(int column = 0; column<8; column++)
			for(int row = 0; row < 8; row++)
				board[row][column].draw(g2, this, new Location(row,column));
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// use math to figure out the row and column that was clicked.
		
		
		if(click == false){
			System.out.println("from column = " + e.getX()/90);
			System.out.println("from row = " + e.getY()/90);
			from.column = e.getX()/90;
			from.row = e.getY()/90;
			click = true;
		}
		else{
			System.out.println("to column = " + e.getX()/90);
			System.out.println("to row = " + e.getY()/90);
			System.out.println("turn = " + turn + " player = " + board[from.column][from.row].getPlayer());
			to.column = e.getX()/90;
			to.row = e.getY()/90;
			
			
			if(board[from.row][from.column].getPlayer() == turn && board[from.row][from.column].isValidMove(from, to, board)){
				System.out.println("valid move");
				System.out.println();
				
				// move piece
				board[to.row][to.column] = board[from.row][from.column];
				board[from.row][from.column] = new Space();
				
				if(turn == 1)
					turn = 2;
				else
					turn = 1;
			}
			printBoard();
			if(board[from.row][from.column] instanceof Piece)
				System.out.println("piece");
			else
				System.out.println("not a piece");
			click = false;
		}
		
		this.repaint();
	}
	
	public void printBoard(){
		for(int row = 0; row<8; row++){
			for(int column = 0; column <8; column++)
				System.out.print(board[row][column] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
