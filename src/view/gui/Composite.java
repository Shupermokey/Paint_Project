package view.gui;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import model.persistence.ApplicationState;
import view.interfaces.IComponent;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Composite extends Rectangle implements IShape {
//aggregation
	private List<Shape> children;
	private Point startPoint = new Point();
	private Point endPoint= new Point();
	private int width;
	private int height;
	private Graphics2D graphics2d = DrawShapeHandler.paintCanvasBase.getGraphics2D();
	private ApplicationState appState = DrawShapeHandler.appState;
	int minStart = Integer.MAX_VALUE;
	int minEnd= Integer.MAX_VALUE;;
	int maxStart = Integer.MIN_VALUE;
	int maxEnd = Integer.MIN_VALUE;
	
	public Composite() {
		children = new ArrayList<>();
		this.width = endPoint.getX()-startPoint.getX();
		this.height = endPoint.getY()-startPoint.getY();
		
	}
	
	@Override
	public void draw(PaintCanvasBase paintCanvasBase) {
		for(Shape child: children) {
			child.draw(DrawShapeHandler.paintCanvasBase);
		}
	}
	
	public void addChild(Shape component) {
		children.add(component);
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

	
	  @Override public String toString() { return "Composite [children=" + children
	  + ", startPoint=" + startPoint + ", endPoint=" + endPoint + ", width=" +
	  width + ", height=" + height + ", graphics2d=" + graphics2d + ", appState=" +
	  appState + "]"; }
	 

	public List<Shape> getChildren() {
		return children;
	}


public void findStartAndEndPoints() {
		
		for(int i = 0; i<children.size(); i++) {
			//System.out.println(((Rectangle)groupShapeList.get(i)).getStartPoint().toString());
			//System.out.println(((Rectangle)groupShapeList.get(i)).getEndPoint().toString());
			if( ((Shape)children.get(i)).getStartPoint().getX()<minStart) {
				minStart = ((Shape)children.get(i)).getStartPoint().getX();
			}
			 if( ((Shape)children.get(i)).getEndPoint().getX()<minStart) {
				minStart = ((Shape)children.get(i)).getEndPoint().getX();
			}
			
			
			
			if( ((Shape)children.get(i)).getStartPoint().getX()>maxStart) {
				maxStart = ((Shape)children.get(i)).getStartPoint().getX();
			}
			 if( ((Shape)children.get(i)).getEndPoint().getX()>maxStart) {
				maxStart = ((Shape)children.get(i)).getEndPoint().getX();
			}

			
			
			if( ((Shape)children.get(i)).getStartPoint().getY()<minEnd) {
				minEnd = ((Shape)children.get(i)).getStartPoint().getY();
			}
			 if( ((Shape)children.get(i)).getEndPoint().getY()<minEnd) {
				minEnd = ((Shape)children.get(i)).getEndPoint().getY();
			}
			
			
			
			if( ((Shape)children.get(i)).getStartPoint().getY()>maxEnd) {
				maxEnd = ((Shape)children.get(i)).getStartPoint().getY();
			}
			if( ((Shape)children.get(i)).getEndPoint().getY()>maxEnd) {
				maxEnd = ((Shape)children.get(i)).getEndPoint().getY();
			}
			
			this.setStartPoint(new Point(minStart,minEnd));
			this.setEndPoint(new Point(maxStart,maxEnd));

		}
		
	}

}


//group -> for each selected shape
	// remove from main shape list
	// add to new shape group
	// inseart group shape to main shape list
	// clear out selected shape list, add a group to the selected shape list

// for each selected shape, returns list of IShape