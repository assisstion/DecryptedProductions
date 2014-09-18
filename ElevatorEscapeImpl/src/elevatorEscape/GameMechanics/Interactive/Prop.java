package elevatorEscape.GameMechanics.Interactive;

import acmx.export.java.util.Map;

/**
 * An interactive object in the game.
 * Almost all interactions happen between props.
 * Anything can be considered a Prop if given attributes.
 * Each Prop has a name and attributes that determine its effects.
 * Methods that modify the Prop return an instance to allow chaining
 * @see Props for some examples and helper methods
 * @author markusfeng
 *
 */
public interface Prop{
	
	//Every Prop should have location, durability, and size attributes
	
	/**
	 * The name denotes what the prop does
	 * @return the name of the prop
	 */
	String getName();
	
	/**
	 * Gets an attribute from a map of attributes;
	 * Returns "" if no attribute is present
	 * @param attribute the attribute to find
	 * @return the value associated with the attribute
	 */
	String getAttribute(String attribute);
	
	/**
	 * Sets an attribute, then returns the instance
	 * @param attribute the attribute to set
	 * @param value the value to be associated with the attribute
	 * @return this instance for chaining
	 */
	Prop setAttribute(String attribute, String value);
	
	/**
	 * Modifies an attribute, then returns the instance
	 * @param modifier the modifier to use
	 * @return the instance for chaining
	 */
	Prop modify(PropModifier modifier);
	
	/**
	 * Returns the map containing the attributes
	 * @return the attributes of the prop
	 */
	Map getAttributes();
}
