package view.interfaces;

import javax.swing.*;

import view.gui.MouseClickHandler;

import java.awt.*;


public abstract class PaintCanvasBase extends JComponent {	
	
	//MouseClickHandler handler = new MouseClickHandler(this);
	
    public abstract Graphics2D getGraphics2D();
}
