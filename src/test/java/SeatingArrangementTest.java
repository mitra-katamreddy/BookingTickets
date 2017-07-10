import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeatingArrangementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void constructor_methods1(){
		SeatingArrangement seating = new SeatingArrangement(Booking.totalCapacity,Booking.rows);
		seating.bookSeats(10);
		assertEquals("The Number of seat available are shown wrong", Booking.totalCapacity-10, seating.getNumberOfSeatsAvailable());
		seating.dropSeats(10);
		assertEquals("The Number of seat available are shown wrong", Booking.totalCapacity, seating.getNumberOfSeatsAvailable());

	}

}
