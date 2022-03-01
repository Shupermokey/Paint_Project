package ShapeStrategies;

import java.awt.Graphics2D;

import model.ShapeType;
import view.gui.EnumColorMap;
import view.gui.Shape;
import view.interfaces.PaintCanvasBase;

public class RectangleStrategy implements IShapeStrategies{

	@Override
	public void shapeStrategy(Shape shape,PaintCanvasBase paintCanvasBase) {
		Graphics2D graphics2d = paintCanvasBase.getGraphics2D();
		graphics2d.setColor(EnumColorMap.colorMapper.get(shape.primary));
		graphics2d.fillRect(shape.startPoint.getX(), shape.startPoint.getY(), shape.width, shape.height);
		
	}
}
