package elevatorEscape.GameMechanics;

import acmx.export.java.util.Map;

/**
 * Represents a floor in the game.
 * Contains information about the props on the floor.
 * @author markusfeng
 *
 */
public interface Floor{
	
	/**
	 * A Map<Vector2, Prop> describing the location of each prop.
	 * @return the map containing the prop information
	 */
	//Map<Vector2, Prop>
	Map getPropMap();
	
	/**
	 * The floor number
	 * @return the number of the floor
	 */
	int getFloorNumber();
}
