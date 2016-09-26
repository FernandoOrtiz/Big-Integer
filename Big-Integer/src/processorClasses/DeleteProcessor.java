package processorClasses;

import java.util.ArrayList;

import objects.BigNum;
import objects.var;
import systemGeneralClasses.Command;
import systemGeneralClasses.CommandActionHandler;
import systemGeneralClasses.FixedLengthCommand;
import theSystem.SystemCommandsProcessor;

public class DeleteProcessor implements CommandActionHandler{

	@Override
	public ArrayList<String> execute(Command c) {
		ArrayList<String> resultsList = new ArrayList<String>();
		FixedLengthCommand fc = (FixedLengthCommand) c;

		String name = fc.getOperand(1);

		for(var v: SystemCommandsProcessor.vars){
			if(v.getName().equals(name)){	
				String tmp = v.getName();
				SystemCommandsProcessor.vars.remove(v);
				resultsList.add(tmp);
				return resultsList;
			}

		}
		
		resultsList.add("Variable does not Excist:");
		return resultsList;
	}
	

}
