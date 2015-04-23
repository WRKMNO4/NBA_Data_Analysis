package com.kmno4.presentation.table;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;

import com.kmno4.presentation.SplashPanel;

/**
 * 小数据的table,
 * 隐藏翻页的功能,
 * 取消表头翻转
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SmallTable extends Table {

	public SmallTable(String[] headStr, String[][] bodyString) {
		super(headStr, bodyString, bodyString.length);
		hidtp();
		removeHeadListener();
//		new myThread().start();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
	
	private void hidtp() {
		turn.setVisible(false);
		remove(turn);
		setLayout(new GridLayout(rowNum + 1, 1));
	}
	private void removeHeadListener() {
		if(flip == null) return;
		head.removeMouseListener(flip);
	}
	
	class myThread extends Thread{
		
		@Override
		public void run() {
			long begin_time = System.currentTimeMillis();
			JFrame GFrame = new JFrame(); // 创建窗口
			SplashPanel DPanel = new SplashPanel(); // 创建画板
			DPanel.getBg().setVisible(false);
			DPanel.setOpaque(true);
			GFrame.setBackground(new Color(0,0,0,0));
			/* 设置JFrame */
			GFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GFrame.setUndecorated(true);
			GFrame.setSize(getWidth(), getHeight());
			GFrame.setLocationRelativeTo(null);
			GFrame.setVisible(true);
			GFrame.add(DPanel); // 在JFrame中加入DPanel
			DPanel.launch();
			while (true) {
				if (System.currentTimeMillis() - begin_time > 1000) {
					GFrame.dispose();
					break;
				}
			}
			repaint();
			this.stop();
		}
	}

}
