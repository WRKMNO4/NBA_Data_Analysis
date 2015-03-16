package com.kmno4.presentation.table;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Table extends JPanel {
	public TableList head;
	public TableList[] body;
	public TP turn;
	
	
	public Table(String[] headStr, String[][] bodyStr) {
		super();
		setSize(sizeX, sizeY);
		setOpaque(true);
		head = new TableList(headStr, TableList.head);
		
		
		
		
		
		
		add(head);
		//for(TableList t : body)
			//add(t);
		//add(turn);
	}
	
	
	
	
	private static final int 
	    sizeX = 600,
	    sizeY = 400;
	

}
