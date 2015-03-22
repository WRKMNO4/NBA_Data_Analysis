package com.kmno4.presentation.button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class ExitLabel extends JLabel {
	private JFrame f;
	public ExitLabel(JFrame exitFrame) {
		super();
		f = exitFrame;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				f.dispose();
			}
		});
		setIcon(Config.CLOSE_ICON);
		setSize(LABEL_X, LABEL_Y);
		setLocation(f.getWidth() - 100, 5);
	}
	
	private static final int 
	    LABEL_X = 100,
	    LABEL_Y = 10;
}
