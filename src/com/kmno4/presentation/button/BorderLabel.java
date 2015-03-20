package com.kmno4.presentation.button;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BorderLabel extends JLabel {

	public BorderLabel() {
		super();
		// TODO Auto-generated constructor stub
		setBorder();
	}

	public BorderLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
		setBorder();
	}

	public BorderLabel(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
		setBorder();
	}

	public BorderLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
		setBorder();
	}

	public BorderLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
		setBorder();
	}

	public BorderLabel(String text) {
		super(text);
		// TODO Auto-generated constructor stub
		setBorder();
	}
	
	private void setBorder() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
