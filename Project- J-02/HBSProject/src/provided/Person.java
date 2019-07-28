/**
 * 
 */
package provided;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * This class represents a person.
 */
public class Person implements Serializable {

	/**
	 * An unknown id is represented by 0.
	 */
	protected int id = 0;

	/**
	 * An unknown name is represented by null.
	 */
	protected String name = null;

	/**
	 * An unknown date of birth is represented by null.
	 */
	protected Date dateOfBirth = null;

	/**
	 * Calls the corresponding two setter methods.
	 * 
	 * @param name
	 *            of the person
	 * @param dateOfBirth
	 *            of the person
	 */
	/*public Person(String name, Date dateOfBirth) {
		setName(name);
		setDateOfBirth(dateOfBirth);
	}*/

	/**
	 * Calls the first, 2-argument constructor and additionally sets the ID (by
	 * calling the corresponding method).
	 * 
	 * @param name
	 *            of the person
	 * @param dateOfBirth
	 *            of the person
	 * @param id
	 *            of the person
	 */
	public Person(String name, Date dateOfBirth, int id) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.id = id;
	}

	/**
	 * Sets the name of a person if parameter name is known.
	 * 
	 * @param name
	 *            of a person
	 */
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	/**
	 * Sets the date of birth of a person if parameter dateOfBirth is known.
	 * This method is defensive in the sense that this person keeps a copy of
	 * the original date.
	 * 
	 * @param dateOfBirth
	 *            of a person
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		if (dateOfBirth != null) {
			this.dateOfBirth = dateOfBirth;
		}
	}

	/**
	 * Gets the ID.
	 * 
	 * @return id of a person
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return name of a person
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets date of birth as a formatted string representing this date (see
	 * class Date). Format: dd.mm.yyyy
	 * 
	 * @return a formatted String representing this date
	 */
	public String getDateOfBirth() {
		return dateOfBirth.toString();
	}

	/**
	 * Naturally, persons are lexicographically compared by name (see
	 * java.lang.String methods). It is assumed that this person is only
	 * compared to non-null persons.
	 * 
	 * @param p
	 *            the person to compare this person with
	 */
	public int compareTo(Person p) {
		return name.compareTo(p.name);
	}
	
	@Override
	public String toString(){
		return String.format("[%d|%s|%s]",id, name,dateOfBirth);
	}
}