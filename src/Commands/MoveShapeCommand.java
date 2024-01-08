package Commands;


import java.util.ArrayList;
import java.util.List;

import model.interfaces.IApplicationState;
import view.gui.Collision;
import view.gui.Composite;
import view.gui.Point;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class MoveShapeCommand implements ICommand, IUndoable
{
	List<Shape> selectedShapesList = new ArrayList<>();
	List<Shape> moveBackSelectedList = new ArrayList<>();
	private PaintCanvasBase paintCanvasBase;
	private Point movePointEnd;
	private Point movePointStart;
	private int deltaX;
	private int deltaY;
	private ShapeDraw shapeDrawer = ShapeDraw.getShapeDraw();
	int selectedStartNum = 0;
	
	public MoveShapeCommand(Point movePointStart,Point movePointEnd, PaintCanvasBase paintCanvasBase) {
		this.movePointEnd = movePointEnd;
		this.movePointStart = movePointStart;
		this.paintCanvasBase = paintCanvasBase;
		deltaX = movePointEnd.getX()-movePointStart.getX();
		deltaY = movePointEnd.getY()-movePointStart.getY();
		for(Shape shape:SelectShapeCommand.selectedShapesList) {
			selectedShapesList.add(shape);
		}
		selectedStartNum = selectedShapesList.size();

		
	}
	
	@Override
	public void run() {
		while(calculateMove(selectedShapesList));
		CommandHistory.add(this);
		}
		
	

	@Override
	public void undo() {
		while(calculateMoveBack(moveBackSelectedList));
		
	}

	@Override
	public void redo() {
		while(calculateMove(selectedShapesList));
		
	}
	
	private boolean calculateMove(List<Shape> selectedShapesList) {
		
		
		
		for(int i = 0; i<selectedShapesList.size(); i++) {
			Shape currentShape = selectedShapesList.get(i);
			
			int newStartPointX = currentShape.getStartPoint().getX()+deltaX;
			int newStartPointY = currentShape.getStartPoint().getY()+deltaY;
			
			int newEndPointX = currentShape.getEndPoint().getX()+deltaX;
			int newEndPointY = currentShape.getEndPoint().getY()+deltaY;
			
			currentShape.setStartPoint(new Point(newStartPointX,newStartPointY));
			currentShape.setEndPoint(new Point(newEndPointX,newEndPointY));
			
			if(selectedShapesList.get(i).getClass()==Composite.class) {
				List<Shape> children = ((Composite)selectedShapesList.get(i)).getChildren();
				//System.out.println(children.size());
				for(int j = 0; j<children.size(); j++) {
					Shape child = children.get(j);
					
					int newStartPointXChild = child.getStartPoint().getX()+deltaX;
					int newStartPointYChild = child.getStartPoint().getY()+deltaY;
					
					int newEndPointXChild = child.getEndPoint().getX()+deltaX;
					int newEndPointYChild = child.getEndPoint().getY()+deltaY;
						
					child.setStartPoint(new Point(newStartPointXChild,newStartPointYChild));
					child.setEndPoint(new Point(newEndPointXChild,newEndPointYChild));
				}
				
			}
			if(!this.selectedShapesList.isEmpty()) {
				this.selectedShapesList.remove(currentShape);
				this.moveBackSelectedList.add(currentShape);
				return true;
			}
			
		}
		
		shapeDrawer.update();
		return false;
		
}
		
	

  private boolean calculateMoveBack(List<Shape> moveBackSelectedList) {
  
		for(int i = 0; i<moveBackSelectedList.size(); i++) {
			Shape currentShape = moveBackSelectedList.get(i);
			
			int newStartPointX = currentShape.getStartPoint().getX()-deltaX;
			int newStartPointY = currentShape.getStartPoint().getY()-deltaY;
			int newEndPointX = currentShape.getEndPoint().getX()-deltaX;
			int newEndPointY = currentShape.getEndPoint().getY()-deltaY;
			
			
			currentShape.setStartPoint(new Point(newStartPointX,newStartPointY));
			currentShape.setEndPoint(new Point(newEndPointX,newEndPointY));
			
			

			if(moveBackSelectedList.get(i).getClass()==Composite.class) {
				List<Shape> children = ((Composite)moveBackSelectedList.get(i)).getChildren();
				//System.out.println(children.size());
				for(int j = 0; j<children.size(); j++) {
					Shape child = children.get(j);
					
					int newStartPointXChild = child.getStartPoint().getX()-deltaX;
					int newStartPointYChild = child.getStartPoint().getY()-deltaY;
					
					int newEndPointXChild = child.getEndPoint().getX()-deltaX;
					int newEndPointYChild = child.getEndPoint().getY()-deltaY;
						
					child.setStartPoint(new Point(newStartPointXChild,newStartPointYChild));
					child.setEndPoint(new Point(newEndPointXChild,newEndPointYChild));
				}
			}
			
			if(!this.moveBackSelectedList.isEmpty()) {
				this.selectedShapesList.add(currentShape);
				this.moveBackSelectedList.remove(currentShape);
				return true;
			}
			
		}
		
		shapeDrawer.update();
		return false;
	
  }
 
	

}
