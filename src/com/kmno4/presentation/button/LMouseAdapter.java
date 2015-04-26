package com.kmno4.presentation.button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class LMouseAdapter extends MouseAdapter {
	@Override
	public void mouseEntered(MouseEvent e) {
		((JComponent)e.getSource()).setOpaque(true);
		((JComponent)e.getSource()).setBackground(LMouseAdapter.L);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		((JComponent)e.getSource()).setOpaque(false);
	}
	
	public static final Color L = new Color(255, 255, 255, 100);
}
