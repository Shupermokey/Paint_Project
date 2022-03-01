package view.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import Commands.SelectShapeCommand;
import view.interfaces.IObserver;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapeDraw implements IObserver {
	
	private static ShapeDraw shapeDraw = new ShapeDraw();
	private ShapeDraw() {
		
	}
	
	
	public void drawAllShapes(List<IShape> list, PaintCanvasBase paintCanvasBase) {
		
		Graphics2D graphics2d = paintCanvasBase.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, paintCanvasBase.getWidth(), paintCanvasBase.getHeight());
		
		for(int i=0; i<ShapeList.shapeList.size(); i++)
		{
			if(SelectShapeCommand.selectedShapesList.contains(ShapeList.shapeList.get(i)) && ShapeList.shapeList.get(i).getClass() != Composite.class) {
			new SelectDecorator(ShapeList.shapeList.get(i)).draw(DrawShapeHandler.paintCanvasBase);
			}
			else {
			ShapeList.shapeList.get(i).draw(DrawShapeHandler.paintCanvasBase);
			}
			
			if(SelectShapeCommand.selectedShapesList.contains(ShapeList.shapeList.get(i)) && ShapeList.shapeList.get(i).getClass() == Composite.class) {
				new SelectDecorator(ShapeList.shapeList.get(i)).draw(DrawShapeHandler.paintCanvasBase);
				//ShapeList.shapeList.get(i).draw(DrawShapeHandler.paintCanvasBase);
				}
			
			
			
		}
		
	}

	@Override
	public void update() {
		drawAllShapes(ShapeList.shapeList, DrawShapeHandler.paintCanvasBase);
		
	}


	public static ShapeDraw getShapeDraw() {
		return shapeDraw;
	}


	
	

}
