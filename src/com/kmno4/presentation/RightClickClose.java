package com.kmno4.presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
/**
 * 右键关闭的工具类
 * @author hutao
 *
 * 在写的每一个JFrame子类的最后面写上
 * 
 * RightClickClose r = new RightClickClose(this);
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
