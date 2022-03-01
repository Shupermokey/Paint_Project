package Commands;

import java.util.ArrayList;
import java.util.List;

import view.gui.Composite;
import view.gui.DrawShapeHandler;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class PasteShapeCommand implements ICommand, IUndoable{
	private ShapeDraw shapeDrawer = ShapeDraw.getShapeDraw();
	ShapeList shapeList = new ShapeList();
	private List<Shape> pasteList = new ArrayList<>();
	//private Composite composite = new Composite();

	
	@Override
	public void run() {
		shapeList.registerObserver(shapeDrawer);
		for(int i = 0; i< CopyShapeCommand.clipBoard.size(); i++) {
			if(CopyShapeCommand.clipBoard.get(i).getClass()==Composite.class) {
				pasteList.add(CopyShapeCommand.clipBoard.get(i));
				ShapeList.shapeList.add(CopyShapeCommand.clipBoard.get(i));
				//shapeList.add(shape, DrawShapeHandler.paintCanvasBase);

			}
			else {
			pasteList.add(CopyShapeCommand.clipBoard.get(i));
			shapeList.add(CopyShapeCommand.clipBoard.get(i), DrawShapeHandler.paintCanvasBase);
			}
			
	}	
		shapeDrawer.update();
		shapeList.getAllPoints();
		CommandHistory.add(this);
		
	}

	@Override
	public void undo() {
		for(Shape shape: pasteList) {
			shapeList.delete(shape, DrawShapeHandler.paintCanvasBase);
		}	
	}

	@Override
	public void redo() {
		for(Shape shape: pasteList) {
			
			shapeList.add(shape, DrawShapeHandler.paintCanvasBase);
	}			
	}

}
