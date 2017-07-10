
public class Seat {
	
	private String row;
	private int seatNumber;
	
	public Seat(int row,int seatNumber){
		this.row = String.valueOf(Character.toChars(row+65));
		this.seatNumber = seatNumber;
//		System.out.println(this.row + "" + this.seatNumber);
	}
	
//	public static void main(String args[]){
//		Seat seat = new Seat(0,14);
//	}
	
	@Override
    public String toString() {
        return row + " - " + seatNumber;
    }

}
