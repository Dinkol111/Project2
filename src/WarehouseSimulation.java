/**
 * Represents a simple time-driven simulation.
 */
public class WarehouseSimulation implements SimulationInterface {
	/**
	 * The set of orders that need to be sent
	 */
	private Order[] queue;
	/**
	 * The list of orders that have arrived to the warehouse
	 */
	private MyPriorityQueue<Order> compare;       
	/**
	 * The list of orders that were late
	 */
    private MyStack<Order> lates;
    /**
     * Current minute of the simulation
     */
	private int currentMinute;
	/**
	 * Total orders that arrived at the warehouse
	 */
    private int totalArrived;
    /**
     * Total orders that were successfully sent out
     */
    private int totalShipped;
    /**
     * Total Orders that ended up being late
     */
    private int totalLate;
    /**
     * The current order being counted from the list of orders that need to be sent from the queue
     */
    private int currentOrder;
	
    /**
     * Constructs a WarehouseSimulation with an initial set of orders
     * All counters and the simulation clock start at zero
     *
     * @param q the array of orders to be processed by the simulation
     */
	public WarehouseSimulation(Order[] q) {
		queue = q;
		compare = new MyPriorityQueue<>(new OrderComparator());
		lates = new MyStack<>();
		
		currentMinute = 0;
		totalArrived =0;
		totalShipped = 0;
		totalLate = 0;
	}
	
	/**
	 * Advances the simulation by one minute and processes one order each to be sent
	 */
	@Override
	public void tick() {
		if(currentOrder<queue.length) {
			Order priority = queue[currentOrder];
			priority.setArrivalMinute(currentMinute);
			compare.enqueue(priority);
			totalArrived++;
			currentOrder++;
		}
		
		if(!compare.isEmpty()) {
			Order sent = compare.dequeue();
			totalShipped++;
			if(sent.getDeadlineMinute()<currentMinute) {
				lates.push(sent);
				totalLate++;
			}
		}
		currentMinute++;
	}

	/**
	 * Checks if the simulation has sent all orders
	 *
	 * @return true if all orders have arrived and been shipped and
	 *         false otherwise
	 */
	@Override
	public boolean isFinished() {
		if(currentOrder==queue.length&&compare.isEmpty())
			return true;
		return false;
	}

	/**
	 * Returns the current minute of the simulation
	 *
	 * @return the current simulation minute
	 */
	@Override
	public int getCurrentMinute() {
		return currentMinute; 
	}

	/**
	 * Returns the total number of orders that have arrived
	 *
	 * @return total arrived orders
	 */
	@Override
	public int getTotalArrived() {
		return totalArrived;
	}

	/**
	 * Returns the total number of orders that have been shipped
	 *
	 * @return total shipped orders
	 */
	@Override
	public int getTotalShipped() {
		return totalShipped;
	}

	/**
	 * Returns the total number of orders that were shipped late
	 *
	 * @return total late orders
	 */
	@Override
	public int getTotalLate() {
		return totalLate;
	}
	

}
