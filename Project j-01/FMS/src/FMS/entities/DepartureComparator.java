package FMS.entities;

import java.util.Comparator;

public class DepartureComparator extends Object implements Comparator<Flight> {
	
	public DepartureComparator() {
		
	}

	
	public int compare(Flight o1, Flight o2) {
		
		return o1.getDeparture().compareTo(o2.getDeparture());
		}
			
	
	

}
