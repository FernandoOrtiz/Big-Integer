package objects;

/**
 * Class that creates an object of variable that holds a big number
 * 
 * @author Fer
 *
 */
public class var {

	private String name;
	private BigNum number;

	/**
	 * Constructor creates the variable holding a big number initialized at "0"
	 * @param name reference to the name of the new variable
	 */
	public var(String name){
		this.name = name;
		number = new BigNum("0");

	}

	/**
	 * Sets the value of the big number to a new one
	 * @param val reference to the new value of the big number stored by the variable
	 */
	public void setValue(String val){
		number.setValue(val);
	}

	/**
	 * 
	 * @return reference of the value of the big number stored by the variable
	 */
	public String getValue(){
		return number.getValue();
	}

	/**
	 * 
	 * @return the big number object to be able to access operations 
	 */
	public BigNum getBigNum(){
		return number;
	}
	
	/**
	 * 
	 * @return reference to the name of the variable
	 */
	public String getName(){
		return name;
	}

}
