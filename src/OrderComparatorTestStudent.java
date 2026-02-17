import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderComparatorTestStudent {


    @Test
    public void differentDeadline() {
        OrderComparator cmp = new OrderComparator();
        Order one = new Order("one", 4);
        Order two  = new Order("two", 7);
        assertTrue(cmp.compare(one, two) < 0);
    }

    @Test
    public void testSameDeadlineEarlierArrivalFirst() {
        OrderComparator cmp = new OrderComparator();
        Order one = new Order("one",  5);
        one.setArrivalMinute(1);
        Order two  = new Order("two",  5);
        two.setArrivalMinute(2);
        assertTrue(cmp.compare(one, two) < 0);
    }

}
