package com.kmno4.presentation.table;

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
	
	public TP(Table table) {
		super();
		this.table = table;
		setLayout(new GridLayout(1, 0));
		
		
		firstPage = new LabelButton("FirstPage", JLabel.CENTER);
		firstPage.setFont(TP_FONT);
		firstPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToFirstPage();
			}
		});
		add(firstPage);
		
		beforePage = new LabelButton("<<", JLabel.CENTER);
		beforePage.setFont(TP_FONT);
		beforePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToBeforePage();
			}
		});
		if(page == 0) beforePage.setEnabled(false);
		else beforePage.setEnabled(true);
		add(beforePage);
		
		nowaPage = new JLabel("page " + (page + 1), JLabel.CENTER);
		nowaPage.setFont(TP_FONT);
		add(nowaPage);
		
		nextPage = new LabelButton(">>", JLabel.CENTER);
		nextPage.setFont(TP_FONT);
		nextPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToNextPage();
			}
		});
		if(page == (table.getPageNum() - 1)) nextPage.setEnabled(false);
		else nextPage.setEnabled(true);
		add(nextPage);
		
		lastPage = new LabelButton("LastPage", JLabel.CENTER);
		lastPage.setFont(TP_FONT);
		lastPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				turnToLastPage();
			}
		});
		add(lastPage);
		
	}
	
	private void turnToFirstPage() {
		if(page == 0) return;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.remove(table.body[page][i]);
		}
		page = 0;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	private void turnToBeforePage() {
		if(page == 0) return;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.remove(table.body[page][i]);
		}
		page --;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	private void turnToNextPage() {
		if(page == (table.getPageNum() - 1)) return;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.remove(table.body[page][i]);
		}
		page ++;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	private void turnToLastPage() {
		if(page == (table.getPageNum() - 1)) return;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.remove(table.body[page][i]);
		}
		page = table.getPageNum() - 1;
		for(int i = 0; i < Table.rowNum; i ++) {
		    table.add(table.body[TP.page][i]);
		}
		otherSet();
	}
	
	private void otherSet() {
		table.remove(table.turn);
		table.add(table.turn);
		nowaPage.setText("page " + (page + 1));
		table.repaint();
		beforePage.setEnabled(page == 0 ? false : true);
		nextPage.setEnabled(page == (table.getPageNum() - 1) ? false : true);
	}
	
	private static final Font TP_FONT = new Font("Arial", Font.BOLD, 18);
	
}
