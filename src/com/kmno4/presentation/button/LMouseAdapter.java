package com.kmno4.presentation.button;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.kmno4.presentation.MainFrame;

public class LMouseAdapter extends MouseAdapter {
	private JFrame frame;
	public LMouseAdapter(JFrame f) {
		frame = f;
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		enter(e);
		frame.repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		exit(e);
		frame.repaint();
	}
	
	public static void enter(MouseEvent event) {
		if(event.getSource() instanceof JComboBox) return;
		((JComponent)event.getSource()).setOpaque(true);
		((JComponent)event.getSource()).setBackground(L);

	}
	public static void exit(MouseEvent event) {
		if(event.getSource() instanceof JComboBox) return;
		((JComponent)event.getSource()).setOpaque(false);
		((JComponent)event.getSource()).setBackground(O);
	}
	
	public static final Color 
	    L = new Color(255, 255, 255, 100),
	    O = new Color(0, 0, 0, 0);
}
