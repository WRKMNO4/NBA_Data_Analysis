package com.kmno4.presentation.table;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
	    
	
	public TP() {
		super();
		setLayout(new GridLayout(1, 0));
		/*
		Font TP_FONT = null;
		try {
			TP_FONT = Font.createFont(Font.TRUETYPE_FONT, new File("font/tp_font.TTF"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TP_FONT.
		
		firstPage = new JLabel("首页", JLabel.CENTER);
		firstPage.setFont(TP_FONT);
		add(firstPage);
		
		beforePage = new JLabel("前页", JLabel.CENTER);
		beforePage.setFont(TP_FONT);
		add(beforePage);
		
		nowaPage = new JLabel("当前页数：" + page, JLabel.CENTER);
		nowaPage.setFont(TP_FONT);
		add(nowaPage);
		
		nextPage = new JLabel("后页", JLabel.CENTER);
		nextPage.setFont(TP_FONT);
		add(nextPage);
		
		lastPage = new JLabel("末页", JLabel.CENTER);
		lastPage.setFont(TP_FONT);
		add(lastPage);
		*/
	}
	
	
}
