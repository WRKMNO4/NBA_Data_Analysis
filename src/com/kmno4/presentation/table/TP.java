package com.kmno4.presentation.table;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.presentation.button.LabelButton;
/**
 * 翻页的部分，包括上一页、下一页等跳转
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TP extends JPanel {
	public static int page = 0;
	
	private JLabel 
	    firstPage,
	    beforePage,
	    nextPage,
	    lastPage,
	    nowaPage;
	
	private Table table;
	private GridLayout layout;
	
	public TP(Table t) {
		super();
		this.table = t;
		layout = new GridLayout(1, 0);
		setLayout(layout);
		
		firstPage = new LabelButton("first", JLabel.RIGHT);
		firstPage.setForeground(Color.GRAY);
		firstPage.setFont(TP_FONT);
		firstPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToFirstPage(table);
			}
		});
		add(firstPage);
		
		beforePage = new LabelButton("←", JLabel.CENTER);
		beforePage.setForeground(Color.GRAY);
		beforePage.setFont(TP_FONT);
		beforePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToBeforePage(table);
			}
		});
		if(page == 0) beforePage.setEnabled(false);
		else beforePage.setEnabled(true);
		add(beforePage);
		
		nowaPage = new JLabel( "-"+(page + 1)+"-", JLabel.CENTER);
		nowaPage.setForeground(Color.GRAY);
		nowaPage.setFont(TP_FONT);
		add(nowaPage);
		
		nextPage = new LabelButton("→", JLabel.CENTER);
		nextPage.setForeground(Color.GRAY);
		nextPage.setFont(TP_FONT);
		nextPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToNextPage(table);
			}
		});
		if(page == (table.getPageNum() - 1)) nextPage.setEnabled(false);
		else nextPage.setEnabled(true);
		add(nextPage);
		
		lastPage = new LabelButton("last", JLabel.LEFT);
		lastPage.setForeground(Color.GRAY);
		lastPage.setFont(TP_FONT);
		lastPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToLastPage(table);
			}
		});
		add(lastPage);
		
	}
	
	private void turnToFirstPage(Table table) {
		if(page == 0) return;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[page][i].setVisible(false);
		    table.remove(table.body[page][i]);
		    layout.removeLayoutComponent(table.body[page][i]);
		}
		page = 0;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[TP.page][i].setVisible(true);
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	private void turnToBeforePage(Table table) {
		if(page == 0) return;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[page][i].setVisible(false);
		    table.remove(table.body[page][i]);
		}
		page --;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[TP.page][i].setVisible(true);
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	private void turnToNextPage(Table table) {
		if(page == (table.getPageNum() - 1)) return;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[page][i].setVisible(false);
		    table.remove(table.body[page][i]);
		}
		page ++;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[TP.page][i].setVisible(true);
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	private void turnToLastPage(Table table) {
		if(page == (table.getPageNum() - 1)) return;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[page][i].setVisible(false);
		    table.remove(table.body[page][i]);
		}
		page = table.getPageNum() - 1;
		for(int i = 0; i < table.rowNum; i ++) {
			table.body[TP.page][i].setVisible(true);
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	
	private void otherSet() {
		System.out.println(TP.page);
		table.remove(table.turn);
		table.add(table.turn);
		nowaPage.setText("-" + (page + 1)+"-");
		table.repaint();
		beforePage.setEnabled(page == 0 ? false : true);
		nextPage.setEnabled(page == (table.getPageNum() - 1) ? false : true);
	}
	
	private static final Font TP_FONT = new Font("Arial", Font.BOLD, 18);
	
}
