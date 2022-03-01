package Commands;

import java.util.ArrayList;
import java.util.List;

import view.gui.DrawShapeHandler;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class DeleteShapeCommand implements ICommand, IUndoable {
	private ShapeDraw shapeDrawer = ShapeDraw.getShapeDraw();
	List<Shape> deleteSelectedList = new ArrayList<>();
	
	
	@Override
	public void run() {
		for(int i=0; i< SelectShapeCommand.selectedShapesList.size(); i++) {
			Shape shape = SelectShapeCommand.selectedShapesList.get(i);
			deleteSelectedList.add(shape);
			ShapeList.shapeList.remove(shape);
		}
		SelectShapeCommand.selectedShapesList.clear();
		shapeDrawer.update();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		for(Shape shape: deleteSelectedList) {
			SelectShapeCommand.selectedShapesList.add(shape);
			ShapeList.shapeList.add(shape);
		}
		for(int i=0; i< deleteSelectedList.size(); i++) {
			Shape shape = deleteSelectedList.get(i);
			deleteSelectedList.remove(shape);
		}
		
		shapeDrawer.update();
	}

	@Override
	public void redo() {
		for(int i=0; i< SelectShapeCommand.selectedShapesList.size(); i++) {
			Shape shape = SelectShapeCommand.selectedShapesList.get(i);
			deleteSelectedList.add(shape);
			ShapeList.shapeList.remove(shape);
		}
		SelectShapeCommand.selectedShapesList.clear();
		shapeDrawer.update();
	}

}
