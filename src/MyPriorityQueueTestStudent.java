import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyPriorityQueueTestStudent {
	
	private MyPriorityQueue<Order> pq;
	private Order one;
	private Order two;
	private Order three;
	
	
	@BeforeEach
	void setUp() throws Exception {
		 pq = new MyPriorityQueue<>(new OrderComparator());
		  one = new Order("1",5);
		  two = new Order("2",3);
		  three = new Order("3",7);
	}

	@AfterEach
	void tearDown() throws Exception {
		pq = null;
		one = null;
		two = null;
		three = null;
	}

	@Test
	void enqueingOrders() {
		pq.enqueue(one);
		pq.enqueue(two);
		pq.enqueue(three);
		
		assertEquals(two,pq.peek());
	}
	
	@Test
	void dequeingOrders() {
		assertThrows(NoSuchElementException.class, () ->
		pq.dequeue());
		pq.enqueue(one);
		pq.dequeue();
		
		
		assertTrue(pq.isEmpty());
	}
	
	@Test
	void peekingOrders() {
		assertThrows(NoSuchElementException.class, () ->
		pq.dequeue());
		pq.enqueue(one);
		assertEquals(one,pq.peek());
		
		
		assertFalse(pq.isEmpty());
	}
	
	

}
