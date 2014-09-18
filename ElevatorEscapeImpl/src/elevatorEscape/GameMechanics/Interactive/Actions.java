package elevatorEscape.GameMechanics.Interactive;

/**
 * This class contains a list of sample Actions for use
 * Also, it contains a reference to the effects of Actions
 * @see Action for the action object
 * @author markusfeng
 *
 */
public final class Actions{
	
	/*
	 * Actions list:
	 * 
	 * Name: Break
	 * Can interact: any two Props with durability (i.e. any two props)
	 * Prop1: The tool used (human assisted, optional)
	 * Prop2: The object to break (environment assisted)
	 * Event: Prop1 tries to break Prop2
	 * Test: the two props' durabilities
	 * Outcomes: Both props may break, may damage the holder
	 * 
	 * Name: Switch
	 * Can interact: any prop with switch (either on or off)
	 * Prop1: The tool used (human assisted, optional)
	 * Prop2: The object to switch
	 * Event: Prop1 tries to switch the state of Prop2
	 * Test: whether Prop2 is unswitchable and how Prop1 can fix that
	 * Outcomes: Both props may break, Prop2 may be harder to switch, Prop2 may switch,
	 *     may damage holder
	 * 
	 */
	
	private Actions(){
		//Empty initializer
	}
	
	public static final class Break implements Action{
		
		/**
		 * Checks if prop1 is allowed to break prop2
		 * Almost always return true
		 */
		@Override
		public boolean canInteract(Prop prop1, Prop prop2){
			return Props.hasAttribute(prop1, "durability") &&
					Props.hasAttribute(prop2, "durability");
		}
		
		/**
		 * Simulates an object breaking another object
		 * Can interact: any two Props with durability (i.e. any two props)
		 * Prop1: The tool used (human assisted, optional)
		 * Prop2: The object to break (environment assisted)
		 * Event: Prop1 tries to break Prop2
		 * Test: the two props' durabilities
		 * Outcomes: Both props may break, may damage the holder
		 * Details:
		 * 50% chance for something to break per level if another thing hits it
		 * -25% chance for attacking object to break defending object
		 * -50% chance for defending object to break attacking object
		 * If the defending object is more than two levels higher, the attacker gets hurt
		 * @param prop1 The attacking prop
		 * @param prop2 The defending prop
		 */
		@Override
		public void interact(Prop prop1, Prop prop2){
			if(!canInteract(prop1, prop2)){
				return;
			}
			int d1 = getModifiedDurability(prop1);
			int d2 = getModifiedDurability(prop2);
			if(d1 > d2){
				//The Math.max and Math.min keep chance between 0 and 1
				prop2.modify(new Props.ChanceModifier(new Props.Breaker(),
						Math.max(Math.min((d1 - d2) * 0.5 - 0.25, 1), 0)));
			}
			if(d2 > d1){
				prop1.modify(new Props.ChanceModifier(new Props.Breaker(),
						Math.max(Math.min((d1 - d2) * 0.5 - 0.5, 1), 0)));
			}
			if(d2 - d1 >= 2){
				//TODO hurt attacker
			}
		}
		
		/**
		 * Gets the durability, the modifies it to actual durability
		 * @param prop the Prop to find the durability of
		 * @return the durability
		 */
		public int getModifiedDurability(Prop prop){
			int n = Props.getAttributeInt(prop, "durability");
			if(Props.isAttributeTrue(prop, "tough")){
				n += 1;
			}
			if(Props.isAttributeTrue(prop, "broken")){
				n -= 2;
			}
			//Broken things can't lock
			else if(Props.isAttributeTrue(prop, "locked") && Props.isAttributeTrue(prop, "unlocked")){
				n += 2;
			}
			return n;
		}
		
	}
}
