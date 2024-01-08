package Commands;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IApplicationState;
import view.gui.Collision;
import view.gui.Composite;
import view.gui.DrawShapeHandler;
import view.gui.Point;
import view.gui.Rectangle;
import view.gui.SelectDecorator;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.gui.StaticFactory;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class SelectShapeCommand implements ICommand {
	
	public static List<Shape> selectedShapesList = new ArrayList<>();
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase paintCanvasBase;
	private IApplicationState appState;
	
	
	public SelectShapeCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
		this.startPoint= startPoint;
		this.endPoint = endPoint;
		this.paintCanvasBase = paintCanvasBase;
		this.appState = appState;
		
	}
	

	@Override
	public void run() {
		selectedShapesList.clear();
		//iterate over all shapes in ShapeList and all any shapes that collide with the selection into the selectedShapesList
		for(int i = 0; i<ShapeList.shapeList.size(); i++) {
			//create a class that calculates collision
				Collision.calculateCollision((Shape)ShapeList.shapeList.get(i),(Shape) StaticFactory.getStaticFactory().createShape(appState, new Point(startPoint.getX(), startPoint.getY()), endPoint, paintCanvasBase), paintCanvasBase );
			
		}
		for(Shape currentShape : selectedShapesList) {
			SelectDecorator selectedShapeDecorator = new SelectDecorator(currentShape);
			selectedShapeDecorator.draw(DrawShapeHandler.paintCanvasBase);
		}
		ShapeDraw.getShapeDraw().update();
	}

}
