
public class King extends Piece
{	
	public King(int p){
		super(p, 5, "king");
	}
	
	public King(){
		this(1);
	}
	
	// check to see if the move is valid, and then sets x and y coordinates to new values.
	// returns true if move was valid, and false if it was not valid.
	public boolean isValidMove(Location from, Location to, Piece[][]b) 
	{
		boolean success = false;
		if((from.getRow() + 1 == to.getRow() || from.getRow() - 1 == to.getRow())      //  diagonal moves
				&&(from.getColumn() + 1 == to.getColumn() || from.getColumn() - 1 == to.getColumn())
			|| (from.getRow() == to.getRow() && (from.getColumn()+1 == to.getColumn() || from.getColumn()-1 == to.getColumn() )) // horizontal moves
			|| (from.getColumn() == to.getColumn() && (from.getRow()+1 == to.getRow() || from.getRow()-1 == to.getRow() ))) // vertical moves			
			success = true;
		return success;
	}
	
	public String toString(){
		return "k";
	}
	
	public String aKingMethod(){
		return "only the king class has this method.";
	}
}
