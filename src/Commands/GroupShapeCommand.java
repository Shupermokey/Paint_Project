package Commands;

import java.util.ArrayList;
import java.util.List;

import view.gui.Composite;
import view.gui.DrawShapeHandler;
import view.gui.Point;
import view.gui.Rectangle;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class GroupShapeCommand implements ICommand, IUndoable {

	Composite composite = new Composite();
	List<Shape> groupShapeList = new ArrayList<>();
	ShapeList shapeList = new ShapeList();
	int minStart = Integer.MAX_VALUE;
	int minEnd= Integer.MAX_VALUE;;
	int maxStart = Integer.MIN_VALUE;
	int maxEnd = Integer.MIN_VALUE;
	//List<Shape> selectedShapes = new ArrayList<>();
	
	@Override
	public void run() {
		shapeList.registerObserver(ShapeDraw.getShapeDraw());
		for(Shape shape: SelectShapeCommand.selectedShapesList) {
			groupShapeList.add(shape);			
		}
		for(Shape shape: groupShapeList) {
			composite.addChild(shape);
			shapeList.delete(shape, DrawShapeHandler.paintCanvasBase);
		}
		findStartAndEndPoints();
		SelectShapeCommand.selectedShapesList.clear();
		SelectShapeCommand.selectedShapesList.add(composite);
		shapeList.add(composite, DrawShapeHandler.paintCanvasBase);

		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		SelectShapeCommand.selectedShapesList.clear();
		for(IShape shape: groupShapeList) {
			shapeList.add(shape, DrawShapeHandler.paintCanvasBase);
			SelectShapeCommand.selectedShapesList.add((Shape)shape);
		}
		
		
		shapeList.delete(composite, DrawShapeHandler.paintCanvasBase);
		
		
		
	}

	@Override
	public void redo() {
		
		for(Shape shape: SelectShapeCommand.selectedShapesList) {
			groupShapeList.add(shape);			
		}
		for(Shape shape: groupShapeList) {
			composite.addChild(shape);
			shapeList.delete(shape, DrawShapeHandler.paintCanvasBase);
		}
		findStartAndEndPoints();
		SelectShapeCommand.selectedShapesList.clear();
		SelectShapeCommand.selectedShapesList.add(composite);
		shapeList.add(composite, DrawShapeHandler.paintCanvasBase);
		
	}

	
	public void findStartAndEndPoints() {
		
		for(int i = 0; i<groupShapeList.size(); i++) {
			//System.out.println(((Rectangle)groupShapeList.get(i)).getStartPoint().toString());
			//System.out.println(((Rectangle)groupShapeList.get(i)).getEndPoint().toString());
			if( ((Shape)groupShapeList.get(i)).getStartPoint().getX()<minStart) {
				minStart = ((Shape)groupShapeList.get(i)).getStartPoint().getX();
			}
			 if( ((Shape)groupShapeList.get(i)).getEndPoint().getX()<minStart) {
				minStart = ((Shape)groupShapeList.get(i)).getEndPoint().getX();
			}
			
			
			
			if( ((Shape)groupShapeList.get(i)).getStartPoint().getX()>maxStart) {
				maxStart = ((Shape)groupShapeList.get(i)).getStartPoint().getX();
			}
			 if( ((Shape)groupShapeList.get(i)).getEndPoint().getX()>maxStart) {
				maxStart = ((Shape)groupShapeList.get(i)).getEndPoint().getX();
			}

			
			
			if( ((Shape)groupShapeList.get(i)).getStartPoint().getY()<minEnd) {
				minEnd = ((Shape)groupShapeList.get(i)).getStartPoint().getY();
			}
			 if( ((Shape)groupShapeList.get(i)).getEndPoint().getY()<minEnd) {
				minEnd = ((Shape)groupShapeList.get(i)).getEndPoint().getY();
			}
			
			
			
			if( ((Shape)groupShapeList.get(i)).getStartPoint().getY()>maxEnd) {
				maxEnd = ((Shape)groupShapeList.get(i)).getStartPoint().getY();
			}
			if( ((Shape)groupShapeList.get(i)).getEndPoint().getY()>maxEnd) {
				maxEnd = ((Shape)groupShapeList.get(i)).getEndPoint().getY();
			}
			
			composite.setStartPoint(new Point(minStart,minEnd));
			composite.setEndPoint(new Point(maxStart,maxEnd));

		}
		
	}

	
}
