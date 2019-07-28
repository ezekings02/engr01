package FMS.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import FMS.entities.*;
import FMS.provided.*;
import FMS.util.*;

/**
 * flight management system demo application
 * 
 * @author TeM
 *
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class Main {
	
        private static List<Flight> flights;
        
        public Main(){}
        
    
    	public static int export(List<Flight> flights,String fn) {
    		
    		int no_of_flights = flights.size();
    		String strRep = flights.toString();		//standard string representation
    		try {
    			FileOutputStream fos;
                fos = new FileOutputStream(fn);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(strRep);
                oos.close();
                fos.close();
    		}
    		catch(FileNotFoundException e) {
    			System.out.println("Error, File doesn't exist!");
    		}   
    		catch(IOException i) {
    			System.out.println("Error with file!");
    		}
            return no_of_flights;
    	}
    	
    	
    	public static Set<Flight> filter(Collection<Flight> flights, Matcher<Flight> mtchr)
        {
        	Set<Flight> newSet = new HashSet<Flight>();
        	for(Flight b: flights)
        	{
        		boolean check = mtchr.match(b);
        		if(check == true)
        		{
        			newSet.add(b);
        		}        	
        	}
        	return newSet;
        }
    	
    	public static void print(Collection<Flight> flights)
    	{
    		System.out.println("FlightID "+"Destination "+"Origin "+"Departure "+"Arrival");
            for (Flight f : flights)
        	{
        		System.out.print(f.getFlightID()+" "+f.getOrigin()+" "+f.getDeparture());
        	}
    	}

    	private static List<Flight> init() {
    		// ---------------- aircrafts
    		List<Aircraft> crafts = new LinkedList<Aircraft>();
    		crafts.add(new Aircraft("A3", 3));
    		crafts.add(new Aircraft("C4", 4));
    		crafts.add(new Aircraft("Boeing 737", 175));
    		// ---------------- passengers
    		List<Passenger> passengers = new LinkedList<Passenger>();
    		passengers.add(new Passenger("John", "Doe", "AT00004711"));
    		passengers.add(new Passenger("Jane", "Doe", "AT00000815"));
    		passengers.add(new Passenger("John", "Jackson", "US00004711"));
    		passengers.add(new Passenger("Jack", "Doe", "UK00000007"));
    		passengers.add(new Passenger("Jack", "Johnson", "DE00004711"));
    		// ---------------- staff
    		List<Staff> staff = new LinkedList<Staff>();
    		staff.add(new Staff("Rip", "Riley", "ISIS666", "Pilot"));
    		staff.add(new Staff("Cheryl", "Tunt", "ISIS456", "Chef de Cabin"));
    		staff.add(new Staff("Lana", "Kane", "ISIS001", "Stewardess"));
    		// ---------------- flights
    		List<Flight> flights = new LinkedList<Flight>();
    		flights.add(new ScheduledFlight("OS006", "FRA", "VIE", new DateTime(2018, 06, 25, 6, 30),
    		new DateTime(2018, 06, 25, 8, 55), 800));
    		flights.add(new Charter("OS001", "VIE", "VIE", new DateTime(2018, 06, 23, 6, 30),
    		new DateTime(2018, 06, 23, 8, 55)));
    		flights.add(new Charter("OS381", "ARN", "VIE", new DateTime(2018, 05, 25, 6, 30),
    		new DateTime(2018, 05, 25, 9, 13)));
    		flights.add(new Charter("OS001", "VIE", "JFK", new DateTime(2018, 07, 25, 4, 30),
    		new DateTime(2018, 07, 25, 7, 20)));
    		flights.add(new Charter("OS502", "JFK", "VIE", new DateTime(2018, 06, 28, 18, 30),
    		new DateTime(2018, 06, 28, 19, 55)));
    		flights.add(new ScheduledFlight("OS007", "VIE", "CDG", new DateTime(2018, 06, 28, 21, 00),
    		new DateTime(2018, 06, 29, 0, 05), 1000));
    		flights.add(new ScheduledFlight("OS008", "VIE", "CDG", new DateTime(2018, 06, 1, 6, 30),
    		new DateTime(2018, 06, 1, 8, 05), 1000));
    		Flight f;
 
    		// ---------------- set up flight
    		f = flights.get(0).setVessel(crafts.get(0));
    		
    		f.add(staff.get(0));
    		f.add(staff.get(1));
    		f.add(staff.get(2));
    		// list passengers
    		f.add(passengers.get(0));
    		f.add(passengers.get(1));
    		f.add(passengers.get(2));
    		f.add(passengers.get(3)); //exceeds vessel capacity
    		// board passengers
    		f.board(passengers.get(0)); // board listed passengers
    		f.board(passengers.get(1));
    		f.board(passengers.get(2));
    		f.board(passengers.get(3)); // board a passenger not listed
    		// ---------------- set up flight
    		f = flights.get(1).setVessel(crafts.get(1));
    		f.add(passengers.get(1));
    		f.add(passengers.get(2));
    		f.add(passengers.get(3));
    		f.add(new Staff(passengers.get(0), "Pilot")); //a passenger becomes a pilot
    		f.board(passengers.get(1)); // already on board another flight
    		f.board(passengers.get(3)); // board a passenger
    		// ---------------- set up flight
    		f = flights.get(2).setVessel(crafts.get(2));
    		Passenger p = new Passenger(staff.get(0)); //staff becomes a passenger
    		f.add(passengers.get(2));
    		f.add(passengers.get(1));
    		f.add(passengers.get(3));
    		f.add(p);
    		f.board(p); //no boarding without crew
    		// ---------------- set up flight
    		f = flights.get(3);
    		f.add(passengers.get(2));
    		f.add(passengers.get(1));
    		f.add(passengers.get(3));
    		// ---------------- set up flight
    		f = flights.get(4);
    		f.add(passengers.get(2));
    		f.add(passengers.get(1));
    		f.add(passengers.get(3));
    		// ---------------- set up flight
    		f = flights.get(5);
    		f.add(passengers.get(2));
    		f.add(passengers.get(1));
    		f.add(passengers.get(3));
    		return flights;
    		}
    	
	public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
		
		List<Flight> flights = new LinkedList<Flight>();
		
		String fileName = "D:\\fly.txt";
		flights = init();								//Creates demo data.
		
		//__________________________________//
		
		int exportedFlights = 0;
		exportedFlights = export(flights, fileName);	//Saves several flights to file.
		
		//__________________________________//
		
		System.out.println("***List of all Flights***");	//Prints all flights.
		print(flights);
		
		//__________________________________//
		
		
		OriginMatcher om = new OriginMatcher("VIE");		//filters a collection of entities with a certain filter.
		
		Set<Flight> newSet = new HashSet<Flight>();
		newSet = filter(flights, om);
	}
		
	
			

	
}
