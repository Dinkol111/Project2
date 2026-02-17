import java.util.Comparator;
/**
 * Basic order comparator class that takes two orders and compares their arrival and deadline minutes to see which order takes priority 
 */
public class OrderComparator implements Comparator<Order>{
	/**
	 * Return the arrival minute
	 * @param o1 order 1 that is being compared
	 * @param o2 order 2 that is being compared to order1
	 * @return negative num if order 1 is priority and positive if num 2 is priority or 0 if the both are the same level of priority
	 */
	@Override
	public int compare(Order o1, Order o2) {
		if(o1.getDeadlineMinute()==o2.getDeadlineMinute()) {
			if(o2.getArrivalMinute()==o1.getArrivalMinute()) {
				return 0;
			}
			if(o1.getArrivalMinute()<o2.getArrivalMinute()) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
		if(o1.getDeadlineMinute()<o2.getDeadlineMinute()) {
			return -1;
		}
		
		return 1;
	}

}
