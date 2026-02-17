
/**
 * Order object class that stores the ID and its deadline and arrival time
 */
public class Order {

/**
 * ID of the order
 */
	private String orderID;

/**
 * When the order will arrive at the warehouse to be stored in the queue
 */
	private int arrival;

/**
 * The last minute to which the order can be shipped out without being considered late
 */
	private int deadline;
	

/**
 * Constructor thats sets the order ID and its deadline
 * 
 * @param id of the order
 * @param deadlin deadline for the order
 */
	public Order(String id, int deadlin) {
		orderID = id;
		deadline = deadlin;
	}

/**
 * Set the arrival minute of the order
 * 
 * @param arrive arrival of the order in the warehouse
 */
	public void setArrivalMinute(int arrive) {
		arrival = arrive;
	}
	

/**
 * Return the arrival minute
 * 
 * @return when the order arrived at the warehouse
 */
	public int getArrivalMinute() {
		return arrival;
	}
	/**
	 * Return the deadline minute
	 * 
	 * @return deadline for the order
	 */	
	public int getDeadlineMinute() {
		return deadline;
	}
	/**
	 * Return the ID for the order
	 * 
	 * @return ID of the order
	 */
	public String getId() {
		
		return orderID;
	}
	
}
