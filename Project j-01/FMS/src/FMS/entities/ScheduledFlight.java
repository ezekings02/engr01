package FMS.entities;

import java.util.Set;

import FMS.provided.Aircraft;
import FMS.provided.DateTime;
import FMS.provided.Passenger;
import FMS.provided.Staff;

public class ScheduledFlight extends Flight {

	private int distance;
	
	public ScheduledFlight(String flightID, String destination,
			String origin, DateTime departure, 
			DateTime arrival,int distance) {
		super(flightID, destination, origin, departure, arrival);
		this.distance = distance;
	}

	public ScheduledFlight(ScheduledFlight f) {
		super(f);
		distance = f.distance;
	}
	
	
	@Override
	public int getBonusMiles() {
		int bonusMile = (int) Math.floor(distance);
		return bonusMile;
	}
	

}
