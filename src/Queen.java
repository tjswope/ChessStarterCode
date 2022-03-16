
public class Queen extends Piece
{
	public Queen(int p){
		super(p, 4, "queen");
	}
	
	public Queen(){
		this(1);
	}
	
	// check to see if the move is valid, and then sets x and y coordinates to new values.
	// returns true if move was valid, and false if it was not valid.
	public boolean isValidMove(Location from, Location to, Piece[][]b) 
	{
		boolean success = false;
		if((from.getRow() - to.getRow() == from.getColumn() - to.getColumn() || from.getRow() - to.getRow() == -1*(from.getColumn() - to.getColumn()))||
				((from.getRow() == to.getRow() && from.getColumn() != to.getColumn())||(from.getColumn() == to.getColumn() && from.getRow() != to.getRow())))
			success = true;
		
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
		else if (from.getRow() < to.getRow())
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
		return "q";
	}
}
