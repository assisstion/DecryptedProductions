package elevatorEscape.Common;

import acmx.export.java.util.Iterator;
import acmx.export.java.util.List;
import acmx.export.java.util.Map;

/**
 * Converts objects into custom String representations
 * @author markusfeng
 *
 */
public class StringValue{
	
	/**
	 * Converts an Object to a String
	 * First calls the methods from this function,
	 * then calls the default toString() method.
	 * @param o the Object to convert to String
	 * @return the String represnetation of the Object
	 */
	public static String valueOf(Object o){
		if(o instanceof Map){
			return mapToString((Map) o);
		}
		if(o instanceof List){
			return listToString((List) o);
		}
		return o.toString();
	}
	
	/**
	 * Converts a Map to a readable String
	 * Each key and entry is separated by an =
	 * Each key/entry pair is separated by a new line
	 * @param map the Map to convert to String
	 * @return the String representation of the Map
	 */
	public static String mapToString(Map map){
		String s = "";
		Object o = new Object();
		boolean first = true;
		for(Iterator i = map.keySet().iterator();
				i.hasNext();){
			if(first){
				first = false;
			}
			else{
				s += "\n";
			}
			o = i.next();
			s += valueOf(o) + "=" + valueOf(map.get(o));
		}
		return s;
	}
	
	/**
	 * Converts a List to a readable String
	 * Each entry is separated by a ,
	 * @param list the List to convert to String
	 * @return the String representation of the List
	 */
	public static String listToString(List list){
		String s = "";
		boolean first = true;
		for(int i = 0; i < list.size(); i++){
			if(first){
				first = false;
			}
			else{
				s += ", ";
			}
			s += valueOf(list.get(i));
		}
		return s;
	}
}
