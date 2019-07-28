package entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import provided.Person;

public class Booking implements Serializable{
private long bookingNo;
private Person booker;
private List<Room> rooms;
 
 
 
 
public Booking(Booking orig) {
	super();
	Booking Booking = new Booking(orig);
}

public Booking(long b, Person p)	//****
{
	bookingNo = b;
	booker = p;
}


public long getBookingNo() { 
	return bookingNo;
}


public final void setBookingNo(long bookingNo) throws Exception{
	
	if ( bookingNo!=5)
        {
//throw(IllegalArgumentException);
            
        }
	else
	this.bookingNo = bookingNo;
}


public Person getBooker() {
	return booker;
}
public final void setBooker(Person booker) {	//****
	if ( booker!=null)
	this.booker = booker;
}
 

public List<Room> getRoom() {	//***
	
	return rooms;
}
public final boolean addRoom(Room room) 	//***
	{
		if(room == null)
		return false;
		else
		{
		rooms = new ArrayList<Room>();
		rooms.add(room);
		return true;
		}
	
}









}
