package view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import view.interfaces.IObserver;
import view.interfaces.IShape;
import view.interfaces.ISubject;
import view.interfaces.PaintCanvasBase;

public class ShapeList implements ISubject {
	private List<IObserver> observers = new ArrayList<>();
	public static List<IShape> shapeList = new ArrayList<IShape>();
	
	
	public void add(IShape shape, PaintCanvasBase paintCanvasBase) {
		ShapeList.shapeList.add(shape);
		notifyObservers();
	}
	
	public void delete(Shape shape, PaintCanvasBase paintCanvasBase) {
		Graphics2D graphics2d = paintCanvasBase.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, paintCanvasBase.getWidth(), paintCanvasBase.getHeight());
		shapeList.remove(shape);
		notifyObservers();
	}

	@Override
	public void registerObserver(IObserver observer) {
		//System.out.println("registered an observer");
		if(!observers.contains(observer))
			observers.add(observer);
	}
	
	
	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}

	
	public void notifyObservers() {
		for(IObserver observer: observers) {
			observer.update();
		}
		
	}
	public void getAllPoints() {
		for(IShape s: shapeList) {
			((Shape)s).toString();
		}
		System.out.println(shapeList.size());
	}
	
}

