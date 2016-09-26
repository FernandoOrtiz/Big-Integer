package objects;

/**
 * Class to create an object of big number to do certain operations over it 
 * @author Fer
 *
 */
public class BigNum {

	private String value;
	private boolean negative;
	/**
	 * Constructor creates object of type big number be the value stated
	 * @param value reference to the value of the new big number
	 */
	public BigNum(String value){
		if(value.charAt(0)=='-'){
			negative = true;
			this.value = value.substring(1);
		}
		else if(value.charAt(0)=='+'){
			negative = false;
			this.value = value.substring(1);

		}
		else{
			negative = false;
			this.value=value;

		}

	}


	private boolean gratherThan(String val){
		if(value.length()>val.length()){
			return true;
		}
		else if(value.length()==val.length()){
			for(int i =value.length();i>=0;i--){
				if(Character.getNumericValue(value.charAt(i))>Character.getNumericValue(val.charAt(i))){
					return true;
				}
			}
		}
		return false;
	}

	// operation methods

	/**
	 * Adds the current big number with another value 
	 * @param val value to be added to the current big number
	 * @return reference to the result of the addition 
	 */
	public String add(String val){

		if(val.charAt(0)=='-'&&negative){
			val=val.substring(1);
			return "-"+xadd(val);

		}
		else if(val.charAt(0)=='+'&&!negative){
			val=val.substring(1);
			return xadd(val);

		}
		else if(val.charAt(0)=='+'&&negative){
			val=val.substring(1);
			if(gratherThan(val)){
				return "-"+xsub(val);

			}
			return xsub(val);	
		}
		else if(val.charAt(0)=='-'&&!negative){
			val=val.substring(1);
			if(gratherThan(val)){
				return xsub(val);

			}
			return "-"+xsub(val);	
		}

		else if(!negative){
			return xadd(val);
		}
		else if(negative){
			if(gratherThan(val)){
				return "-"+xsub(val);

			}
			return xsub(val);
		}

		return"Something went Wrong";

	}

	/**
	 * Method that executes the adding method
	 * 
	 * 
	 */
	public String xadd(String val){
		int carry = 0;
		String result ="";
		if(value.length()>val.length()){
			while(value.length()!=val.length()){
				val = "0"+val;
			}
		}
		else if(value.length()<val.length()){
			while(value.length()!=val.length()){
				value = "0"+value;
			}
		}
		if(value.length()==val.length()){
			for(int i = value.length()-1; i>=0; i--){
				int val1 = Character.getNumericValue(value.charAt(i));
				int val2 = Character.getNumericValue(val.charAt(i));
				String tmp = Integer.toString(val1+val2+carry);
				carry = 0;
				if(tmp.length()>1){
					carry = Character.getNumericValue(tmp.charAt(0));	
				}
				if(tmp.length()>1){
				tmp = tmp.substring(1);
				}
				result = tmp+result;


			}
			if (carry>0){
				result = carry+result;
			}
			int i = 0;
			while(result.charAt(i)==0){
				i++;
			}
			result = result.substring(i,result.length());
			return result;

		}

		return "Something Went Wrong";
	}

	/**
	 * Subtract the current big number with another value
	 * @param val value to be subtracted from the big number
	 * @return reference to the result of the subtraction 
	 */
	public String sub(String val){

		if(val.charAt(0)=='-'&&negative){
			val=val.substring(1);
			if(gratherThan(val)){
				return "-"+xsub(val);

			}
			return xsub(val);

		}
		else if(val.charAt(0)=='+'&&!negative){
			val=val.substring(1);
			if(gratherThan(val)){
				return xsub(val);

			}
			return "-"+xsub(val);

		}
		else if(val.charAt(0)=='+'&&negative){
			val=val.substring(1);
			return "-"+xadd(val);
		}
		else if(val.charAt(0)=='-'&&!negative){
			val=val.substring(1);
			return xadd(val);
		}

		else if(!negative){
			val=val.substring(1);
			if(gratherThan(val)){
				return xsub(val);
			}
			return "-"+xsub(val);

		}
		else if(negative){
			val=val.substring(1);
			return "-"+xadd(val);
		}

		return"Something went Wrong";

	}

