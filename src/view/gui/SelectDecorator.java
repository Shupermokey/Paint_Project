package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.ShapeType;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class SelectDecorator extends Shape {
	
	private Graphics2D graphics2d;
	
	private Shape shapeToDecorate;
	public SelectDecorator(IShape shape) {
		this.shapeToDecorate = (Shape)shape;
	}
	
	@Override
	public void draw(PaintCanvasBase paintCanvasBase) {
		shapeToDecorate.draw(paintCanvasBase);
		
		graphics2d = DrawShapeHandler.paintCanvasBase.getGraphics2D();
		
		Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] {15}, 0);
		graphics2d.setStroke(stroke);
		graphics2d.setColor(Color.BLACK);
		
		Point startPoint = shapeToDecorate.getStartPoint();
		Point endPoint = shapeToDecorate.getEndPoint();
		
		if(shapeToDecorate.getShapeType() == ShapeType.ELLIPSE) {
			if(startPoint.getX() < endPoint.getX() && startPoint.getY()< endPoint.getY()) {
				graphics2d.drawOval(startPoint.getX()-2, startPoint.getY()-2, endPoint.getX()-startPoint.getX()+5 , endPoint.getY() - startPoint.getY() +5 );
			}
			else if(startPoint.getX() > endPoint.getX() && startPoint.getY()> endPoint.getY()) {
				
				graphics2d.drawOval(endPoint.getX()-2,endPoint.getY()-2, startPoint.getX()-endPoint.getX()+5 , startPoint.getY() - endPoint.getY() +5 );
			}
			else if(startPoint.getX() > endPoint.getX() && startPoint.getY()< endPoint.getY()) {
				
				graphics2d.drawOval(endPoint.getX()- 2,startPoint.getY()-2,startPoint.getX()-endPoint.getX()+5 , endPoint.getY() - startPoint.getY() +5 );
			}
			else if(startPoint.getX() < endPoint.getX() && startPoint.getY()> endPoint.getY()) {
				
				graphics2d.drawOval(startPoint.getX()-2, endPoint.getY()-2,endPoint.getX()-startPoint.getX()+5 , startPoint.getY() - endPoint.getY() +5 );
			}
		}
		
		else if(shapeToDecorate.getShapeType() == ShapeType.TRIANGLE) {
			if(startPoint.getX()<endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {startPoint.getX(),(startPoint.getX()+endPoint.getX())/2,endPoint.getX()}, new int[] {endPoint.getY(),startPoint.getY(),endPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()<endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {startPoint.getX(),(startPoint.getX()+endPoint.getX())/2,endPoint.getX()}, new int[] {startPoint.getY(),endPoint.getY(),startPoint.getY()}, 3);
				
			}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()>endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {startPoint.getX(),(startPoint.getX()+endPoint.getX())/2,endPoint.getX()}, new int[] {startPoint.getY(),endPoint.getY(),startPoint.getY()}, 3);
							}
			else if( startPoint.getX()>endPoint.getX() && startPoint.getY()<endPoint.getY()) {
				graphics2d.drawPolygon(new int[] {startPoint.getX(),(startPoint.getX()+endPoint.getX())/2,endPoint.getX()}, new int[] {endPoint.getY(),startPoint.getY(),endPoint.getY()}, 3);
							}
		}
		
		else if(shapeToDecorate.getShapeType() == ShapeType.RECTANGLE) {
			 if (startPoint.getX() < endPoint.getX() && startPoint.getY() < endPoint.getY()) { 
	                graphics2d.drawRect(startPoint.getX() -2, startPoint.getY() -2, endPoint.getX() - startPoint.getX() +2, endPoint.getY() - startPoint.getY() +2);
	            } else if (startPoint.getX() > endPoint.getX() && startPoint.getY() > endPoint.getY()) { 
	                graphics2d.drawRect(endPoint.getX() -2, endPoint.getY()-2, startPoint.getX() - endPoint.getX()+2, startPoint.getY() - endPoint.getY() +2);
	            } else if (startPoint.getX() > endPoint.getX() && startPoint.getY() < endPoint.getY()) { 
	                graphics2d.drawRect(endPoint.getX() -2, startPoint.getY() -2, startPoint.getX() - endPoint.getX() +2, endPoint.getY() - startPoint.getY()+2);
	            } else if (startPoint.getX() < endPoint.getX() && startPoint.getY() > endPoint.getY()) { 
	                graphics2d.drawRect(startPoint.getX() -2, endPoint.getY()-2, endPoint.getX() - startPoint.getX()+2, startPoint.getY()- endPoint.getY()+2);
	            }

		}
		
		else if(shapeToDecorate.getClass() == Composite.class) {
			 if (startPoint.getX() < endPoint.getX() && startPoint.getY() < endPoint.getY()) { 
	                graphics2d.drawRect(startPoint.getX() -2, startPoint.getY() -2, endPoint.getX() - startPoint.getX() +2, endPoint.getY() - startPoint.getY() +2);
	            } 
		}
		
		
		
	}
}
