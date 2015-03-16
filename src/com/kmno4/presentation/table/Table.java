package com.kmno4.presentation.table;
import java.awt.GridLayout;

import javax.swing.JPanel;
/**
 * table样式
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class Table extends JPanel {
	public TableList head;
	public TableList[] body;
	public TP turn;
	
	
	public Table(String[] headStr, String[][] bodyStr) {
		super();
		setSize(sizeX, sizeY);
		setOpaque(true);
		
		//setLayout(new GridBagLayout());
		setLayout(new GridLayout(0, 1));
		head = new TableList(headStr, TableList.HEAD);
		
		body = new TableList[bodyStr.length];
		for(int i = 0; i < bodyStr.length; i ++) {
			body[i] = new TableList(bodyStr[i], i % 2);
		}
		
		
		
		
		add(head);
		for(TableList t : body)
			add(t);
		//add(turn);
	}
	
	
	
	
	private static final int 
	    sizeX = 600,
	    sizeY = 400;

}
