package elevatorEscape.GameMechanics;

import acmx.export.java.util.HashMap;
import acmx.export.java.util.Map;
import elevatorEscape.Common.StringValue;
import elevatorEscape.Common.Vector2;
import elevatorEscape.GameMechanics.Interactive.Props;

/**
 * A generic implementation of a Floor
 * @author markusfeng
 *
 */
public class GenericFloor implements Floor{
	
	protected Map propMap;
	protected int floorNumber;
	
	protected GenericFloor(){
		//Do nothing
	}
	
	/**
	 * Creates a GenericFloor
	 * @param propMap a Map<Vector2, Prop> containing the Prop data
	 * @param floorNumber the floor number
	 */
	public GenericFloor(Map propMap, int floorNumber){
		this();
		this.propMap = propMap;
		this.floorNumber = floorNumber;
	}
	
	@Override
	public Map getPropMap(){
		return propMap;
	}
	
	@Override
	public int getFloorNumber(){
		return floorNumber;
	}
	
	/**
	 * Generates a random GenericFloor
	 * @param number the floor number
	 * @return the randomly generated floor
	 */
	public static GenericFloor generateRandomFloor(int number){
		//size
		final float maxSize = 20.0f;
		//chance for another prop
		final double chance = 0.6;
		//hard max props
		final int maxProps = 20;
		
		Map map = new HashMap();
		//Each floor has at least 2 props
		int props = 2;
		//Each additional prop has an additional size
		while(Math.random() < chance){
			props++;
			if(props > maxProps){
				break;
			}
		}
		for(int i = 0; i < props; i++){
			map.put(new Vector2(Math.random() * maxSize, Math.random() * maxSize), Props.getRandomProp());
		}
		GenericFloor floor = new GenericFloor(map, number);
		return floor;
		
	}
	
	@Override
	public String toString(){
		String s = "";
		s += "Floor" + "\n" +
				"Number: " + getFloorNumber() + "\n" +
				"Props: " + StringValue.valueOf(getPropMap());
		return s;
	}
	
	
}
