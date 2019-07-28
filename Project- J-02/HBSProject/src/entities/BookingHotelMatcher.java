package entities;

import provided.Matcher;

public class BookingHotelMatcher implements Matcher<Booking>{

	private String name;
	
	public BookingHotelMatcher(String name) {
		if ( name!=null)
			this.name = name;	
	}
	

	public boolean match(Booking t) {	//***
		if(t.getRoom().get(0).getHotel().getName() == name)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
