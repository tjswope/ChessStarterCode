
public class Pawn extends Piece
{

	public Pawn(int p){
		super(p, 13, "pawn");
	}
	
	public Pawn(){
		this(0);
	}
	
	// check to see if the move is valid, and then sets x and y coordinates to new values.
	// returns true if move was valid, and false if it was not valid.
	public boolean isValidMove(Location from, Location to, Piece[][]b) 
	{
		//System.out.println(player + " " + from.row + " " + to.row + " " + from.column + " " + to.column + " " + b[to.row][to.column].getPlayer());
		//System.out.println();
		System.out.println("is valid move pawn");
		boolean success = false;
				// player 1 move forward 1
		if(((getPlayer() == 1 && from.getColumn() == to.getColumn() && from.getRow()+1 == to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==0)||
				// player 1 move forward 2 on first pawn move
				(getPlayer() == 1 && from.getColumn() == to.getColumn() && from.getRow() == 1 && from.getRow()+2 == to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==0)||
				// player 2 move forward 1
				(getPlayer() == 2 && from.getColumn() == to.getColumn() && from.getRow()-1 ==to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==0)||
				// player 2 move forward 2 on first pawn move
				(getPlayer() == 2 && from.getColumn() == to.getColumn() && from.getRow() == 6 && from.getRow()-2 == to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==0))||
				// player 1 move diagonally down to the right
				(getPlayer() == 1 && from.getColumn()+1 == to.getColumn() && from.getRow()+1==to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==2)||
				// player 1 move diagonally down to the left
				(getPlayer() == 1 && from.getColumn()-1 ==to.getColumn() && from.getRow()+1==to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==2)||
				// player 2 move diagonally up to the right
				(getPlayer() == 2 && from.getColumn()+1 ==to.getColumn() && from.getRow()-1==to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==1)||
				// player 2 move diagonally up to the left
				(getPlayer() == 2 && from.getColumn()-1 ==to.getColumn() && from.getRow()-1==to.getRow() && b[to.getRow()][to.getColumn()].getPlayer()==1))
			success = true;
				
		return success;
	}
	
	public String toString(){
		return "p";
	}
}
