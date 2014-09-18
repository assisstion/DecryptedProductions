package elevatorEscape.GameMechanics.Interactive;

/**
 * The PropModifier class is used for modifying Props
 * It can dynamically modify a prop depending on the input
 * @author markusfeng
 *
 */
public interface PropModifier{
	/**
	 * Modifies the attributes of a prop
	 * @param input the prop to modify
	 * @return the prop instance for chaining
	 */
	Prop modify(Prop input);
}
