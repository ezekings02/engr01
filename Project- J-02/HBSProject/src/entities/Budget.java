package entities;

import provided.Hotel;

public class Budget extends Room {


	public Budget(Hotel hotel, double roomNo, int numberOfBeds, int type) {  //***
		super(hotel, roomNo, numberOfBeds, type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int netRate()
	{
		return numberOfBeds*35;
	}
	
	



}