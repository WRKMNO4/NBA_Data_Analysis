package com.kmno4.presentation.button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.kmno4.presentation.MainFrame;

public class LMouseAdapter extends MouseAdapter {
	@Override
	public void mouseEntered(MouseEvent e) {
		enter(e);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		exit(e);
	}
	
	public static void enter(MouseEvent event) {
		if(event.getSource() instanceof JComboBox) return;
		((JComponent)event.getSource()).setOpaque(true);
		((JComponent)event.getSource()).setBackground(LMouseAdapter.L);
		MainFrame.mainFrame.repaint();
	}
	public static void exit(MouseEvent event) {
		if(event.getSource() instanceof JComboBox) return;
		((JComponent)event.getSource()).setOpaque(false);
		((JComponent)event.getSource()).setBackground(new Color(0, 0, 0, 0));
//		((JComponent)event.getSource()).getParent().repaint();
		MainFrame.mainFrame.repaint();
	}
	
	public static final Color L = new Color(255, 255, 255, 100);
}
