package Commands;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.Composite;
import view.gui.DrawShapeHandler;
import view.gui.Point;
import view.gui.Shape;
import view.gui.ShapeDraw;
import view.gui.ShapeList;
import view.gui.StaticFactory;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class CopyShapeCommand implements ICommand {

	ShapeDraw shapedrawer = ShapeDraw.getShapeDraw();
	public static List<Shape> clipBoard = new ArrayList<>();
	ShapeList list = new ShapeList();
		
	

	@Override
	public void run() {
		clipBoard.clear();
		list.registerObserver(shapedrawer);
		for(Shape shape: SelectShapeCommand.selectedShapesList) {
			if(shape.getClass()== Composite.class) {
				Composite s =  (Composite)shape;
				Composite sCopy = new Composite();
					List<Shape> copyComposite = StaticFactory.getStaticFactory().createShape(s);
					
					for(int j = 0; j<copyComposite.size(); j++) {
						Shape currentCopyComposite = copyComposite.get(j);
						System.out.println(currentCopyComposite.toString());
						/*
						 * currentCopyComposite.setHeight(shape.getHeight());
						 * currentCopyComposite.setWidth(shape.getWidth());
						 * currentCopyComposite.setPrimaryColor(shape.getPrimary());
						 * currentCopyComposite.setSecondaryColor(shape.getSecondary());
						 * currentCopyComposite.setShapeType(shape.getShapeType());
						 * currentCopyComposite.setShapeShadingType(shape.getShapeShadingType());
						 */
						
						sCopy.addChild(currentCopyComposite);
						if(!clipBoard.contains(sCopy))
							clipBoard.add(sCopy);
						
						
										
				}
					sCopy.findStartAndEndPoints();
					
			}
			else {
			Shape copyShape = (Shape)StaticFactory.getStaticFactory().createShape(shape);
			copyShape.setHeight(shape.getHeight());
			copyShape.setWidth(shape.getWidth());
			copyShape.setPrimaryColor(shape.getPrimary());
			copyShape.setSecondaryColor(shape.getSecondary());
			copyShape.setShapeType(shape.getShapeType());
			copyShape.setShapeShadingType(shape.getShapeShadingType()); 
			if(!clipBoard.contains(copyShape));
				clipBoard.add(copyShape);
			}
			
			
		}
		
	}
	
	
}
