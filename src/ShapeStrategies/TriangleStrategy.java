package ShapeStrategies;

import java.awt.Graphics2D;

import model.ShapeType;
import view.gui.EnumColorMap;
import view.gui.Shape;
import view.interfaces.PaintCanvasBase;

public class TriangleStrategy implements IShapeStrategies {
	@Override
	public void shapeStrategy(Shape shape,PaintCanvasBase paintCanvasBase) {
		Graphics2D graphics2d = paintCanvasBase.getGraphics2D();
		graphics2d.setColor(EnumColorMap.colorMapper.get(shape.primary));
		graphics2d.fillPolygon(new int[] {shape.getStartPoint().getX(),(shape.getStartPoint().getX()+shape.getEndPoint().getX())/2,shape.endPoint.getX()}, new int[] {shape.endPoint.getY(),shape.getStartPoint().getY(),shape.endPoint.getY()}, 3);
		
	}

}
