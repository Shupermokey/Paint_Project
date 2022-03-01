package Commands;


import view.interfaces.ICommand;

public class RedoCommand implements ICommand {
	
	public void run(){
		CommandHistory.redo();
		
	}

}
