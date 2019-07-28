package entities;
import java.io.Serializable;

import provided.Hotel;


public abstract class Room implements Serializable {

	Hotel hotel;
	double roomNo;
	int numberOfBeds;
	int type;
	
	public Room(Hotel hotel, double roomNo, int numberOfBeds, int type) {	//***
		super();
		this.hotel = hotel;
		this.roomNo = roomNo;
		this.numberOfBeds = numberOfBeds;
		this.type = type;
	}
    
	public abstract int netRate();

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public double getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(double roomNo) {
		this.roomNo = roomNo;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}

	@Override
	public String toString() {
		return "Room []";
	}
	
	
	

}