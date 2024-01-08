package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Commands.CreateShapeCommand;
import Commands.MoveShapeCommand;
import Commands.SelectShapeCommand;
import model.MouseMode;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;

public class MouseClickHandler extends MouseAdapter {

	
	 private PaintCanvasBase paintCanvasBase;
	 private ApplicationState appState;
	 private Point startPoint = new Point();
	 private Point endPoint = new Point();
	 private ShapeType shapeType;
	 
	 
	 
	 public MouseClickHandler(PaintCanvasBase paintCanvasBase, ApplicationState appState) {
	 this.paintCanvasBase = paintCanvasBase;
	 this.appState = appState;
	 
	 }
	 

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println(e.getX() + " " + e.getY());

	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		startPoint.setX(e.getX());
		startPoint.setY(e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint.setX(e.getX());
		endPoint.setY(e.getY());
		ICommand command = null;
		DrawShapeHandler.setPaintCanvasBase(paintCanvasBase);
		MouseMode mouseMode = appState.getActiveMouseMode();
		shapeType = appState.getActiveShapeType();
		
		
		
		if(mouseMode == MouseMode.DRAW) {
			 command = new CreateShapeCommand(new Point(startPoint.getX(), startPoint.getY()), new Point(endPoint.getX(), endPoint.getY()), getEndPoint().getX()-getStartPoint().getX(), getEndPoint().getY()-getStartPoint().getY(), paintCanvasBase, appState);
			
		}
		else if(mouseMode == MouseMode.MOVE) {
			 command = new MoveShapeCommand(new Point(startPoint.getX(), startPoint.getY()), new Point(endPoint.getX(), endPoint.getY()),paintCanvasBase);
		}
		else if(mouseMode == MouseMode.SELECT) {
			 command = new SelectShapeCommand(new Point(startPoint.getX(), startPoint.getY()),  new Point(endPoint.getX(), endPoint.getY()), paintCanvasBase, appState );
		}
		
		if(command != null)
			command.run();
		
		
	}


	public Point getStartPoint() {
		return startPoint;
	}


	public Point getEndPoint() {
		return endPoint;
	}
	

	

	
	
	
}
