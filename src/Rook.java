
public class Rook extends Piece
{
	public Rook(int p){
		super(p, 13, "rook");
	}
	
	public Rook(){
		this(1);
	}
	
	// check to see if the move is valid, and then sets x and y coordinates to new values.
	// returns true if move was valid, and false if it was not valid.
	public boolean isValidMove(Location from, Location to, Piece[][]b) 
	{
		boolean success = false;
		if((from.getRow() == to.getRow() && from.getColumn() != to.getColumn())||(from.getColumn() == to.getColumn() && from.getRow() != to.getRow()))
			success = true;
		
		if (from.getRow() < to.getRow())
		{
			for(int i = from.getRow()+1; i<to.getRow(); i++)
			{
				if(b[i][from.getColumn()].getPlayer()!=0) 
					success = false;
			}
		}
		else if (from.getRow() > to.getRow())
		{
			for(int i = from.getRow()-1; i>to.getRow(); i--)
			{
				if(b[i][from.getColumn()].getPlayer()!=0) 
					success = false;
			}
		}
		else if (from.getColumn() < to.getColumn())
		{
			for(int i = from.getColumn()+1; i<to.getColumn(); i++)
			{
				if(b[from.getRow()][i].getPlayer()!=0) 
					success = false;
			}
		}
		else if (from.getColumn() > to.getColumn())
		{
			for(int i = from.getColumn()-1; i>to.getColumn(); i--)
			{
				if(b[from.getRow()][i].getPlayer()!=0) 
					success = false;
			}
		}
		
		return success;
	}
	
	public String toString(){
		return "r";
	}
}
