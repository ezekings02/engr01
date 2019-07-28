package entities;

import provided.Hotel;

public class Premium extends Room {

	public Premium(Hotel hotel, double roomNo, int numberOfBeds, int type) {  //***
		super(hotel, roomNo, numberOfBeds, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int netRate() {	//***
		int BP;
		if (numberOfBeds <= 2)
		{
			BP = numberOfBeds*200;
		}
		else
		{
			BP = (numberOfBeds*200)+50;
		}
		return BP;
	}
	
	

}
