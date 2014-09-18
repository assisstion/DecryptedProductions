package elevatorEscape.GameMechanics.Interactive;

/**
 * An Action represents a method of between two Props.
 * Each Action takes in two Props and may modify those Props.
 * Check if an Action can take place with canInteract(Prop, Prop).
 * @see Actions for some example actions
 * @author markusfeng
 *
 */
public interface Action{
	
	/**
	 * Sees if an interaction can be done (i.e. something will be affected)
	 * Some props may be optional with some actions
	 * @param prop1 the first Prop (order may matter)
	 * @param prop2 the second Prop (order may matter)
	 * @return if the interaction can be done
	 */
	boolean canInteract(Prop prop1, Prop prop2);
	
	/**
	 * Represents an interaction between two Props
	 * Some props may be optional with some actions
	 * @param prop1 the first Prop (order may matter)
	 * @param prop2 the second Prop (order may matter)
	 */
	void interact(Prop prop1, Prop prop2);
	
}
