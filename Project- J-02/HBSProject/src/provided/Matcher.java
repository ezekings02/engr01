package provided;

/**
 * The concept of testing whether some object of type T matches a specific
 * pattern.
 * 
 * The concrete pattern is represented by an instance of a concrete class
 * implementing this interface.
 * 
 * @param <T> the type which this matcher tests.
 */
public interface Matcher<T> {
	/**
	 * Matches an object.
	 * 
	 * @param t the object to test
	 * @return true if the object t matches the pattern represented by an
	 *         instance of an implementing class, false otherwise.
	 */
	public abstract boolean match(T t);
}
