package elevatorEscape.GameMechanics.Interactive;

/**
 * This class contains list of sample Props for use
 * Also, it contains helper methods to using Props
 * And a reference to the attributes of Props
 * When using, make a new instance as a copy of the old one
 * @see Prop for the Prop object
 * @author markusfeng
 * 
 */
public final class Props{
	
	/*
	 * 
	 * Every prop should have a location, durability, and size
	 * 
	 * Durability list:
	 * 0: Breaks by itself
	 * 1: Breaks by hand without injury
	 * 2: Breaks by hand with injury; Breaks by body without injury;
	 * 3: Breaks by body with injury; Breaks by tools
	 * 4: Breaks by tools which may break; Cannot break by body
	 * 5: Unbreakable
	 * 
	 * locked adds 2 to written durability and can be unlocked with a key
	 * broken subtracts 2 from durability
	 * tough adds 1 to written durability
	 * 
	 * Size list:
	 * tiny: paper clip, pencil, eraser, pin, key, coin
	 * small: lightbulb, rope, laptop, water bottle
	 * medium: window, chair, dog
	 * large: table, sofa, human, door
	 * huge: car, boat
	 * 
	 * Location list:
	 * wall: painting, window, door, switch
	 * floor: carpet, table, chair, sofa, switch
	 * ceiling: lightbulb, sprinkler
	 * 
	 * Luminosity list:
	 * 0: none
	 * 1: small LED
	 * 2: candle, dim bulb
	 * 3: bright bulb, fire, dim flashlight
	 * 4: bright flashlight, laser
	 * 5: sun
	 * 
	 * sleepable = able to sleep comfortably on
	 */
	
	private Props(){
		//Empty initializer
	}
	
	private static final int propNumber = 4;
	
	public static final Prop ROPE = new GenericProp("rope").
			setAttribute("location", "ground").
			setAttribute("durability", "2").
			setAttribute("size", "small");
	public static final Prop WINDOW = new GenericProp("window").
			setAttribute("durability", "2").
			setAttribute("location", "wall").
			setAttribute("size", "medium");
	public static final Prop LIGHTBULB = new GenericProp("lightbulb").
			setAttribute("durability", "2").
			setAttribute("luminosity", "2").
			setAttribute("size", "small").
			setAttribute("location", "ceiling").
			setAttribute("switch", "off");
	public static final Prop SOFA = new GenericProp("sofa").
			setAttribute("durability", "3").
			setAttribute("size", "large").
			setAttribute("location", "ground").
			setAttribute("sleepable", "true");
	
	/**
	 * Checks if a prop has an attribute set
	 * @param prop the prop to check
	 * @param attribute the attribute to check
	 * @return whether the prop has the attribute set
	 */
	public static boolean hasAttribute(Prop prop, String attribute){
		if(!prop.getAttribute(attribute).equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a prop has an attribute set to true
	 * @param prop the prop to check
	 * @param attribute the attribute to check
	 * @return whether the prop has the attribute set to true
	 */
	public static boolean isAttributeTrue(Prop prop, String attribute){
		if(prop.getAttribute(attribute).equals("true")){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a prop has an attribute set to a certain value
	 * @param prop the prop to check
	 * @param attribute the attribute to check
	 * @param value the value to compare to
	 * @return whether the prop has the attribute set to a certain value
	 */
	public static boolean isAttributeValue(Prop prop, String attribute, String value){
		if(prop.getAttribute(attribute).equals(value)){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the value of the attribute
	 * @param prop the prop to use
	 * @param attribute the attribute to find
	 * @return the value of the attribute
	 */
	public static String getAttributeString(Prop prop, String attribute){
		return prop.getAttribute(attribute);
	}
	
	/**
	 * Returns the value of the attribute as an int
	 * Returns -1 if the number cannot be formatted
	 * @param prop the prop to use
	 * @param attribute the attribute to find
	 * @return the int representation of the value of the attribute
	 */
	public static int getAttributeInt(Prop prop, String attribute){
		try{
			return Integer.parseInt(getAttributeString(prop, attribute));
		}
		catch(NumberFormatException e){
			return -1;
		}
	}
	
	/**
	 * Generates a random Prop
	 * @return the Prop generated
	 */
	public static Prop getRandomProp(){
		int i = (int) (Math.random() * propNumber);
		switch(i){
			case 0:
				return new GenericProp(ROPE);
			case 1:
				//80% chance of locked window
				return new GenericProp(WINDOW).
						modify(new ChanceModifier(new Locker(), 0.8));
			case 2:
				//30% chance of switched on lightbulb
				return new GenericProp(LIGHTBULB).
						modify(new ChanceModifier(new Switcher(true), 0.3));
			case 3:
				return new GenericProp(SOFA);
			default:
				return null;
		}
	}
	
	/**
	 * A modifier wrapper with a chance of applying the wrapped modifier
	 * @author markusfeng
	 *
	 */
	public static class ChanceModifier implements PropModifier{
		protected PropModifier modifier;
		protected double chance;
		
		/**
		 * A given chance is applied each time modify is called to see if it succeeds
		 * @param mod the modifier to apply
		 * @param chance a value between 0 and 1
		 */
		public ChanceModifier(PropModifier mod, double chance){
			if(chance < 0 || chance > 1){
				throw new IllegalArgumentException("Invalid chance!");
			}
			modifier = mod;
			this.chance = chance;
		}
		
		@Override
		public Prop modify(Prop input){
			if(Math.random() < chance){
				return input.modify(modifier);
			}
			return input;
		}
	}
	
	
	public static class Locker implements PropModifier{
		
		@Override
		public Prop modify(Prop input){
			return input.setAttribute("locked", "true");
		}
	}
	
	public static class Breaker implements PropModifier{
		
		@Override
		public Prop modify(Prop input){
			return input.setAttribute("broken", "true");
		}
	}
	
	public static class Toughener implements PropModifier{
		
		@Override
		public Prop modify(Prop input){
			return input.setAttribute("tough", "true");
		}
	}
	
	public static class Switcher implements PropModifier{
		
		protected boolean on;
		
		/**
		 * @param on if the switch is on
		 */
		public Switcher(boolean on){
			this.on = on;
		}
		
		@Override
		public Prop modify(Prop input){
			return input.setAttribute("switch", on ? "on" : "off");
		}
	}
}
