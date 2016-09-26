package processorClasses;

import java.util.ArrayList;

import objects.BigNum;
import objects.var;
import systemGeneralClasses.Command;
import systemGeneralClasses.CommandActionHandler;
import systemGeneralClasses.FixedLengthCommand;
import theSystem.SystemCommandsProcessor;

public class VarProcessor implements CommandActionHandler{

	@Override
	public ArrayList<String> execute(Command c) {
		ArrayList<String> resultsList = new ArrayList<String>();
		FixedLengthCommand fc = (FixedLengthCommand) c;
		var nv = new var(fc.getOperand(1));
		if(!SystemCommandsProcessor.vars.contains(nv)){
			SystemCommandsProcessor.vars.add(nv);
		}
		resultsList.add(fc.getOperand(1));
		return resultsList;
	}

}
