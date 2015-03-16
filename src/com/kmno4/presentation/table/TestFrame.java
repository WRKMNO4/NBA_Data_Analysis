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
					    {"aa0", "bb", "cc", "dd"},
					    {"aaa1", "bbb", "ccc", "ddd"},
					    {"aaa2", "bbb", "ccc", "ddd"},
					    {"aaa3", "bbb", "ccc", "ddd"},
					    {"aaa4", "bbb", "ccc", "ddd"},
					    {"aaa5", "bbb", "ccc", "ddd"},
					    {"aaa6", "bbb", "ccc", "ddd"},
					    {"aaa7", "bbb", "ccc", "ddd"},
					    {"aaa8", "bbb", "ccc", "ddd"},
					    {"aaa9", "bbb", "ccc", "ddd"}
				    });
		t.setBounds(0, 0, 600, 400);
		
		add(t);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestFrame t = new TestFrame();
	}

}
