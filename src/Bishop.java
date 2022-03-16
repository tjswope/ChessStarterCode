
public class Bishop extends Piece
{	
	public Bishop(int p){
		super(p, 5, "bishop");
	}
	
	public Bishop(){
		this(1);
	}
	
	// check to see if the move is valid, and then sets x and y coordinates to new values.
	// returns true if move was valid, and false if it was not valid.
	public boolean isValidMove(Location from, Location to, Piece[][]b){
		boolean success = false;
		
		// check to see if the move to point is a diagonal line.
		if(from.getRow() - to.getRow() == from.getColumn() - to.getColumn() || from.getRow() - to.getRow() == -1*(from.getColumn() - to.getColumn()))
			success = true;
		//  check to make sure there aren't any pieces in between starting and finishing positions
		int y = from.getColumn();
		
		if (from.getRow() < to.getRow() && from.getColumn() < to.getColumn())
		{
			for(int i = from.getRow()+1; i<to.getRow(); i++)
			{
				if(b[i][y+1].getPlayer()!=0) 
					success = false;
				y +=1;
			}
		}
		else if (from.getRow() < to.getRow() && from.getColumn() > to.getColumn())
		{
			for(int i = from.getRow()+1; i<to.getRow(); i++)
			{
				if(b[i][y-1].getPlayer()!=0) 
					success = false;
				y -=1;
			}
		}
		else if (from.getRow() > to.getRow() && from.getColumn() < to.getColumn())
		{
			for(int i = from.getRow()-1; i>to.getRow(); i--)
			{
				if(b[i][y+1].getPlayer()!=0) 
					success = false;
				y +=1;
			}
		}
		else if (from.getRow() > to.getRow() && from.getColumn() > to.getColumn())
		{
			for(int i = from.getRow()-1; i>to.getRow(); i--)
			{
				if(b[i][y-1].getPlayer()!=0) 
					success = false;
				y -=1;
			}
		}
		return success;
	}
	
	public String toString(){
		return "b";
	}
}
