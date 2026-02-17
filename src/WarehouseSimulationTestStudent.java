import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseSimulationTestStudent {

	

	@Test
	public void fullWarehouseSimulation() {
	    
	    Order[] orders = new Order[] {new Order("1", 5),  new Order("2", 0),  new Order("3", 1)};

	    WarehouseSimulation sim = new WarehouseSimulation(orders);

	    while (!sim.isFinished()) {
	        sim.tick();
	    }
	    assertEquals(3, sim.getTotalArrived());
	    assertEquals(3, sim.getTotalShipped());
	    assertEquals(2, sim.getTotalLate());
	    assertEquals(3, sim.getCurrentMinute());
	}

}
