import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void constructor_methods1(){
		Seat seating = new Seat(0,1);
		String seatStr = "A - 1";
		assertEquals("The List of seats are shown wrong", seatStr, seating.toString());
		

	}
	@Test 
	public void constructor_methods2(){
		Seat seating = new Seat(18,4);
		String seatStr = "S - 4";
		assertEquals("The List of seats are shown wrong", seatStr, seating.toString());
		

	}
	@Test 
	public void constructor_methods3(){
		Seat seating = new Seat(4,5);
		String seatStr = "E - 5";
		assertEquals("The List of seats are shown wrong", seatStr, seating.toString());
		

	}

}
