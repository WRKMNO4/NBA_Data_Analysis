package com.kmno4.presentation.calendarPanel;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.alee.laf.WebLookAndFeel;
import com.kmno4.common.Config;

/**
 * @author gaoyang 测试类
 */
public class DateChooser extends JPanel {
	private static Point startp = null;
	private Point endp = null;

	public static void main(String[] args) {
		WebLookAndFeel.install();
		
//		this.setLayout(null);
//		this.setSize(658,370);
//		demobutton=new JButton("这是个按钮");
//		demobutton.setBounds(50, 100, 150, 50);
//		demobutton.setIcon(new ImageIcon("images/1.png"));
//		demobutton.setBorderPainted(false);
//		demobutton.setContentAreaFilled(false);
//		demobutton.setFocusPainted(false);
//		demobutton.setRolloverIcon(new ImageIcon("images/2.png"));
//		demobutton.setPressedIcon(new ImageIcon("images/3.png"));
		
		JFrame f = new JFrame();
		f.setLayout(null);
		JTextField txt1 = new JTextField();
		JTextField txt2 = new JTextField();
		txt1.setBounds(20, 50, 300, 30);
		txt2.setBounds(20, 80, 300, 30);
		
		JComboBox jc=new JComboBox();
		jc.setBounds(20, 110, 100,30);
		jc.setBackground(Color.BLACK);
		jc.setOpaque(false);
//		jc.setUI(new BasicComboBoxUI(){
//			@Override
//			public void installUI(JComponent c) {
//				// TODO Auto-generated method stub
//				super.installUI(c);
//				listBox.setForeground(Color.WHITE);
//				listBox.setSelectionBackground(new Color(0,0,0,0));
//				listBox.setSelectionForeground(Color.black);
//			}
//			
//			@Override
//			protected JButton createArrowButton() {
//				// TODO Auto-generated method stub
//				return super.createArrowButton();
//			}
//		});

		JButton bt=new JButton();
		bt.setBounds(20, 140, 100, 30);
		bt.setAutoscrolls(true);
		bt.setIcon(Config.CLOSE_ICON);
//		bt.setBackground(Color.black);
		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setFocusPainted(false);
		
		
		// 定义日历控件面板类
		CalendarPanel p = new CalendarPanel(txt1, "yyyy/MM/dd");
		p.initCalendarPanel();

		JLabel l = new JLabel("日历面板");
		p.add(l);
//		f.getContentPane().setBackground(Color.BLUE);
		f.getContentPane().add(p);
		f.getContentPane().add(txt1);
		f.getContentPane().add(txt2);
		f.getContentPane().add(jc);
		f.getContentPane().add(bt);
		f.setSize(500, 400);
		f.setBackground(Color.WHITE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}