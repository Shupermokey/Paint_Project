package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.DrawShapeHandler;
import view.gui.EnumColorMap;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.MouseClickHandler;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;

import Commands.CommandHistory;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
       // DrawShapeHandler.paintCanvasBase = paintCanvas;
        DrawShapeHandler.appState = appState;
        MouseClickHandler mouse = new MouseClickHandler(paintCanvas, appState);
        paintCanvas.addMouseListener(mouse);
        EnumColorMap.getColorMap();
        
        controller.setup();

        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        
         
        
        
        
     
       
    }
}
