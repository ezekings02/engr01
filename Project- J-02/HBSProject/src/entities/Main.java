package entities;

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

import provided.Hotel;
import provided.Matcher;
import provided.Person;

public class Main {
        private static Set<Booking> bookings;
       public Main(){}
        
    
    	private static void export(Set<Booking> bookings,String fn) throws IOException, ClassNotFoundException {
    		
    			FileOutputStream fos;
                fos = new FileOutputStream(fn);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(bookings);
                oos.close();
                fos.close();
                
                Set<Booking> data=null;      
                FileInputStream fis;
                fis = new FileInputStream(fn);
               
                ObjectInputStream ois;
                ois = new ObjectInputStream(fis);
                data= (HashSet<Booking>) ois.readObject();
                ois.close();
                fis.close();
                System.out.println("BookingNo "+"PersonName "+"Pid "+"DoB "+"HotelID "+"HotelName "+"RoomNo "+"nBeds "+"Type");
                for (Booking e : bookings)
            	{
            		System.out.print(e.getBookingNo()+" "+e.getBooker().getName()+" "+e.getBooker().getId()+" "+e.getBooker().getDateOfBirth()+" ");
            		for(Room roo : e.getRoom())
            		{
            			System.out.println(roo.getHotel().getHotelNo()+" "+roo.getHotel().getName()+" "+roo.getRoomNo()+" "+roo.getNumberOfBeds()+" "+roo.getType());	
            		}
            	}
                System.out.println("************");
                int sum=0;
                for (Booking e : bookings)
            	{
                	
                	for(Room roo : e.getRoom())
            		{
                		sum = roo.netRate();
            		}
            	}
                System.out.println("Sum of net rates: "+sum);
			}
    	
    	
    	private static Set<Booking> filter(Collection<Booking> bookings, Matcher<Booking> mtchr)
        {
        	Set<Booking> newSet = new HashSet<Booking>();
        	for(Booking b: bookings)
        	{
        		boolean check = mtchr.match(b);
        		if(check == true)
        		{
        			newSet.add(b);
        		}        	
        	}
        	return newSet;
        }
    	
        private static void init(Set<Booking> bookings)
        {
       
        	System.out.println("BookingNo "+"Person Name "+"Pid "+"DoB "+"HotelID "+"HotelName "+"RoomNo "+"nBeds "+"Type");
        	for (Booking e : bookings)
        	{
        		System.out.print(e.getBookingNo()+" "+e.getBooker().getName()+" "+e.getBooker().getId()+" "+e.getBooker().getDateOfBirth()+" ");
        		for(Room roo : e.getRoom())
        		{
        			System.out.println(roo.getHotel().getHotelNo()+" "+roo.getHotel().getName()+" "+roo.getRoomNo()+" "+roo.getNumberOfBeds()+" "+roo.getType());	
        		}
        	}
        	System.out.println("__________________________");
        }
        
        private static void filteredBookings(Set<Booking> newSet, String fn) throws IOException, ClassNotFoundException
        {
        	FileOutputStream fos;
            fos = new FileOutputStream(fn);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newSet);
            oos.close();
            fos.close();
        }
        

	public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
		
		//______________________________________//
		
		Set<Booking> bookingSet = new HashSet<Booking>();
		
		String s = "27/11/1969";
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = sd.parse(s);
		Person p1 = new Person("John Doe", dob, 69);
		Booking b1 = new Booking(45678921, p1);
		Hotel h1 = new Hotel(12, "Thrift");
		Room r1 = new Budget(h1, 154, 4, 3);
		b1.addRoom(r1);
		Booking b2 = new Booking(45678921, p1);
		Room r2 = new Premium(h1, 155, 2, 2);
		b2.addRoom(r2);
		s = "15/12/1970";
        sd = new SimpleDateFormat("dd/MM/yyyy");
        dob = sd.parse(s);
		Person p2 = new Person("John Jackson", dob, 88);
		Booking b3 = new Booking(10000001, p2);
		Hotel h2 = new Hotel(2, "Hilton");
		Room r3 = new Premium(h2, 12, 1, 1);
		b3.addRoom(r3);
		s = "23/05/1931";
        sd = new SimpleDateFormat("dd/MM/yyyy");
        dob = sd.parse(s);
		Person p3 = new Person("Jack Johnson", dob, 01);
		Booking b4 = new Booking(45789521, p3);
		Hotel h3 = new Hotel(789, "HolidayInn");
		Room r4 = new Suite(h3, 66, 8, 3);
		b4.addRoom(r4);
		s = "01/10/1956";
        sd = new SimpleDateFormat("dd/MM/yyyy");
        dob = sd.parse(s);
		Person p4 = new Person("Jack Doe", dob, 83);
		Booking b5 = new Booking(10400001, p4);
		Room r5 = new Budget(h1, 160, 2, 2);
		b5.addRoom(r5);
		bookingSet.add(b1);
		bookingSet.add(b2);
		bookingSet.add(b3);
		bookingSet.add(b4);
		bookingSet.add(b5);
		String fileName = "D:\\bookings.txt";
		//export(bookingSet, fileName);
		init(bookingSet);
		//__________________________________//
		
		Matcher bhm = new BookingHotelMatcher("Thrift");
		Matcher bbm = new BookingBookerMatcher("Jack Johnson");
		
		Set<Booking> newSet = new HashSet<Booking>();
		newSet = filter(bookingSet, bhm);
		newSet = filter(bookingSet, bbm);
		String newFile = "D:\\FilteredBookings.txt";
		//filteredBookings(newSet, newFile);
	}
		
	
			

	
}
