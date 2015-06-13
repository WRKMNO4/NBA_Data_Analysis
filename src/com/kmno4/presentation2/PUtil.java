package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;

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

}
