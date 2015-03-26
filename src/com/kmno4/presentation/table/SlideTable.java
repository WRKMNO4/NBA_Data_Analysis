package com.kmno4.presentation.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.BorderLabel;

/**
 * TODO 更动感的移动
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SlideTable extends JPanel {
	private JLabel
	    right,
	    left;
	private SmallTable table;
	private SlideThread slideThread;
	
	public SlideTable(String[] headStr, String[][] bodyString) {
		this(headStr, bodyString, 0, 0, TABLE_UNIT_WIDTH * headStr.length, TABLE_HEIGHT);
	}
	private static final int TABLE_HEIGHT = 50;
	private static final int TABLE_UNIT_WIDTH = 70;
	
	@SuppressWarnings("unused")
	private final int tableX, tableY, tableWidth, tableHeight;
	public SlideTable(String[] headStr, String[][] bodyString, int x, int y, int width, int height) {
		super();
		max_address = headStr.length - Config.PLAYER_DETAIL_UI_WIDTH / TABLE_UNIT_WIDTH;
		setLayout(null);
		table = new SmallTable(headStr, bodyString);
		table.setLocation((tableX = x), (tableY = y));
		table.setSize((tableWidth = width), (tableHeight = height));
		add(table);

		left = new BorderLabel("←", JLabel.CENTER);
		left.setBounds(x, tableHeight + y, FLIG_LABEL_WIDTH, (int)(height * FLIG_LABEL_HEIGHT_RATE));
		left.setEnabled(false);
		left.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(!left.isEnabled()) return;
				moving = MOVING_RIGHT;
			}
			public void mouseExited(MouseEvent e) {
				if(!left.isEnabled()) return;
				moving = MOVING_NONE;
			}
		});
		add(left);
		
		right = new BorderLabel("→", JLabel.CENTER);
		right.setBounds(x + left.getWidth(), left.getY(), FLIG_LABEL_WIDTH, (int)(height * FLIG_LABEL_HEIGHT_RATE));
		right.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(!right.isEnabled()) return;
				moving = MOVING_LEFT; 
			}
			public void mouseExited(MouseEvent e) {
				if(!right.isEnabled()) return;
				moving = MOVING_NONE; 
			}
		});
		add(right);
		
		slideThread = new SlideThread();
		slideThread.start();
	}
	private static final int FLIG_LABEL_WIDTH = 50;
	private static final double FLIG_LABEL_HEIGHT_RATE = 0.3;
	
	private int current_address = 0;
	private final int max_address;
	private int moving = 0;
	private static final int
	    MOVING_LEFT = -1,
	    MOVING_NONE = 0,
	    MOVING_RIGHT = 1,
	    MOVING_DIE = 2;
	
	
	
	
	
	
	public void setFont(Font headFont, Font bodyFont, Font labelFont) {
		table.setFont(headFont, bodyFont);
		if(labelFont != null) {
			right.setFont(labelFont);
			left.setFont(labelFont);
		}
	}
	public void setForeground(Color headColor, Color bodyColor, Color labelColor) {
		table.setForeground(headColor, bodyColor);
		if(labelColor != null) {
			right.setForeground(labelColor);
			left.setForeground(labelColor);
		}
	}
	public void setBackground(Color headbg, Color bodybg, Color labelbg, Color bg) {
		super.setBackground(bg);
		table.setBackground(headbg, bodybg);
		if(labelbg != null) {
			right.setBackground(labelbg);
			left.setBackground(labelbg);
		}
	}
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if(!aFlag) { moving = MOVING_DIE; }
		else {
			if(slideThread != null && slideThread.isAlive()) return;
			table.setLocation(tableX, tableY);
			current_address = 0;
			moving = MOVING_NONE;
			left.setEnabled(false);
			slideThread = new SlideThread();
			slideThread.start();
		}
	}
	
	
	private static final double MOVE_TIME = (double)60 / 1000;
	private static final double MOVE_UNIT_TIME = (double)10 / 1000;
	private static final double MOVE_UNIT_WIDTH = TABLE_UNIT_WIDTH * MOVE_UNIT_TIME / MOVE_TIME;
	class SlideThread extends Thread {
		private double x, targetX;
		
		public void run() {
			while(moving != MOVING_DIE) {
				if(moving == MOVING_LEFT) {
					current_address ++;
					x = (double)table.getX();
					targetX = x - (double)TABLE_UNIT_WIDTH;
					while(x > targetX) {
						x -= MOVE_UNIT_WIDTH;
						table.setLocation((int)x, table.getY());
						try {
							Thread.sleep((long)(MOVE_UNIT_TIME * 1000));
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
					}
					table.setLocation((int)targetX, table.getY());
					if(current_address == max_address) {
						right.setEnabled(false);
						moving = MOVING_NONE;
					}
					if(!left.isEnabled()) left.setEnabled(true);
				}
				else if(moving == MOVING_RIGHT) {
					current_address --;
					x = (double)table.getX();
					targetX = x + (double)TABLE_UNIT_WIDTH;
					while(x < targetX) {
						x += MOVE_UNIT_WIDTH;
						table.setLocation((int)x, table.getY());
						try {
							Thread.sleep((long)(MOVE_UNIT_TIME * 1000));
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
					}
					table.setLocation((int)targetX, table.getY());
					if(current_address == 0) {
						left.setEnabled(false);
						moving = MOVING_NONE;
					}
					if(!right.isEnabled()) right.setEnabled(true);
				}
				try {
					Thread.sleep((long)(MOVE_TIME * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

