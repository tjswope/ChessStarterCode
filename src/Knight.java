
public class Knight extends Piece
{	
	public Knight(int p){
		super(p, 5, "knight");
	}
	
	public Knight(){
		this(1);
	}
	
	// check to see if the move is valid, and then sets x and y coordinates to new values.
	// returns true if move was valid, and false if it was not valid.
	public boolean isValidMove(Location from, Location to, Piece[][]b) 
	{
		boolean success = false;
		if((from.getRow()+2 == to.getRow() && from.getColumn()+1 == to.getColumn())||
				(from.getRow()-2 == to.getRow() && from.getColumn()+1 == to.getColumn())||
				(from.getRow()+2 == to.getRow() && from.getColumn()-1 == to.getColumn())||
				(from.getRow()-2 == to.getRow() && from.getColumn()-1 == to.getColumn())||
				(from.getRow()+1 == to.getRow() && from.getColumn()+2 == to.getColumn())||
				(from.getRow()-1 == to.getRow() && from.getColumn()+2 == to.getColumn())||
				(from.getRow()+1 == to.getRow() && from.getColumn()-2 == to.getColumn())||
				(from.getRow()-1 == to.getRow() && from.getColumn()-2 == to.getColumn()))
			success = true;
		return success;
	}
	
	public String toString(){
		return "n";
	}
}
