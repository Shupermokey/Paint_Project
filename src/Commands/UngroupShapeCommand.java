package Commands;

import java.util.ArrayList;
import java.util.List;

import view.gui.Composite;
import view.gui.DrawShapeHandler;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

public class UngroupShapeCommand implements ICommand, IUndoable {

	Composite composite = new Composite();
	List<Shape> groupedShapes = new ArrayList<>();
	ShapeList shapeList = new ShapeList();
	int minStart = Integer.MAX_VALUE;
	int minEnd= Integer.MAX_VALUE;;
	int maxStart = Integer.MIN_VALUE;
	int maxEnd = Integer.MIN_VALUE;
	List<Shape> selectedShapes = new ArrayList<>();
	
	
	@Override
	public void run() {
		shapeList.registerObserver(ShapeDraw.getShapeDraw());
		for(Shape shape: SelectShapeCommand.selectedShapesList) {
			groupedShapes.add(shape);			
		}
		if(groupedShapes.size()==1 && groupedShapes.get(0).getClass()==Composite.class) {
			Composite s = (Composite)groupedShapes.get(0);
		
		for(Shape child: s.getChildren()) {
			shapeList.add(child, DrawShapeHandler.paintCanvasBase);
		}
		
		shapeList.delete(groupedShapes.get(0), DrawShapeHandler.paintCanvasBase);
	}
		else {
			System.out.println("Must select a grouped shape");
		}
		CommandHistory.add(this);
		}

	@Override
	public void undo() {
		if(groupedShapes.size()==1 && groupedShapes.get(0).getClass()==Composite.class) {
		shapeList.add(groupedShapes.get(0), DrawShapeHandler.paintCanvasBase);
		Composite s = (Composite) groupedShapes.get(0);
		for(int i = 0; i<s.getChildren().size(); i++) {
			shapeList.delete(s.getChildren().get(i), DrawShapeHandler.paintCanvasBase);
		}
		
		//ShapeDraw.getShapeDraw().update();
		}
		else {
			System.out.println("Must be grouped");
		}
		
	}

	@Override
	public void redo() {
		
		
		if(groupedShapes.size()==1 && groupedShapes.get(0).getClass()==Composite.class) {
			Composite s = (Composite)groupedShapes.get(0);
		
		for(Shape child: s.getChildren()) {
			shapeList.add(child, DrawShapeHandler.paintCanvasBase);
		}
		
		shapeList.delete(groupedShapes.get(0), DrawShapeHandler.paintCanvasBase);
		CommandHistory.add(this);
	}
		else {
			System.out.println("Must select a grouped shape");
		}
	
	}

}
