package view.interfaces;

import view.gui.Shape;

public interface ISubject {
	
	void registerObserver(IObserver observer);
	
	void notifyObservers();

	void removeObserver(IObserver observer);
	

}
