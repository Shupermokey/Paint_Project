package view.gui;

import java.awt.Color;
import java.util.EnumMap;

import model.ShapeColor;

public class EnumColorMap {
	
	public static final EnumMap<ShapeColor, Color> colorMapper = new EnumMap<>(ShapeColor.class);
	
	public static EnumMap<ShapeColor, Color> getColorMap() {
		colorMapper.put(ShapeColor.BLACK, Color.BLACK);
		colorMapper.put(ShapeColor.BLUE, Color.BLUE);
		colorMapper.put(ShapeColor.CYAN, Color.CYAN);
		colorMapper.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
		colorMapper.put(ShapeColor.GRAY, Color.GRAY);
		colorMapper.put(ShapeColor.GREEN, Color.GREEN);
		colorMapper.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
		colorMapper.put(ShapeColor.MAGENTA, Color.MAGENTA);
		colorMapper.put(ShapeColor.ORANGE, Color.ORANGE);
		colorMapper.put(ShapeColor.PINK, Color.PINK);
		colorMapper.put(ShapeColor.RED, Color.RED);
		colorMapper.put(ShapeColor.WHITE, Color.WHITE);
		colorMapper.put(ShapeColor.YELLOW, Color.YELLOW);
		
		return colorMapper;
	}

}
