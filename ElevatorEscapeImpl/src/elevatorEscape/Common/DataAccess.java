package elevatorEscape.Common;

//An optional DataAccess class for non-Java-implemented methods
//Use acm where possible
public interface DataAccess{
	int getScreenWidth();
	int getScreenHeight();
	
	boolean isKeyDown(String key);
	boolean isKeyUp(String key);
	boolean isKeyPressed(String key);
	
	/*
	 * 1 = left click
	 * 2 = right click
	 */
	boolean isMouseDown(int mouseKey);
	
	Vector2 getMouseLocation();
	
	//Math functions and print functions can be manually transferred
}
