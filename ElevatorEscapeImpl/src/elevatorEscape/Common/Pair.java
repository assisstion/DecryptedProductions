package elevatorEscape.Common;

import java.io.Serializable;

/**
 * A class representing a pair of two Objects
 * @author markusfeng
 *
 * @param <T> the first value of the pair
 * @param <S> the second value of the pair
 */
public class Pair<T, S> implements Serializable{
	
	private static final long serialVersionUID = -8076809629855557338L;
	//Java 1.7 and up:
	//private static final int LOW_MASK = 0b0000000011111111;
	//private static final int HIGH_MASK = 0b1111111100000000;
	
	protected T valueOne;
	protected S valueTwo;
	
	/**
	 * Creates an empty pair
	 */
	protected Pair(){
		//Do nothing
	}
	
	/**
	 * Creates a Pair that is a copy of the original
	 * @param original the pair to copy
	 */
	public Pair(Pair<T, S> original){
		this(original.getValueOne(), original.getValueTwo());
	}
	
	/**
	 * Creates a pair with the values of valueOne and valueTwo
	 * @param valueOne the first value of the pair
	 * @param valueTwo the second value of the pair
	 */
	public Pair(T valueOne, S valueTwo){
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}
	
	/**
	 * @return the first value of the pair
	 */
	public T getValueOne(){
		return valueOne;
	}
	
	/**
	 * @return the second value of the pair
	 */
	public S getValueTwo(){
		return valueTwo;
	}
	
	@Override
	public String toString(){
		String valueOneString = getValueOne() == null ? "null" : getValueOne().toString();
		String valueTwoString = getValueTwo() == null ? "null" : getValueTwo().toString();
		return "Pair: [" + valueOneString + "," + valueTwoString + "]";
	}
	
	/**
	 * Checks if both Objects of two pairs are equal.
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof Pair<?, ?>){
			Pair<?, ?> p = (Pair<?, ?>) o;
			if(getValueOne().equals(p.getValueOne()) && getValueTwo().equals(p.getValueTwo())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return getValueOne().hashCode() ^ getValueTwo().hashCode() << 16 ^ getValueTwo().hashCode() >> 16;
		//Java 1.7 and up:
		//return getValueOne().hashCode() << 8 ^ HIGH_MASK ^ getValueTwo().hashCode() >> 8 ^ LOW_MASK;
	}
}
