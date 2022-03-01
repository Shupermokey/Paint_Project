package view.gui;

import java.awt.Graphics2D;

import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawShapeHandler {
	
	public static PaintCanvasBase paintCanvasBase;
	public static ApplicationState appState;
	
	
	
	public DrawShapeHandler(PaintCanvasBase paintCanvasBase, ApplicationState appState){
        this.paintCanvasBase = paintCanvasBase;
        this.appState = appState;
       
    }

	public static void setPaintCanvasBase(PaintCanvasBase paintCanvasBase) {
		DrawShapeHandler.paintCanvasBase = paintCanvasBase;
	}

}
