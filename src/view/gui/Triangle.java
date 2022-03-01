package view.gui;

import java.awt.Graphics2D;

import ShapeStrategies.IShapeStrategies;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class Triangle extends Shape {
	
	private PaintCanvasBase paintCanvasBase;
	public Point startPoint;
	public Point endPoint;
	public int width;
	public int height;
	public ShapeType shapeType;
	public ShapeColor primary;
	public ShapeColor secondary;
	private IShapeStrategies shapeStrategy;
	private ShapeShadingType shapeShadingType;
	
public ShapeShadingType getShapeShadingType() {
		return shapeShadingType;
	}

public Triangle() {
		
	}
	
	public Triangle(Point startPoint, Point endPoint, PaintCanvasBase paintCanvasBase, IApplicationState appState) {
		
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.width = endPoint.getX()-startPoint.getX();
		this.height = endPoint.getY()-startPoint.getY();
		this.primary = appState.getActivePrimaryColor();
		this.secondary = appState.getActiveSecondaryColor();
		this.paintCanvasBase = paintCanvasBase;
		this.shapeShadingType = appState.getActiveShapeShadingType();
		this.shapeType= appState.getActiveShapeType();
		
	}
	
	public Triangle(Point startPoint, Point endPoint, PaintCanvasBase paintCanvasBase, IApplicationState appState, ShapeColor primary, ShapeColor secondary, ShapeShadingType shadeType, ShapeType shapeType) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.width = endPoint.getX()-startPoint.getX();
		this.height = endPoint.getY()-startPoint.getY();
		this.primary = primary;
		this.secondary = secondary;
		this.paintCanvasBase = paintCanvasBase;
		this.shapeShadingType = shadeType;
		this.shapeType= shapeType;
		
		
	}
	
	public void draw(PaintCanvasBase paintCanvasBase) {
		Graphics2D graphics2d = paintCanvasBase.getGraphics2D();
		
		if(shapeShadingType==ShapeShadingType.FILLED_IN) {
			graphics2d.setColor(EnumColorMap.colorMapper.get(this.primary));
			//graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
			if(startPoint.getX()<endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()<endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
							}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
							}
		}
		else if(shapeShadingType==ShapeShadingType.OUTLINE) {
			graphics2d.setColor(EnumColorMap.colorMapper.get(this.primary));
			//graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
			if(startPoint.getX()<endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()<endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
							}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
							}
		}
		else if(shapeShadingType==ShapeShadingType.OUTLINE_AND_FILLED_IN) {
			graphics2d.setColor(EnumColorMap.colorMapper.get(this.primary));
		if(startPoint.getX()<endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
				
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()<endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
				
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
				
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.startPoint.getY(),this.endPoint.getY(),this.startPoint.getY()}, 3);
							}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.fillPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
				
				graphics2d.setColor(EnumColorMap.colorMapper.get(this.secondary));
				graphics2d.drawPolygon(new int[] {this.startPoint.getX(),(this.startPoint.getX()+this.endPoint.getX())/2,this.endPoint.getX()}, new int[] {this.endPoint.getY(),this.startPoint.getY(),this.endPoint.getY()}, 3);
							}
		}
	}

	public PaintCanvasBase getPaintCanvasBase() {
		return paintCanvasBase;
	}

	public void setPaintCanvasBase(PaintCanvasBase paintCanvasBase) {
		this.paintCanvasBase = paintCanvasBase;
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

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

	public void setShapeShadingType(ShapeShadingType shapeShadingType) {
		this.shapeShadingType = shapeShadingType;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}
	
	

}
