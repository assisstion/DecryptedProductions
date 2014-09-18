package elevatorEscape.GameMechanics;

/**
 * An representation of the elevator system
 * @author markusfeng
 *
 */
public interface ElevatorSystem{
	/**
	 * Sends the player in the elevator to the floor
	 * @param floor the floor to go to
	 */
	void goToFloor(int floor);
	
	/**
	 * @return whether the floor is inaccessible from the elevator
	 */
	boolean isFloorBlocked();
	
	/**
	 * @return the current player's floor
	 */
	int getCurrentPlayerFloor();
	
	/**
	 * @return the current elevator's floor
	 */
	int getCurrentElevatorFloor();
	
	/**
	 * @return the current data for all of the floors
	 */
	Floor[] getFloorData();
}
