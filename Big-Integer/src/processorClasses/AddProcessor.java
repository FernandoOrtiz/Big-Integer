package processorClasses;

import java.util.ArrayList;

import objects.BigNum;
import objects.var;
import systemGeneralClasses.Command;
import systemGeneralClasses.CommandActionHandler;
import systemGeneralClasses.FixedLengthCommand;
import theSystem.SystemCommandsProcessor;

public class AddProcessor implements CommandActionHandler {

	@Override
	public ArrayList<String> execute(Command c) {
		ArrayList<String> resultsList = new ArrayList<String>();
		FixedLengthCommand fc = (FixedLengthCommand) c;
		String name = fc.getOperand(1);
		
		for(var v: SystemCommandsProcessor.vars){
			if(v.getName().equals(name)){
				BigNum num = new BigNum(fc.getOperand(2));
				v.setValue(num.add(fc.getOperand(3)));
				resultsList.add(num.add(fc.getOperand(3)));
				return resultsList;
			}
			
		}
		resultsList.add("Variable does not Excist:");
		return resultsList;
		
	}

}
