package view.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import ShapeStrategies.ElipseStrategy;
import ShapeStrategies.IShapeStrategies;
import ShapeStrategies.RectangleStrategy;
import ShapeStrategies.TriangleStrategy;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Shape implements IShape {

	public Point startPoint;
	public Point endPoint;
	public int width;
	public int height;
	public ShapeType shapeType;
	public ShapeColor primary;
	public ShapeColor secondary;
	private IShapeStrategies shapeStrategy;
	private ShapeShadingType shapeShadingType;

	
	
	public Shape() {
		 
	}
	
	public Shape(Point startPoint, Point endPoint, int width, int height, IApplicationState appState) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.width = endPoint.getX()-startPoint.getX();
		this.height = endPoint.getY()-startPoint.getY();
		this.primary = appState.getActivePrimaryColor();
		this.secondary = appState.getActiveSecondaryColor();
		this.shapeShadingType = appState.getActiveShapeShadingType();
		this.shapeType= appState.getActiveShapeType();
	}
	public void draw(PaintCanvasBase paintCanvasBase) {
					
		 
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}


	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setPrimaryColor(ShapeColor activePrimaryColor) {
		this.primary = activePrimaryColor;
		
	}

	public void setSecondaryColor(ShapeColor activeSecondaryColor) {
		this.secondary = activeSecondaryColor;
		
	}

	public void setShapeType(ShapeType activeShapeType) {
		this.shapeType = activeShapeType;
		
	}


	public void setShapeStrategy(IShapeStrategies shapeStrategy) {
		this.shapeStrategy = shapeStrategy;
	}

	public ShapeColor getPrimary() {
		return primary;
	}

	public void setPrimary(ShapeColor primary) {
		this.primary = primary;
	}

	public ShapeColor getSecondary() {
		return secondary;
	}

	public void setSecondary(ShapeColor secondary) {
		this.secondary = secondary;
	}

	public ShapeShadingType getShapeShadingType() {
		return shapeShadingType;
	}

	public void setShapeShadingType(ShapeShadingType shapeShadingType) {
		this.shapeShadingType = shapeShadingType;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}

	public IShapeStrategies getShapeStrategy() {
		return shapeStrategy;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
