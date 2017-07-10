import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test; 


import org.junit.After;
import org.junit.Before;

public class BookingTest {
	
	public static void main(String args[]) {
	    org.junit.runner.JUnitCore.main("BookingTest");
	 }

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void constructor_methods1(){
		Booking booking = new Booking();
		//Started Booking 
		booking.initSeatArrangement();
		//Check the number of seating available before starting the booking
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity, booking.numSeatsAvailable());
		//10 seats were held 
		booking.findAndHoldSeats(10, "abc.ght@gmail.com");
		//Checking if the number of seats available are 10 less than the total capacity
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity-10, booking.numSeatsAvailable());
		booking.reserveSeats(booking.getSeatHoldNum(), "abc.ght@gmail.com");
	}
	
	@Test 
	public void constructor_methods2(){
		Booking booking = new Booking();
		//Started Booking 
		booking.initSeatArrangement();
		//Check the number of seating available before starting the booking
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity, booking.numSeatsAvailable());
		//10 seats were held 
		booking.findAndHoldSeats(10, "abc.ght@gmail.com");
		//Checking if the number of seats available are 10 less than the total capacity
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity-10, booking.numSeatsAvailable());
		//Different email is used while reserving
		String confirmation = booking.reserveSeats(booking.getSeatHoldNum(), "abc.gh@gmail.com");
		//Checking whether confirmation string is null
		assertNull("The customer email id are not same",confirmation);
		
	}
	
	@Test 
	public void constructor_methods3(){
		Booking booking = new Booking();
		//Started Booking 
		booking.initSeatArrangement();
		//Check the number of seating available before starting the booking
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity, booking.numSeatsAvailable());
		//10 seats were held 
		booking.findAndHoldSeats(10, "abc.ght@gmail.com");
		//Checking if the number of seats available are 10 less than the total capacity
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity-10, booking.numSeatsAvailable());
		//The held seats are dropped
		booking.dropHeldSeats(booking.getSeatHoldNum(), "abc.ght@gmail.com");
		//After Dropping, checking whether the seats available are back to same number
		assertEquals("The Number of seat available are shown wrong", booking.totalCapacity, booking.numSeatsAvailable());
		
	}

}
