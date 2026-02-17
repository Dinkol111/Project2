import java.util.Comparator;
import java.util.NoSuchElementException;
/**
 * Generic priority queue implementation.
 * Elements are stored in priority order as determined by
 * the provided Comparator.
 * 
 * The default capacity is 10, and the maximum capacity is 1000.
 *
 * @param <T> the type of elements stored in the priority queue
 */
public class MyPriorityQueue<T> implements PriorityQueueADT<T>{
	/**
	 * 
	 * Queue whatever type of objects is sent 
	 */
	private T[] queue;
	/**
	 * Use this to compare the objects in the queue
	 */
	private Comparator<T> comparator;
	/**
	 * Count the number of objects in the queue
	 */
	private int currentSize = 0;
	 /**
     * Constructs a priority queue with a default size of 10
     * and the given comparator
     *
     * @param comparator the comparator used to determine priority
     */
	public MyPriorityQueue(Comparator<T> comparator) {
		queue = (T[]) new Object[10];
		this.comparator = comparator;
	}
	/**
     * Constructs a priority queue with the given size
     * and comparator
     *
     * @param size the capacity of the queue
     * @param comparator the comparator used to determine priority
     */
	public MyPriorityQueue(int size,Comparator<T> comparator) {
		queue = (T[]) new Object[size];
		this.comparator = comparator;
	}
	
	/**
     * Adds an item into the queue based on priority determined
     * by the comparator
     *
     * @param item the item to be added to the queue
     * @throws IllegalStateException if the queue is full
     * @throws IllegalArgumentException if the item is null
     */
	@Override
	public void enqueue(T item) {
		if(currentSize==queue.length) {
			throw new IllegalStateException("PriorityQueue is full");
		}
		int index = 0;
		boolean found = false;
		if(item == null) {
			throw new IllegalArgumentException("Item doesn't exist");
		}
		if(this.isEmpty()) {
			queue[0] = item;
			currentSize++;
			return;
		}
		if(currentSize<queue.length) {
			for(int i =0;i<currentSize;i++) {
				if(comparator.compare((T) item, queue[i])<=0) {
					index = i;
					found = true;
					break;
				}
			}
			if(found) {
				for (int i = currentSize; i > index; i--) {
			        queue[i] = queue[i - 1];
			    }
				queue[index] = item;
			}
			else {
				queue[currentSize] = item;
			}
			currentSize++;
		}
		
	}

	 /**
     * Removes and returns the highest-priority item in the queue
     *
     * @return the highest priority element
     * @throws NoSuchElementException if the queue is empty
     */
	@Override
	public T dequeue() {
		if(this.isEmpty() ) {
			throw new NoSuchElementException("The queue is empty");
		}
		T temp = queue[0];
		for(int i = 1; i < currentSize; i++) {
	        queue[i - 1] = queue[i];
	    }
		queue[currentSize - 1] = null; 
		currentSize--;
		return temp;
	}
	/**
     * Returns the highest priority item in the queue without removing it
     *
     * @return the highest priority element
     * @throws NoSuchElementException if the queue is empty
     */
	@Override
	public T peek() {
		if(this.isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		return queue[0];
	}
	/**
	 * checks if queue is empty
	 *@return true if empty false if not
	 */
	@Override
	public boolean isEmpty() {
		if(currentSize == 0)
			return true;
		return false;
	}
	/**
	 * return current number of items in queue
	 * @return number of items in queue
	 */
	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public Object[] toArray() {
		Object[] temp = new Object[currentSize];
		for(int i = 0;i<currentSize;i++) {
			temp[i] = queue[i];
		}
		return temp;
	}
	
	

}
