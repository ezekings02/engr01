package provided;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

import entities.Room;

/**
 * Represents a hotel in the HBS.
 * 
 * @author TeM
 *
 */
public class Hotel implements Serializable {
	/**
	 * The number of this hotel in the HBS.
	 */
	private long hotelNo;
	
	/**
	 * The name of this hotel.
	 */
	private String name;

	/**
	 * The rooms in this hotel.
	 */
	private Set<Room> rooms = new HashSet<Room>();

	/**
	 * Sets the hotel number.
	 * 
	 * @param hotelNo the hotel number to set
	 */
	public Hotel(long hotelNo) {
		setHotelNo(hotelNo);
	}

	/**
	 * Sets the name and the number of the hotel.
	 * 
	 * @param hotelNo the hotel number to set
	 * @param name the name to set
	 */
	public Hotel(long hotelNo, String name) {
		setHotelNo(hotelNo);
		setName(name);
		}

	/**
	 * @return the hotelNo
	 */
	public long getHotelNo() {
		return hotelNo;
	}

	/**
	 * @param hotelNo
	 *            the hotelNo to set
	 */
	public void setHotelNo(long hotelNo) {
		this.hotelNo = hotelNo;
	}

	/**
	 * @return the rooms
	 */
	public Set<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms
	 *            the rooms to set
	 */
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	@Override 
	public String toString(){
		return String.format("[%d|%s]", hotelNo, name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
