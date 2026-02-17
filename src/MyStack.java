import java.util.NoSuchElementException;

/**
 * Generic LIFO (last-in-first-out) stack class.
 * Maximum number of elements allowed is 1000 and a default size of 10 if the size is 
 * not declared.
 * 
 * @param <T> the type of elements stored in the stack
 */
public class MyStack<T> implements StackADT<T>{

/**
 * Stack of generic objects that can store any type of objects
 */
	private T[] stack;

/**
 * keep track of the number of objects currently in stack
 */
	private int currentSize = 0;

/**
 * No arg constructor that makes a stack size 10 since it is default
 */
	public MyStack() {
		stack = (T[]) new Object[10];
	}

/**
 * Constructor with size parameter to set size of the stack
 * 
 * @param size of the stack
 */
	public MyStack(int size) {
		stack = (T[]) new Object[size];
	}
	
	/**
     * Pushes an item onto the top of the stack
     *
     * @param item the item to be added to the stack
     * @throws IllegalStateException if the stack is full
     * @throws IllegalArgumentException if the item is null
     */
	@Override
	public void push(T item) {
		if(currentSize == stack.length) {
			throw new IllegalStateException("Stack is full");
		}
		if(item == null) {
			throw new IllegalArgumentException("The sent item doesn't exist");
		}
		stack[currentSize] = item;
		currentSize++;
	}

	/**
     * Removes and returns the item at the top of the stack
     *
     * @return the item most recently added to the stack
     * @throws NoSuchElementException if the stack is empty
     */
	@Override
	public T pop() {
		if(currentSize == 0) {
			throw new NoSuchElementException("Stack is empty");
		}
		T temp = stack[currentSize-1];
		stack[currentSize-1] = null;
		currentSize--;
		return temp;
	}

	/**
     * Returns the item at the top of the stack without removing it
     *
     * @return the item most recently added to the stack
     * @throws NoSuchElementException if the stack is empty
     */
	@Override
	public T peek() {
		if(currentSize == 0) {
			throw new NoSuchElementException("Stack is empty");
		}
		
		return stack[currentSize -1];
	}

	/**
     * Checks whether the stack is empty
     *
     * @return true if the stack is empty, false otherwise
     */
	@Override
	public boolean isEmpty() {
		if(currentSize == 0) {
			return true;
		}
		return false;
	}

	/**
     * Returns the number of elements currently in the stack
     *
     * @return the number of elements in the stack
     */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

	/**
     * Returns an array copy of the stack
     *
     * @return an array representation of the stack
     */
	@Override
	public Object[] toArray() {
		Object[] temp = new Object[currentSize];
		for(int i = 0;i<currentSize;i++) {
			temp[i] = stack[i];
		}
		return temp;

	}

}
