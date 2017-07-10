import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeatHoldTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void constructor_methods1(){
		SeatHold seating = new SeatHold(10,1, 3,"abc.jgh@gmail.com");
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		Seat seat = new Seat(0,1);
		seatList.add(seat);
		Seat seat1 = new Seat(0,2);
		seatList.add(seat1);
		Seat seat2 = new Seat(0,3);
		seatList.add(seat2);
		
		assertEquals("The List of seats are shown wrong", seatList.toString(), seating.getSeatList().toString());
		

	}

}
