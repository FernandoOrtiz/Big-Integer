package processorClasses;

import java.util.ArrayList;

import objects.BigNum;
import systemGeneralClasses.Command;
import systemGeneralClasses.CommandActionHandler;
import systemGeneralClasses.FixedLengthCommand;

public class FactorsProcessor implements CommandActionHandler {

	@Override
	public ArrayList<String> execute(Command c) {
		ArrayList<String> resultsList = new ArrayList<String>();
		FixedLengthCommand fc = (FixedLengthCommand) c;
		BigNum num = new BigNum(fc.getOperand(1));
		resultsList.add(num.factors());
		return resultsList;
	}

}
