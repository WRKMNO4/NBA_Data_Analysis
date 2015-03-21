package com.kmno4.presentation.button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class LabelButton extends JLabel {

	private LabelButton lb = this;
	public LabelButton(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		addSomething();
	}

	public LabelButton(Icon image) {
		super(image);
		addSomething();
	}

	public LabelButton(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		addSomething();
	}

	public LabelButton(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		addSomething();
	}

	public LabelButton(String text) {
		super(text);
		addSomething();
	}

	public LabelButton() {
		super();
		addSomething();
	}
	
	
	private void addSomething() {
//		lb.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(!lb.isEnabled()) return;
//				lb.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
//			}
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				lb.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
//			}
//			
//		});
	}

}
