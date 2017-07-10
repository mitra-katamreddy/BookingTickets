import java.util.ArrayList;

public class SeatHold {
	private int startingSeatNum;
	private int endingSeatNum;
	private ArrayList<Seat> seatList;
	
	private String customerEmail;
	private int seatNums;
	private int id;
	private String confirmationId;
	private boolean held;
	private boolean reserved;
	
	
	public SeatHold(int row,int currentSeat, int seatNums,String customerEmail){
		startingSeatNum = currentSeat + 1;
		endingSeatNum = currentSeat + seatNums;
		
		this.customerEmail = customerEmail;
		this.seatNums = seatNums;
		this.held = true;
		this.seatList = new ArrayList<Seat>();
		for(int i= 0; i< seatNums;i++){
			Seat seat = new Seat((currentSeat+i)/row, (currentSeat+i)%row);
			seatList.add(seat);
		}
	}


	public int getStartingSeat() {
		return startingSeatNum;
	}


	public void setStartingSeat(int startingSeat) {
		this.startingSeatNum = startingSeat;
	}


	public int getEndingSeat() {
		return endingSeatNum;
	}


	public void setEndingSeat(int endingSeat) {
		this.endingSeatNum = endingSeat;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public int getSeatNums() {
		return seatNums;
	}


	public void setSeatNums(int seatNums) {
		this.seatNums = seatNums;
	}


	public String getConfirmationId() {
		return confirmationId;
	}


	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}


	public boolean isHeld() {
		return held;
	}


	public void setHeld(boolean held) {
		this.held = held;
	}


	public boolean isReserved() {
		return reserved;
	}


	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Seat> getSeatList() {
		return seatList;
	}


	public void setSeatList(ArrayList<Seat> seatList) {
		this.seatList = seatList;
	}
}
