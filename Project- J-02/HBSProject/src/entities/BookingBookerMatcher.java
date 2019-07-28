package entities;

import provided.Matcher;

public class BookingBookerMatcher implements Matcher<Booking>{

	String name;
	
	public BookingBookerMatcher(String name) {
		if ( name!=null)
			this.name = name;	
	}
	

	public boolean match(Booking t) {	//***
		if(t.getBooker().getName() == name)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}