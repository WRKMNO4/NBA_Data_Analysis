package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class PUtil {
	
	public static void setFontandColor(JComponent com, int num, Color color) {
		com.setFont(new Font("default", 0, num));
		com.setForeground(color);
	}
	public static void setFontandColor(JComponent com, Font font, Color color) {
		com.setFont(font);
		com.setForeground(color);
	}
	
	public static void setCache() {
		File f = new File("cache");
		if(!f.exists())
			try {
				new File("cache/readme").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		ImageIO.setCacheDirectory(f);
	}

}
