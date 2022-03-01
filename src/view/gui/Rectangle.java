package view.gui;

import java.awt.Graphics2D;

import ShapeStrategies.IShapeStrategies;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class Rectangle extends Shape {
	
	public Point startPoint;
	public Point endPoint;
	public int width;
	public int height;
	public ShapeType shapeType;
	public ShapeColor primary;
	public ShapeColor secondary;
	private IShapeStrategies shapeStrategy;
	private PaintCanvasBase paintCanvasBase;
	private ShapeShadingType shapeShadingType;
	private Graphics2D graphics2d;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point startPoint, Point endPoint, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.width = endPoint.getX()-startPoint.getX();
		this.height = endPoint.getY()-startPoint.getY();
		this.primary = appState.getActivePrimaryColor();
		this.secondary = appState.getActiveSecondaryColor();
		this.paintCanvasBase = paintCanvasBase;
		this.shapeShadingType = appState.getActiveShapeShadingType();
		this.shapeType= appState.getActiveShapeType();
		this.graphics2d = paintCanvasBase.getGraphics2D();
		
	}
	
	public Rectangle(Point startPoint, Point endPoint, PaintCanvasBase paintCanvasBase, IApplicationState appState, ShapeColor primary, ShapeColor secondary, ShapeShadingType shadeType, ShapeType shapeType) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.width = endPoint.getX()-startPoint.getX();
		this.height = endPoint.getY()-startPoint.getY();
		this.primary = primary;
		this.secondary = secondary;
		this.paintCanvasBase = paintCanvasBase;
		this.shapeShadingType = shadeType;
		this.shapeType= shapeType;
		this.graphics2d = paintCanvasBase.getGraphics2D();
		
	}
	
	public void draw(PaintCanvasBase paintCanvasBase) {
		
		
		
		if(shapeShadingType==ShapeShadingType.FILLED_IN) {
			graphics2d.setColor(EnumColorMap.colorMapper.get(this.primary));
			graphics2d.fillRect(this.startPoint.getX(), this.startPoint.getY(), this.width, this.height);
		}
		else if(shapeShadingType==ShapeShadingType.OUTLINE) {
			graphics2d.setColor(EnumColorMap.colorMapper.get(this.primary));
			if(startPoint.getX()<endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.drawRect(this.startPoint.getX(), this.startPoint.getY(), this.width, this.height);
			}
			else if( startPoint.getX()<endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.drawRect(this.startPoint.getX(), this.endPoint.getY(), this.width, -this.height);
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.drawRect(this.endPoint.getX(), this.endPoint.getY(), -this.width, -this.height);
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.drawRect(this.endPoint.getX(), this.startPoint.getY(), -this.width, this.height);
			}
			
		}
		else if(shapeShadingType==ShapeShadingType.OUTLINE_AND_FILLED_IN) {
			graphics2d.setColor(EnumColorMap.colorMapper.get(this.primary));
			graphics2d.fillRect(this.startPoint.getX(), this.startPoint.getY(), this.width, this.height);
			
			
			if(startPoint.getX()<endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawRect(this.startPoint.getX(), this.startPoint.getY(), this.width, this.height);
				
			}
			else if( startPoint.getX()<endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawRect(this.startPoint.getX(), this.endPoint.getY(), this.width, -this.height);
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawRect(this.endPoint.getX(), this.endPoint.getY(), -this.width, -this.height);
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawRect(this.endPoint.getX(), this.startPoint.getY(), -this.width, this.height);
			}
			
		}
		
	}
	
	public ShapeShadingType getShapeShadingType() {
		return shapeShadingType;
	}

	
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
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

	public IShapeStrategies getShapeStrategy() {
		return shapeStrategy;
	}

	public void setShapeStrategy(IShapeStrategies shapeStrategy) {
		this.shapeStrategy = shapeStrategy;
	}

	public PaintCanvasBase getPaintCanvasBase() {
		return paintCanvasBase;
	}

	public void setPaintCanvasBase(PaintCanvasBase paintCanvasBase) {
		this.paintCanvasBase = paintCanvasBase;
	}

	public void setShapeShadingType(ShapeShadingType shapeShadingType) {
		this.shapeShadingType = shapeShadingType;
	}

	@Override
	public String toString() {
		return "Rectangle [startPoint=" + startPoint + ", endPoint=" + endPoint + ", width=" + width + ", height="
				+ height + ", shapeType=" + shapeType + ", primary=" + primary + ", secondary=" + secondary
				+ ", shapeStrategy=" + shapeStrategy + ", paintCanvasBase=" + paintCanvasBase + ", shapeShadingType="
				+ shapeShadingType + "]";
	}

}
