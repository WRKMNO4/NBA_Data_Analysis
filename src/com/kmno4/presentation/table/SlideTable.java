package com.kmno4.presentation.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class SlideTable extends JPanel {
	public JLabel
	    right,
	    left;
	public SmallTable table;
	private SlideThread slideThread;
	
	private final int 
	    table_unit_height, 
	    table_unit_width,
	    table_ui_width;
	
	private final int tableX, tableY, tableWidth, tableHeight;
	public SlideTable(String[] headStr, String[][] bodyString, int tableUnitWidth, int tableUnitHeight, int tableUiWidth) {
		this(headStr, bodyString, 0, 0, tableUnitWidth, tableUnitHeight, tableUiWidth);
	}
	public SlideTable(String[] headStr, String[][] bodyString, int x, int y, int tableUnitWidth, int tableUnitHeight, int tableUiWidth) {
		super();
		table_unit_height = tableUnitHeight;
		table_unit_width = tableUnitWidth;
		table_ui_width = tableUiWidth;
		move_time = (double)150 / 1000;
		move_unit_time = (double)15 / 1000;
		move_unit_width = table_unit_width * move_unit_time / move_time;
		
		
		tableWidth = table_unit_width * headStr.length;
		tableHeight = table_unit_height * bodyString.length;
		max_address = headStr.length - table_ui_width / table_unit_width;
		setLayout(null);
		table = new SmallTable(headStr, bodyString);
		table.setLocation((tableX = x), (tableY = y));
		table.setSize(tableWidth, tableHeight);
		setSize(table_ui_width, tableHeight);
		add(table);

		left = new JLabel("←", JLabel.CENTER);
		left.setSize(FLIG_LABEL_WIDTH, (int)(table_unit_height * FLIG_LABEL_HEIGHT_RATE));
		left.setLocation(x + table_ui_width / 2 - left.getWidth(), tableHeight + y);
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
		
		right = new JLabel("→", JLabel.CENTER);
		right.setSize(FLIG_LABEL_WIDTH, left.getHeight());
		right.setLocation(x + table_ui_width / 2, left.getY());
		right.setEnabled(true);
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
			right.setEnabled(true);
			slideThread = new SlideThread();
			slideThread.start();
		}
	}
	
	
	private final double move_time;
	private final double move_unit_time;
	private final double move_unit_width;
	class SlideThread extends Thread {
		private double x, targetX;
		
		public void run() {
			while(moving != MOVING_DIE) {
				if(moving == MOVING_LEFT) {
					current_address ++;
					x = (double)table.getX();
					targetX = x - (double)table_unit_width;
					while(x > targetX) {
						x -= move_unit_width;
						table.setLocation((int)x, table.getY());
						try {
							Thread.sleep((long)(move_unit_time * 1000));
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
					targetX = x + (double)table_unit_width;
					while(x < targetX) {
						x += move_unit_width;
						table.setLocation((int)x, table.getY());
						try {
							Thread.sleep((long)(move_unit_time * 1000));
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
			}
		}
	}
}

