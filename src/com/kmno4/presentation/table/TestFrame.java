package com.kmno4.presentation.table;

import javax.swing.JFrame;
/**
 * 专门用来测试的一个frame 没什么大用
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TestFrame extends JFrame{
	
	public TestFrame() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[][] str = new String[100][4];
		for (int i = 0 ; i < str.length; i ++) {
			str[i][0] = new String("aaa" + i);
			str[i][1] = "b";
			str[i][2] = "c";
			str[i][3] = "d";
		}
		
		Table t = new Table(
				    new String[]{"a", "b", "c", "d"}, 
				    str);
		
		t.setBounds(50, 50, 600, 400);
		
		add(t);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TestFrame t = new TestFrame();
	}

}
