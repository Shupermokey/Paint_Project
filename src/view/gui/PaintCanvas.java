package view.gui;

import view.interfaces.PaintCanvasBase;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseListener;

public class PaintCanvas extends PaintCanvasBase {
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
    

    
   
}
