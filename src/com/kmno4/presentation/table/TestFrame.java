package com.kmno4.presentation.table;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestFrame extends JFrame{
	
	public TestFrame() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Table t = new Table(
				    new String[]{"a", "b", "c", "d"}, 
				    new String[][]{
					    {"aa", "bb", "cc", "dd"},
					    {"aaa", "bbb", "ccc", "ddd"},
					    {"aaa", "bbb", "ccc", "ddd"},
					    {"aaa", "bbb", "ccc", "ddd"},
					    {"aaa", "bbb", "ccc", "ddd"}
				    });
		t.setLocation(0, 0);
		
		add(t);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestFrame t = new TestFrame();
	}

}
