package FMS.entities;


import java.io.Serializable;
import java.util.*;

import FMS.provided.Aircraft;
import FMS.provided.DateTime;
import FMS.provided.Passenger;
import FMS.provided.Staff;


/**
 * A flight in the flight management system (FMS).<br>
 * 
 * A flight stores information about place and time of departure and arrival as
 * well as the aircraft and personnel involved. Both crew and passengers can be
 * added to a flight. A flight is ready for boarding as soon as one crew member
 * is assigned (added to the flight). Passengers can be listed (added) and only
 * listed passengers can board the flight. Passengers can only board one flight
 * at a time.
 * 
 * 
 * Flights are naturally ordered by ID.
 * 
 * @author TeM
 *
 */
public abstract class Flight implements Comparable<Flight>, Serializable
{
	
	/**
	 * Creates a String representation of this flight.<br>
	 * 
	 * @see Object#toString()
	 * @ProgrammingProblem.Hint provided
	 */
	
	private String flightID, origin, destination;
	private DateTime departure, arrival;
	private Aircraft vessel;
	private Set<Staff> crew;
	private Set<Passenger> passengers;
		
	public Flight(Flight f) {		
		this.flightID = new String(f.flightID);
		this.origin = new String(f.origin);
		this.destination = new String(f.destination);
		this.departure = new DateTime(f.departure);
		this.arrival = new DateTime(f.arrival); 
		this.crew=new HashSet<Staff>(f.crew.size());
	    for (Staff item : f.crew) {this.crew.add(item);}
	    this.passengers=new HashSet<Passenger>(f.passengers.size());
	    for (Passenger item : f.passengers) {this.passengers.add(item);}
	}
	
	
	public Flight(String flightID, String origin, String destination, DateTime departure, DateTime arrival) {
		setFlightID(flightID);
		setOrigin(origin);
		setDestination(destination);
		setDeparture(departure);
		setArrival(arrival);
	}
	
	public String ensureNonEmtptyNonNull(String str)  throws IllegalArgumentException {
		if(str!=null) {
			return str;
		}
		else {
			throw new IllegalArgumentException(String.format("String cannot be null")); 
		}
	}
	
	
	public final void setFlightID(String flightID) {
		ensureNonEmtptyNonNull(flightID);
		this.flightID = flightID;
	}
	
	public final void setDestination(String destination) {
		ensureNonEmtptyNonNull(destination);
		this.destination = destination;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public final void setOrigin(String origin) {
		ensureNonEmtptyNonNull(origin);
		this.origin = origin;
	}
	
	public DateTime getDeparture() {
		DateTime d = new DateTime(this.departure);
		return d;
	}
	
	public void setDeparture(DateTime departure) {
		this.departure = new DateTime(departure);
	}


	public void setArrival(DateTime arrival) {
		this.arrival = new DateTime(arrival);
	}
	
	public String getFlightID() {
		return flightID;
	}
	
	
	public Flight setVessel(Aircraft vessel) {
		this.vessel = vessel;
		return this;
	}
	
	
	public abstract int getBonusMiles();
	
	public int compareTo(Flight o) {	
		if(this.flightID.equals(o.getFlightID()))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	public boolean add(Staff staff) {
		if(staff != null) {
			for(Staff crewMember: crew) {
				if(crewMember.toString().equals(staff.toString())) {
					System.out.println("Staff member already exists!");
					return false;
				}
				else {
					crew.add(staff);
					System.out.println("Successfully added");
					return true;
				}
			}
		}
		else
			 System.out.println("Object cannot be null");
		return false;
	}
	
	public boolean add(Passenger passenger) {
		if(passenger != null) {
			for(Passenger p: passengers) {
				if(p.toString().equals(passenger.toString())) {
					System.out.println("Passenger already exists!");
					return false;
				}
				else {
					if(vessel.getCapacity() < this.vessel.getCapacity()) {
						passengers.add(passenger);
						System.out.println("Successfully added");
						return true;
					}
					else {
						System.out.println("Vessel's capacity is full");
						return false;
					}
				}
			}
			
		}
		else
			 System.out.println("Object cannot be null");
		return false;
	}

	public boolean readyToBoard() {
		if(crew.isEmpty()) {
			System.out.println("Flight is not ready to board");
			return false;
		}
		else {
			System.out.println("Flight is ready to board");
			return true;
		}
	}

	public boolean boardingCompleted() {
		boolean check = true;
		if(passengers.isEmpty()) {
			System.out.println("Boarding is not completed. No passenger is added yet");
			check = false;
		}
		else {
			for(Passenger p: passengers) {
				if(p.getBoarded().getFlightID() == this.flightID) {
					continue;
				}
				else {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.println("Boarding is completed.");
			}
			else {
				System.out.println("Boarding is not completed. Not all passengers have boarded yet.");
			}
		}
		return check;
	}

	public boolean board(Passenger p) {
		boolean check = false;
		if(readyToBoard()) {
			p.setBoarded(this);
			check = true;
		}
		return check;
	}

	
	
	@Override
	public String toString() {
		return String.format(
				"%5s from %3.3S (%s) to %3.3S (%s)" + " with a crew of %d and %d passengers "
						+ "<%s> boarding%scompleted \n%s\n%s",
				flightID, origin, departure, destination, arrival, crew == null ? 0 : crew.size(),
				passengers == null ? 0 : passengers.size(), vessel == null ? "no vessel" : vessel.toString(),
				boardingCompleted() ? " " : " not ", crew, passengers);
	}
}