	/**
	 * Method that executes the substraction method
	 * 
	 * 
	 */
	public String xsub(String val){
		int borrow = 0;
		String result ="";
		String tmp = "";
		boolean equalLength = true;
		if(value.length()>val.length()){
			while(value.length()!=val.length()){
				val = "0"+val;
				equalLength=false;
			}
		}
		else if(value.length()<val.length()){
			while(value.length()!=val.length()){
				value = "0"+value;
				equalLength=false;
			}
		}
		if(value.length()==val.length()){
			for(int i = value.length()-1; i>=0; i--){
				int val1 = Character.getNumericValue(value.charAt(i));
				int val2 = Character.getNumericValue(val.charAt(i));
				if(val1>=val2){
					tmp = Integer.toString(val1-val2-borrow);
					borrow = 0;
				}
				else if(i>0){
					val1 = val1+10;
					tmp = Integer.toString(val1-val2-borrow);

				}
				else{
					tmp = Integer.toString(val2-val1-borrow);

				}

				result = tmp+result;


			}
			int i = 0;
			while(result.charAt(i)==0){
				i++;
			}
			if(equalLength){
				result = result.substring(i,result.length());

			}
			else{
				result = result.substring(i+1,result.length());
			}
		}
		return result;

	}

	/**
	 * Multiplies the current big number with another value
	 * @param val value to be multiplied to the big number
	 * @return reference to the result after the multiplication 
	 */
	public String mult(String val){
		if(val.charAt(0)=='-'&&negative){
			val=val.substring(1);
			return xmult(val);

		}
		else if(val.charAt(0)=='+'&&!negative){
			val=val.substring(1);
			return xmult(val);

		}
		else if(val.charAt(0)=='+'&&negative){
			val=val.substring(1);
				return "-"+xmult(val);

		}
		else if(val.charAt(0)=='-'&&!negative){
			val=val.substring(1);
			return "-"+xmult(val);	
		}

		else if(!negative){
			return xmult(val);
		}
		else if(negative){
			return "-"+xmult(val);
		}

		return"Something went Wrong";

	}
	
	/**
	 * Method that executes the mult method
	 * 
	 * 
	 */
	public String xmult(String val){
		BigNum xresult = new BigNum("0");
		if(value.length()>val.length()){
			while(value.length()!=val.length()){
				val = "0"+val;
			}
		}
		else if(value.length()<val.length()){
			while(value.length()!=val.length()){
				value = "0"+value;
			}
		}
		if(value.length()==val.length()){
			int iterations = -2;
			for(int i= val.length()-1; i>=0; i--){
				for(int j= value.length()-1; j>=0; j--){
					iterations++;
					String tmp = Integer.toString((Character.getNumericValue(val.charAt(i))*Character.getNumericValue(value.charAt(j))));
					for(int n = 0; n<iterations+i; n++){
						tmp=tmp+0;
					}
					xresult.setValue(xresult.add(tmp));
				}
			}
		}


		return xresult.getValue();

	}

	/**
	 * 
	 * @return reference to the factorial of the current number
	 */
	public String factorial(){
		if(negative){
			return "Sorry factorial is not available for negative numbers:";
		}
		BigNum result = new BigNum(value);
		BigNum tmp = new BigNum(value);
		while(!tmp.getValue().equals("1")){
			tmp.xsub("1");
			result.mult(tmp.getValue());
			
		}

		return result.getValue();
	}

	/**
	 * 
	 * @return reference to the factor of the current number
	 */
	public String factors(){

		if(negative){
			return "Sorry factors are not available for negative numbers:";
		}

		return null;
	}

	/**
	 * 
	 * @return true if the number is prime, false if otherwise 
	 */
	public String isPrime(){
		return null;
	}


	//Setters and getters 

	/**
	 * sets a new value to the current big number
	 * @param val reference to the new value of the big number
	 */
	public void setValue(String val){
		value=val;
	}

	/**
	 * 
	 * @return reference to the current value of the big number
	 */
	public String getValue(){
		return value;
	}

	public boolean isNegative(){
		return negative;
	}
}
