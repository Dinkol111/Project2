import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTestStudent {

	private MyStack s;
	private Order one;
	private Order two;
	private Order three;
	
	
	@BeforeEach
	void setUp() throws Exception {
		 s = new MyStack(3);
		  one = new Order("1",5);
		  two = new Order("2",3);
		  three = new Order("3",7);
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
		one = null;
		two = null;
		three = null;
	}

	@Test
	void pushingOrders() {
		s.push(one);
		s.push(two);
		s.push(three);
		
		assertEquals(three,s.peek());
		assertThrows(IllegalStateException.class, () ->
		s.push(one));
		
	}
	
	@Test
	void poppingOrders() {
		assertThrows(NoSuchElementException.class, () ->
		s.pop());
		s.push(one);
		s.pop();
		
		
		assertTrue(s.isEmpty());
	}
	
	@Test
	void peekingOrders() {
		assertThrows(NoSuchElementException.class, () ->
		s.pop());
		s.push(one);
		assertEquals(one,s.peek());
		
		
		assertFalse(s.isEmpty());
	}
	
	

}
