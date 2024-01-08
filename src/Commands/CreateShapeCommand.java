package Commands;

import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.Point;
import view.gui.Rectangle;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.gui.StaticFactory;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class CreateShapeCommand implements IUndoable, ICommand{

	private ShapeList masterShapeList = new ShapeList();
	private PaintCanvasBase paintCanvasBase;
	private ApplicationState appState;
	private Point start;
	private Point end;
	private Shape shape;
	private ShapeDraw shapeDrawer = ShapeDraw.getShapeDraw();
	
	public CreateShapeCommand(Point start, Point end, int width, int height,PaintCanvasBase paintCanvasBase, ApplicationState appState) {
		this.start = start;
		this.end = end;
		this.paintCanvasBase= paintCanvasBase;
		this.appState = appState;	
		masterShapeList.registerObserver(shapeDrawer);
		shape = (Shape) StaticFactory.getStaticFactory().createShape(appState,start , end, paintCanvasBase);
	
	}
	
	
	@Override
	public void run() {
		masterShapeList.add(shape, paintCanvasBase);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		
		masterShapeList.delete(shape, paintCanvasBase);
	}

	@Override
	public void redo() {
		masterShapeList.add(shape, paintCanvasBase);
		
	}

}
