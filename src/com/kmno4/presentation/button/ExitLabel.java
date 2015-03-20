package com.kmno4.presentation.button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ExitLabel extends LabelButton {
	private JFrame f;
	private Icon image;
	public ExitLabel(JFrame exitFrame) {
		super();
		f = exitFrame;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				f.dispose();
			}
		});
		image = new ImageIcon(IMAGE);
		setIcon(image);
		setSize(LABEL_X, LABEL_Y);
		setLocation(f.getWidth() - LABEL_X, 0);
	}
	
	private static final int 
	    LABEL_X = 15,
	    LABEL_Y = 15;
	//TODO
	private static final String IMAGE = "";
}
