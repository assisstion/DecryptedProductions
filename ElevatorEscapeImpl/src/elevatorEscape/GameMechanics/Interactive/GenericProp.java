package elevatorEscape.GameMechanics.Interactive;

import acmx.export.java.util.HashMap;
import acmx.export.java.util.Iterator;
import acmx.export.java.util.Map;
import elevatorEscape.Common.StringValue;

/**
 * A generic implementation of a Prop.
 * @see Prop for more details
 * @author markusfeng
 *
 */
public class GenericProp implements Prop{
	
	//Map<String, String>
	protected Map attributes;
	protected String name;
	
	private static final boolean PRINT_ATTRIBUTES = true;
	
	/**
	 * Creates a new prop with a name
	 * @param name
	 */
	public GenericProp(String name){
		this();
		this.name = name;
		attributes = new HashMap();
	}
	
	/**
	 * Copies the data from another GenericProp to this prop
	 * @param prop the GenericProp to copy from
	 */
	public GenericProp(Prop prop){
		this(prop.getName());
		attributes = new HashMap();
		Object o = null;
		for(Iterator i = prop.getAttributes().keySet().iterator();
				i.hasNext();){
			o = i.next();
			attributes.put(o, prop.getAttributes().get(o));
		}
	}
	
	protected GenericProp(){
		//Do nothing
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getAttribute(String attribute){
		Object o = attributes.get(attribute);
		return o == null ? "" : (String) o;
	}
	
	@Override
	public Map getAttributes(){
		return attributes;
	}
	
	@Override
	public GenericProp setAttribute(String attribute, String value){
		attributes.put(attribute, value);
		return this;
	}
	
	@Override
	public String toString(){
		String s = "";
		s += "Prop" + "\n" +
				"Name: " + getName() + "\n" +
				(PRINT_ATTRIBUTES
						? "Attributes: " + StringValue.valueOf(attributes)
								: "");
		return s;
	}
	
	@Override
	public Prop modify(PropModifier modifier){
		return modifier.modify(this);
	}
	
}
