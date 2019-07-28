package FMS.entities;

import FMS.provided.Matcher;

public class OriginMatcher extends Object implements Matcher<Flight> {
	private String origin;
	
	public OriginMatcher(String o) {
		this.origin = o;	}


	public boolean match(Flight t) {
		
		if(t.getOrigin().equals(origin))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	}
	


