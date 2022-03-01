package Commands;

import java.io.IOException;

import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class UndoCommand implements ICommand {
	
	public void run(){
		
		CommandHistory.undo();
		
	}
	
	
	

}
