import java.util.ArrayList;


public class ConvertingExample {

	public static void main(String[] args) {
		
		// You can convert a reference variable from a subclass to a superclass.
		King k = new King();
//		System.out.println((Piece)k);   // Explicit Conversion
		Piece p = k;					// Implicit Conversion
//		System.out.println(p);
		
		// You cannot always convert from a super class to a subclass. 
		Piece p1 = new Piece();
//		King k = p1;				// doesn't work.
		
		// You can only convert if the object that the superclass reference variable 
		// references is actually an instance of the subclass.  You should check
		// using the instanceof operator.
//		if(k instanceof King)
//			System.out.println((King)k);
//		else
//			System.out.println("not a king");
//		
		// working with collections
		ArrayList<Piece> pieces = new ArrayList<>();
		
		int r;
		for(int i = 0; i<=10; i++){
			r = (int)(Math.random() * 6)+1;
			switch(r){
				case 1:pieces.add(new Pawn());
					break;
				case 2:pieces.add(new Bishop());
					break;
				case 3:pieces.add(new King());
					break;
				case 4:pieces.add(new Knight());
					break;
				case 5:pieces.add(new Queen());
					break;
				default:pieces.add(new Rook());
			}
		}
		
//		for(Piece p2:pieces)
//			System.out.println(p2);
		
		for(Piece p2: pieces){
			if(p2 instanceof King)
				System.out.println(((King) p2).aKingMethod());
			else
				System.out.println("not a king");
		}
	}
}
