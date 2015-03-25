package com.kmno4.presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
/**
 * 右键关闭
 * @author hutao
 *
 */
public class RightClickClose {
	JFrame theFrame;
	public RightClickClose(JFrame f) {
		theFrame = f;
		if(theFrame.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE) return;
		theFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3)
					theFrame.dispose();
			}
		});
	}
}
