import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Booking implements TicketService {

	private SeatingArrangement seating;
	private HashMap<Integer, SeatHold> seatHoldIdMap;
	private HashMap<String, SeatHold> seatReservedIdMap;
	private int seatHoldNum;
	public static int rows = 10;
	public static final int totalCapacity = 120;
	
	public void initSeatArrangement(){
//		this.rows = row;
//		this.totalCapacity = totalCapacity;
		this.seating = new SeatingArrangement(totalCapacity,rows);
		seatHoldIdMap = new HashMap<Integer, SeatHold>();
		seatReservedIdMap = new HashMap<String, SeatHold>();
		seatHoldNum = 1;
		
	}
	@Override
	public int numSeatsAvailable() {
		// TODO Auto-generated method stub
		return seating.getNumberOfSeatsAvailable();
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		// TODO Auto-generated method stub
		SeatHold seatHold = new SeatHold(rows,seating.getCurrentSeat(),numSeats,customerEmail);
		
		seating.bookSeats(numSeats);
		seatHoldNum = seatHoldNum+1;
		seatHoldIdMap.put(seatHoldNum, seatHold);
		return seatHold;
	}
	
	public void dropHeldSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		seating.dropSeats(seatHoldIdMap.get(seatHoldId).getSeatNums());
		seatHoldIdMap.remove(seatHoldId);
		return ;
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		SeatHold currentSeatHold = seatHoldIdMap.get(seatHoldId);
		if(currentSeatHold.getCustomerEmail().equals(customerEmail)){
			Date date = new Date();
			SimpleDateFormat ft = 
				      new SimpleDateFormat ("yyyyMMddhhmm");
			StringBuilder confirmation = new StringBuilder();
			confirmation.append(ft.format(date));
			confirmation.append(currentSeatHold.getStartingSeat());
			confirmation.append(currentSeatHold.getSeatNums());
			currentSeatHold.setConfirmationId(confirmation.toString());
			currentSeatHold.setReserved(true);
			seatReservedIdMap.put(confirmation.toString(), currentSeatHold);
			System.out.println("Your Tickets are Booked. Use the given confirmation code at the Theatre");
			return confirmation.toString();	
		}
		else 
			System.out.println("No Seat Holds on the CustomerEmail");
			return null;
		
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		        return matcher.find();
		}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		Booking booking = new Booking();
		booking.initSeatArrangement();
		while(booking.numSeatsAvailable() >0){
			System.out.println("Please Enter the Number of Seats required");
			int seatNums = sc.nextInt();
			if(seatNums <= booking.numSeatsAvailable()){
				System.out.println("Please Enter your EmailID");
				String email = sc.next();
				if(!validate(email)){
					System.out.println("Please enter the valid email address");
					System.out.println("******* Booking Started *******");
					continue;
				}
				SeatHold seatHold = booking.findAndHoldSeats(seatNums,email);
				System.out.println("The Seats held " + seatHold.getSeatList().toString());
				
				System.out.println("Do you want to continue to Booking? Press \"yes\" to continue or \"no\" to exit");
				String status = sc.next();
				if(status.equalsIgnoreCase("yes")){
					String confirmation = booking.reserveSeats(booking.getSeatHoldNum(),email);
					System.out.println(confirmation);
					if(booking.numSeatsAvailable() >0){
						System.out.println("******* Booking Started *******");
					}
				}
				else{
					booking.dropHeldSeats(booking.getSeatHoldNum(), email);
					System.out.println("******* Booking Started *******");
				}
			}
			else{
				System.out.println("Only " + booking.numSeatsAvailable() + " are available");
			}
			
		}
		
	}
	public HashMap<Integer, SeatHold> getSeatHoldIdMap() {
		return seatHoldIdMap;
	}
	public void setSeatHoldIdMap(HashMap<Integer, SeatHold> seatHoldIdMap) {
		this.seatHoldIdMap = seatHoldIdMap;
	}
	public HashMap<String, SeatHold> getSeatReservedIdMap() {
		return seatReservedIdMap;
	}
	public void setSeatReservedIdMap(HashMap<String, SeatHold> seatReservedIdMap) {
		this.seatReservedIdMap = seatReservedIdMap;
	}
	public int getSeatHoldNum() {
		return seatHoldNum;
	}
	public void setSeatHoldNum(int seatHoldNum) {
		this.seatHoldNum = seatHoldNum;
	}

}
