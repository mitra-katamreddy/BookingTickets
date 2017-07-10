
public class SeatingArrangement {
	
	private int numberOfSeatsAvailable;
	private int totalCapacity;
	private int rowWidth;
	private int currentSeat;
	
	public SeatingArrangement(int totalCapacity, int rowWidth){
		this.numberOfSeatsAvailable = totalCapacity;
		this.totalCapacity = totalCapacity;
		this.rowWidth = rowWidth;
		this.currentSeat = 1;
	}
	
	public void bookSeats(int seatNums){
		this.numberOfSeatsAvailable = this.numberOfSeatsAvailable-seatNums;
		currentSeat = seatNums + currentSeat;
//		SeatHold seatHold = new SeatHold(currentSeat, seatNums);
//		return seatHold;
	}
	
	public void dropSeats(int seatNums){
		this.numberOfSeatsAvailable = this.numberOfSeatsAvailable+seatNums;
		currentSeat =  currentSeat - seatNums ;
//		SeatHold seatHold = new SeatHold(currentSeat, seatNums);
//		return seatHold;
	}

	public int getNumberOfSeatsAvailable() {
		return numberOfSeatsAvailable;
	}

	public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public int getRowWidth() {
		return rowWidth;
	}

	public void setRowWidth(int rowWidth) {
		this.rowWidth = rowWidth;
	}

	public int getCurrentSeat() {
		return currentSeat;
	}

	public void setCurrentSeat(int currentSeat) {
		this.currentSeat = currentSeat;
	}
}
