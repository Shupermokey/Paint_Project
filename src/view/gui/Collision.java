package view.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import Commands.SelectShapeCommand;
import model.ShapeColor;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Collision {

	public static void calculateCollision(IShape shape1, IShape shape2, PaintCanvasBase paintCanvasBase) {
		Graphics2D graphics2d = paintCanvasBase.getGraphics2D();

		if (calculatingInbetweenX(((Shape) shape1).getStartPoint(), ((Shape) shape1).getEndPoint(),
				((Shape) shape2).getStartPoint(), ((Shape) shape2).getEndPoint())
				&& calculatingInbetweenY(((Shape) shape1).getStartPoint(), ((Shape) shape1).getEndPoint(),
						((Shape) shape2).getStartPoint(), ((Shape) shape2).getEndPoint())) {


			if (!SelectShapeCommand.selectedShapesList.contains(shape1)) {
				SelectShapeCommand.selectedShapesList.add((Shape) shape1);
				//ShapeDraw.getShapeDraw().update();
			}
		}
		
		  else { SelectShapeCommand.selectedShapesList.remove(shape1);
		   }
		 

	}



	private static boolean calculatingInbetweenX(Point start, Point end, Point checkStart, Point checkEnd) {

		if (start.getX() > end.getX()) {
			if (end.getX() < checkStart.getX() && checkStart.getX() < start.getX()
					|| end.getX() < checkEnd.getX() && checkEnd.getX() < start.getX()) {
				return true;
			}
			if (checkStart.getX() < end.getX() && checkEnd.getX() > start.getX()
					|| checkStart.getX() > start.getX() && checkEnd.getX() < end.getX()) {
				return true;
			}

		} else if (end.getX() > start.getX()) {
			if (start.getX() < checkStart.getX() && checkStart.getX() < end.getX()
					|| start.getX() < checkEnd.getX() && checkEnd.getX() < end.getX()) {
				return true;
			}
			if (checkStart.getX() < start.getX() && checkEnd.getX() > end.getX()
					|| checkStart.getX() > end.getX() && checkEnd.getX() < start.getX()) {
				return true;
			}
		}

		return false;
	}

	private static boolean calculatingInbetweenY(Point start, Point end, Point checkStart, Point checkEnd) {

		if (start.getY() > end.getY()) {
			if (end.getY() < checkStart.getY() && checkStart.getY() < start.getY()
					|| end.getY() < checkEnd.getY() && checkEnd.getY() < start.getY()) {
				return true;
			}
			if (checkStart.getY() > start.getY() && checkEnd.getY() < end.getY()
					|| checkStart.getY() < end.getY() && checkEnd.getY() > start.getY()) {
				return true;
			}
		} else if (end.getY() > start.getY()) {
			if (start.getY() < checkStart.getY() && checkStart.getY() < end.getY()
					|| start.getY() < checkEnd.getY() && checkEnd.getY() < end.getY()) {
				return true;
			}
			if (checkStart.getY() > end.getY() && checkEnd.getY() < start.getY()
					|| checkStart.getY() < start.getY() && checkEnd.getY() > end.getY()) {
				return true;
			}

		}

		return false;
	}

}
