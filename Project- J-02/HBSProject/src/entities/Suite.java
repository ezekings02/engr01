package entities;

import provided.Hotel;

public class Suite extends Room {

	public Suite(Hotel hotel, double roomNo, int numberOfBeds, int type) {  //***
		super(hotel, roomNo, numberOfBeds, type);
                
		// TODO Auto-generated constructor stub
	}
        

	@Override
	public int netRate() {	//***
		int rate=0;
		if(numberOfBeds == 1)
		{
			rate = 700*numberOfBeds;
		}
		else
		{
			rate = 700+((numberOfBeds-1)*150);
		}
		return rate;
	}
	
	

}
