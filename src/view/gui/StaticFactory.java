package view.gui;

import java.util.ArrayList;
import java.util.List;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class StaticFactory {

	private static final StaticFactory factory = new StaticFactory();
	
	private StaticFactory() {
		
	}
	
	public IShape createShape(IApplicationState appState, Point start, Point end, PaintCanvasBase paintCanvasBase) {
		
		if(appState.getActiveShapeType()==ShapeType.ELLIPSE) {
			return new Ellipse(start, end,  paintCanvasBase, appState);
		}
		else if(appState.getActiveShapeType()==ShapeType.RECTANGLE) {
			return new Rectangle(start, end, paintCanvasBase, appState);
		}
		else if(appState.getActiveShapeType()==ShapeType.TRIANGLE) {
			return new Triangle(start, end, paintCanvasBase, appState);
		}
		return null;
	}
	
public IShape createShape(Shape shape) {
		
		if(shape.getShapeType()==ShapeType.ELLIPSE) {
			return new Ellipse(new Point(shape.getStartPoint().getX()+10, shape.getStartPoint().getY()-10), new Point(shape.getEndPoint().getX()+10, shape.getEndPoint().getY()-10),DrawShapeHandler.paintCanvasBase,  DrawShapeHandler.appState, shape.getPrimary(), shape.getSecondary(), shape.getShapeShadingType(), shape.getShapeType());
		
		}
		else if(shape.getShapeType()==ShapeType.RECTANGLE) {
			return new Rectangle(new Point(shape.getStartPoint().getX()+10, shape.getStartPoint().getY()-10), new Point(shape.getEndPoint().getX()+10, shape.getEndPoint().getY()-10),DrawShapeHandler.paintCanvasBase,  DrawShapeHandler.appState, shape.getPrimary(), shape.getSecondary(), shape.getShapeShadingType(), shape.getShapeType());
		}
		else if(shape.getShapeType()==ShapeType.TRIANGLE) {
			return new Triangle(new Point(shape.getStartPoint().getX()+10, shape.getStartPoint().getY()-10), new Point(shape.getEndPoint().getX()+10, shape.getEndPoint().getY()-10),DrawShapeHandler.paintCanvasBase,  DrawShapeHandler.appState, shape.getPrimary(), shape.getSecondary(), shape.getShapeShadingType(), shape.getShapeType());
		}
		return null;
	}
	
public List<Shape> createShape(Composite shape) {
	List<Shape> copyCompositeList = new ArrayList<>();
	for(int i = 0; i< shape.getChildren().size(); i++) {
		Shape currentShape = shape.getChildren().get(i);
		if(currentShape.getShapeType()==ShapeType.ELLIPSE) {
			copyCompositeList.add(new Ellipse(new Point(currentShape.getStartPoint().getX()+10, currentShape.getStartPoint().getY()-30), new Point(currentShape.getEndPoint().getX()+30, currentShape.getEndPoint().getY()-30),DrawShapeHandler.paintCanvasBase,  DrawShapeHandler.appState, currentShape.getPrimary(), currentShape.getSecondary(), currentShape.getShapeShadingType(), currentShape.getShapeType()));
		
		}
		else if(currentShape.getShapeType()==ShapeType.RECTANGLE) {
			copyCompositeList.add(new Rectangle(new Point(currentShape.getStartPoint().getX()+10, currentShape.getStartPoint().getY()-30), new Point(currentShape.getEndPoint().getX()+30, currentShape.getEndPoint().getY()-30),DrawShapeHandler.paintCanvasBase,  DrawShapeHandler.appState, currentShape.getPrimary(), currentShape.getSecondary(), currentShape.getShapeShadingType(), currentShape.getShapeType()));
		}
		else if(currentShape.getShapeType()==ShapeType.TRIANGLE) {
			copyCompositeList.add(new Triangle(new Point(currentShape.getStartPoint().getX()+10, currentShape.getStartPoint().getY()-30), new Point(currentShape.getEndPoint().getX()+30, currentShape.getEndPoint().getY()-30),DrawShapeHandler.paintCanvasBase,  DrawShapeHandler.appState, currentShape.getPrimary(), currentShape.getSecondary(), currentShape.getShapeShadingType(), currentShape.getShapeType()));
		}
	}
	
	return copyCompositeList;
}
	public static StaticFactory getStaticFactory() {
		return factory;
	}
	
}
